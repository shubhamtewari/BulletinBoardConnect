package database;

import core.BoardStructure;

/**
 * interface to manipulate the application database
 */
public interface DatabaseManipulatable {
    default void testUpload(DatabaseConnectable databaseConnectable, BoardStructure object) throws Exception{
        System.out.println("No test added:|");
    }
}
