import core.BoardStruct;
import core.Customer;
import core.Notice;

import java.util.ArrayList;

public class BoardModel {
    BoardStruct boardStructure;

    BoardModel()
    {
        boardStructure = new BoardStruct("10");
    }

    void addNoticeToStructure(long noticeid, String title, String body, String name) {
        //get the customer name from database
        Customer customer = new Customer(name);
        Notice notice = new Notice(noticeid,title,body,customer);
        //boardStructure = new BoardStruct("10");//only board
        boardStructure.getPresentNotices().add(notice);
    }
}
