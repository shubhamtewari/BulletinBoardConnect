package core;

import java.util.ArrayList;

public final class BoardStruct {
    private ArrayList<Notice> presentNotices;
    private ArrayList<Notice> queuedNotices;
    private String BoardId;

    public BoardStruct(String boardId) {
        presentNotices = new ArrayList<>();
        queuedNotices = new ArrayList<>();
        BoardId = boardId;
    }

    public ArrayList<Notice> getPresentNotices() {
        return presentNotices;
    }

    public ArrayList<Notice> getQueuedNotices() {
        return queuedNotices;
    }

    public String getBoardId() {
        return BoardId;
    }
}
