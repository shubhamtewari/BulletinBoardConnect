package core;

import java.util.ArrayList;

public final class BoardStructure {
    private long boardTimeStamp;
    private String boardDate;
    private String boardName;
    private ArrayList<NoticeStructure> presentNoticeStructures;
    private ArrayList<PollStructure> presentPollStructures;
    private ArrayList<EventStructure> presentEventStructures;

    public BoardStructure(long boardTimeStamp, String boardDate, String boardName, ArrayList<NoticeStructure> presentNoticeStructures, ArrayList<PollStructure> presentPollStructures, ArrayList<EventStructure> presentEventStructures) {
        this.boardTimeStamp = boardTimeStamp;
        this.boardDate = boardDate;
        this.boardName = boardName;
        this.presentNoticeStructures = presentNoticeStructures;
        this.presentPollStructures = presentPollStructures;
        this.presentEventStructures = presentEventStructures;
    }

    public long getBoardTimeStamp() {
        return boardTimeStamp;
    }

    public void setBoardTimeStamp(long boardTimeStamp) {
        this.boardTimeStamp = boardTimeStamp;
    }

    public String getBoardDate() {
        return boardDate;
    }

    public void setBoardDate(String boardDate) {
        this.boardDate = boardDate;
    }

    public ArrayList<NoticeStructure> getPresentNoticeStructures() {
        return presentNoticeStructures;
    }

    public void setPresentNoticeStructures(ArrayList<NoticeStructure> presentNoticeStructures) {
        this.presentNoticeStructures = presentNoticeStructures;
    }

    public ArrayList<PollStructure> getPresentPollStructures() {
        return presentPollStructures;
    }

    public void setPresentPollStructures(ArrayList<PollStructure> presentPollStructures) {
        this.presentPollStructures = presentPollStructures;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public ArrayList<EventStructure> getPresentEventStructures() {
        return presentEventStructures;
    }
}
