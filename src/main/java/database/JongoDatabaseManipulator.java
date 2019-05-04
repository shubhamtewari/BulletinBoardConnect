package database;

import core.BoardStructure;
import core.NoticeStructure;

import java.io.File;
import java.io.IOException;

/**
 * handles the manipulation of the mongodb database
 * insert, delete update etc
 */
public abstract class JongoDatabaseManipulator implements DatabaseManipulatable {

    public void uploadBoard(BoardStructure object) throws Exception {

    }


    public void uploadHPP(File fileImage, boolean update, NoticeStructure noticeStructure) throws IOException {

    }
}
