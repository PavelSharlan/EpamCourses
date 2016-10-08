package by.bsu.logistics.entity;


/**
 * Created by 7 on 02.06.2016.
 */
public class Van{
    private boolean isPerishable;
    private Purpose purpose;
    private int id;

    public Van(boolean isPerishable, Purpose purpose, int id) {
        this.isPerishable = isPerishable;
        this.purpose = purpose;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPerishable() {
        return isPerishable;
    }

    public void setPerishable(boolean isPerishable) {
        this.isPerishable = isPerishable;
    }

    public Purpose getPurpose() {
        return purpose;
    }

    public void setPurpose(Purpose purpose) { this.purpose = purpose; }
}
