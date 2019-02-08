package database;

public interface DatabaseConnectable {
    /**
     * setup a connection with the database
     * @param flag true if connection can be established
     * @return true/false
     * @throws Exception a general exception
     */
    boolean setupConnection(boolean flag, String path)throws Exception;
}
