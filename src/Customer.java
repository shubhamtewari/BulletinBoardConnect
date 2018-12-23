/**
 * the default user
 */
public class Customer {
    private String name;//name of the customer
    protected boolean writeAccess;//access to write to board (except high priority notices)
    protected boolean administrator;//access to manage the notices and write hogh priority notices

    /*
    constructor
    all privileges false
     */
    Customer(String name) {
        this.name = name;
    }

    //getter methods
    public String getName() {
        return name;
    }

    public boolean isWriteAccess() {
        return writeAccess;
    }

    public boolean isAdministrator() {
        return administrator;
    }
}
