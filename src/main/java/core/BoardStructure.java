package core;

import java.util.ArrayList;

public final class BoardStructure {
    private ArrayList<NoticeStructure> presentNoticeStructures;
    private ArrayList<NoticeStructure> queuedNoticeStructures;
    private String BoardId;

    public BoardStructure(String boardId) {
        presentNoticeStructures = new ArrayList<>();
        queuedNoticeStructures = new ArrayList<>();
        BoardId = boardId;
    }

    public ArrayList<NoticeStructure> getPresentNoticeStructures() {
        return presentNoticeStructures;
    }

    public ArrayList<NoticeStructure> getQueuedNoticeStructures() {
        return queuedNoticeStructures;
    }

    public String getBoardId() {
        return BoardId;
    }
}
