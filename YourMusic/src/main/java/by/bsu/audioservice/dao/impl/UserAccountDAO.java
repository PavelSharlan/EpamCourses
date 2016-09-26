package by.bsu.audioservice.dao.impl;

import by.bsu.audioservice.dao.AbstractUserAccountDAO;
import by.bsu.audioservice.entity.Role;
import by.bsu.audioservice.entity.User;
import by.bsu.audioservice.entity.UserAccount;
import by.bsu.audioservice.exception.DAOException;
import by.bsu.audioservice.pool.ConnectionPool;
import by.bsu.audioservice.pool.ProxyConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by 7 on 10.08.2016.
 */
public class UserAccountDAO extends AbstractUserAccountDAO {
    private static final String SQL_SELECT_ACCOUNT_BY_USER_ID = "SELECT acc.account_id, acc.balance, acc.creating_date," +
            " acc.end_date FROM accounts AS acc JOIN users ON acc.user_id = users.user_id WHERE users.user_id = ?;";
    private static final String SQL_INSERT_USER_ACCOUNT = "INSERT INTO accounts (user_id, creating_date, balance)" +
            " VALUES (?, ?, ?);";
    private static final String SQL_IS_ACCOUNT_HAS_AUDIO = "SELECT id FROM account_has_audios WHERE account_id = ? AND audio_id = ?;";
    private static final String SQL_USER_ADD_AUDIO = "INSERT INTO account_has_audios (account_id, audio_id) VALUES(?, ?);";
    private static final String SQL_UPDATE_BALANCE = "UPDATE accounts SET accounts.balance = ? WHERE accounts.account_id = ?;";
    private static final String SQL_DELETE_AUDIO_FROM_USER_ACCOUNT = "DELETE FROM account_has_audios WHERE " +
            "account_id = ? AND audio_id = ?;";
    private static final String SQL_SELECT_ALL_ACCOUNTS = "SELECT u.user_id, u.first_name, u.last_name, u.email, " +
            "u.password, u.phone_number, u.role, acc.account_id, acc.creating_date, " +
            "acc.end_date, acc.balance FROM users AS u JOIN accounts AS acc WHERE u.user_id = acc.user_id;";
    private static final String SQL_BAN_ACCOUNT = "UPDATE accounts SET end_date = ? WHERE account_id = ?;";
    private static final String SQL_UNBAN_ACCOUNT = "UPDATE accounts SET end_date = NULL where account_id = ?;";

    private static final String ACCOUNT_ID = "account_id";
    private static final String BALANCE = "balance";
    private static final String CREATING_DATE = "creating_date";
    private static final String END_DATE = "end_date";
    private static final String USER_ID = "user_id";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String PHONE_NUMBER = "phone_number";
    private static final String ROLE = "role";

    private static UserAccountDAO instance = UserAccountDAO.getInstance();

    private static final Logger LOGGER = LogManager.getLogger(UserAccountDAO.class);
    private UserAccountDAO(){
    }

    public static UserAccountDAO getInstance(){
        if (instance == null){
            instance = new UserAccountDAO();
        }
        return instance;
    }

    @Override
    public UserAccount findUserAccountByUserId(Long id) throws DAOException {
        UserAccount account = null;
        boolean flag = false;
        try(ProxyConnection cn = ConnectionPool.getInstance().takeConnection();
            PreparedStatement st = cn.prepareStatement(SQL_SELECT_ACCOUNT_BY_USER_ID)){
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            flag = rs.next();
            if (flag){
                User user = UserDAO.getInstance().findUserByUserID(id);
                Long accountID = rs.getLong(ACCOUNT_ID);
                String creatingDate = rs.getString(CREATING_DATE);
                String endDate = rs.getString(END_DATE);
                Float balance = rs.getFloat(BALANCE);
                account = new UserAccount(accountID, user, creatingDate, endDate, balance);
            }
        } catch (SQLException e) {
            throw new DAOException("SQLException in DAO layer!", e);
        }
        return account;
    }

    @Override
    public boolean addUserAccount(UserAccount account) throws DAOException {
        boolean flag = false;
        try(ProxyConnection cn = ConnectionPool.getInstance().takeConnection();
            PreparedStatement st = cn.prepareStatement(SQL_INSERT_USER_ACCOUNT);) {
            User user = account.getUser();
            user = UserDAO.getInstance().findUserByEmail(user.getEmail());
            st.setLong(1, user.getUserId());
            st.setString(2, account.getCreatingDate());
            st.setFloat(3, account.getBalance());
            st.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            throw new DAOException("SQLException in DAO layer!", e);
        }
        return flag;
    }

    @Override
    public boolean isAccountHasAudio(Long accountId, Long audioId) throws DAOException {
        boolean flag = false;
        try(ProxyConnection cn = ConnectionPool.getInstance().takeConnection();
        PreparedStatement st = cn.prepareStatement(SQL_IS_ACCOUNT_HAS_AUDIO)){
            st.setLong(1, accountId);
            st.setLong(2, audioId);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                flag = true;
            }
        } catch (SQLException e) {
            throw new DAOException("SQLException", e);
        }
        return flag;
    }

    @Override
    public boolean addAudio(Long accountId, Long audioId) throws DAOException {
        boolean flag = false;
        try(ProxyConnection cn = ConnectionPool.getInstance().takeConnection();
        PreparedStatement st = cn.prepareStatement(SQL_USER_ADD_AUDIO)){
            st.setLong(1, accountId);
            st.setLong(2, audioId);
            st.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            throw new DAOException("SQLException", e);
        }
        return flag;
    }

    @Override
    public boolean updateBalance(Long accountId, Float balance) throws DAOException {
        boolean flag = false;
        try(ProxyConnection cn = ConnectionPool.getInstance().takeConnection();
        PreparedStatement st = cn.prepareStatement(SQL_UPDATE_BALANCE)){
            st.setFloat(1, balance);
            st.setLong(2, accountId);
            st.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            throw new DAOException("SQLException", e);
        }
        return flag;
    }

    @Override
    public boolean deleteAudioFromUserAccount(Long audioId, Long accountId) throws DAOException {
        boolean flag = false;
        try(ProxyConnection cn = ConnectionPool.getInstance().takeConnection();
        PreparedStatement st = cn.prepareStatement(SQL_DELETE_AUDIO_FROM_USER_ACCOUNT)){
            st.setLong(1, accountId);
            st.setLong(2, audioId);
            st.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            throw new DAOException("SQLException id DAO Layer(deleteAudioFromUserAccount)", e);
        }
        return flag;
    }

    @Override
    public ArrayList<UserAccount> takeAllAccounts() throws DAOException {
        ArrayList<UserAccount> accounts = new ArrayList<UserAccount>();
        try(ProxyConnection cn = ConnectionPool.getInstance().takeConnection();
        PreparedStatement st = cn.prepareStatement(SQL_SELECT_ALL_ACCOUNTS)){
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Long userId = rs.getLong(USER_ID);
                String firstName = rs.getString(FIRST_NAME);
                String lastName = rs.getString(LAST_NAME);
                String email = rs.getString(EMAIL);
                String password = rs.getString(PASSWORD);
                String phoneNumber = rs.getString(PHONE_NUMBER);
                Role role = Role.valueOf(rs.getString(ROLE).toUpperCase());
                User user = new User(userId, firstName, lastName, email, password, phoneNumber, role);
                Long accountID = rs.getLong(ACCOUNT_ID);
                String creatingDate = rs.getString(CREATING_DATE);
                String endDate = rs.getString(END_DATE);
                Float balance = rs.getFloat(BALANCE);
                UserAccount account = new UserAccount(accountID, user, creatingDate, endDate, balance);
                accounts.add(account);
            }
        } catch (SQLException e) {
            throw new DAOException("SQLException in UserAccountDAO(takeAllAccounts)", e);
        }
        return accounts;
    }

    @Override
    public boolean banAccount(Long accountId) throws DAOException {
        boolean flag = false;
        try(ProxyConnection cn = ConnectionPool.getInstance().takeConnection();
        PreparedStatement st = cn.prepareStatement(SQL_BAN_ACCOUNT)){
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            st.setDate(1, java.sql.Date.valueOf(dateFormat.format(date)));
            st.setLong(2, accountId);
            st.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            throw new DAOException("SQLException in UserAccountDAO(banAccount)", e);
        }
        return flag;
    }

    @Override
    public boolean unbanAccount(Long accountId) throws DAOException {
        boolean flag = false;
        try(ProxyConnection cn = ConnectionPool.getInstance().takeConnection();
        PreparedStatement st = cn.prepareStatement(SQL_UNBAN_ACCOUNT)){
            st.setLong(1, accountId);
            st.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            throw new DAOException("SQLException in USerAccountDAO(unbanAccount)", e);
        }
        return flag;
    }
}
