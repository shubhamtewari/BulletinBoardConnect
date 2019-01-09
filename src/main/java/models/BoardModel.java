package models;

import core.BoardStructure;
import core.CustomerStructure;
import core.NoticeStructure;

public class BoardModel {
    private BoardStructure boardStructure;

    public BoardModel()
    {
        boardStructure = new BoardStructure("10");
    }

    public void addNoticeToStructure(long noticeid, String title, String body, String name) {
        //get the customerStructure name from database
        CustomerStructure customerStructure = new CustomerStructure(name);
        NoticeStructure noticeStructure = new NoticeStructure(noticeid,title,body, customerStructure);
        boardStructure.getPresentNoticeStructures().add(noticeStructure);
    }
}
