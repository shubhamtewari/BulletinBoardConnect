package core;

import java.io.Serializable;

/**
 * the default user
 */
public class CustomerStructure implements Serializable {
    private String name;//name of the customer
    protected boolean writeAccess;//access to write to board (except high priority notices)
    protected boolean administrator;//access to manage the notices and write hogh priority notices

    /*
    constructor
    all privileges false
     */
    public CustomerStructure(String name) {
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

    //setter

    public void setName(String name) {
        this.name = name;
    }

    public void setWriteAccess(boolean writeAccess) {
        this.writeAccess = writeAccess;
    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }
}
