package database;

import core.BoardStructure;
import core.NoticeStructure;

import java.io.File;
import java.io.IOException;

/**
 * interface to manipulate the application database
 */
public interface DatabaseManipulatable {
    default void uploadBoard(BoardStructure object, String string) throws Exception{
        System.out.println("No test added:|");
    }

    void uploadHPP(File fileImage, boolean update, NoticeStructure noticeStructure, String string)throws IOException;
}
