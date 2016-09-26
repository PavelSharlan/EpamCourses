package by.bsu.audioservice.command;

import by.bsu.audioservice.command.impl.*;

/**
 * Created by 7 on 19.07.2016.
 */
public enum CommandType {
    EMPTY_COMMAND(new EmptyCommand()),
    LOGIN(new LoginCommand()),
    REGISTER(new RegisterCommand()),
    LANGUAGE(new LanguageCommand()),
    LOGIN_ROUTE(new LoginRouteCommand()),
    LOGOUT(new LogOutCommand()),
    EDIT_USER_SETTINGS_ROUTE(new EditUserSettingsRouteCommand()),
    EDIT_PASSWORD(new ChangePasswordCommand()),
    ALL_AUDIOS_ROUTE(new GuestAudiosRouteCommand()),
    ABOUT_US_ROUTE(new AboutUsRouteCommand()),
    USER_CABINET_ROUTE(new UserCabinetRouteCommand()),
    SHOW_ALL_AUDIOS(new ShowAllAudioCommand()),
    ORDER_AUDIO(new MakeOrderAudioCommand()),
    ORDERS_ROUTE(new OrdersRouteCommand()),
    SORT_MUSIC(new SortAudioCommand()),
    ADMIN_CABINET_ROUTE(new AdminCabinetRouteCommand()),
    EDIT_AUDIO_INFO(new EditAudioInfoCommand()),
    MAIN_PAGE_ROUTE(new MainPageRouteCommand()),
    SHOW_ALL_USERS_ROUTE(new ShowAllUsersAccountsCommand()),
    COMMENTS_ROUTE(new CommentsRouteCommand()),
    EDIT_AUDIO_INFO_ROUTE(new EditAudioInfoRouteCommand()),
    PUT_MONEY(new PutMoneyCommand()),
    EDIT_USER_SETTINGS(new EditUserSettingsCommand()),
    BAN_ACCOUNT(new BanAccountCommand()),
    UNBAN_ACCOUNT(new UnbanAccountCommand());

    private Command command;

    CommandType(Command command){
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
