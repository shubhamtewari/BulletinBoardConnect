package core;

import java.util.ArrayList;

public final class BoardStructure {
    private long boardTimeStamp;
    private String boardDate;
    private String boardName;
    private ArrayList<NoticeStructure> presentNoticeStructures;
    private ArrayList<NoticeStructure> queuedNoticeStructures;
    private ArrayList<PollStructure> presentPollStructures;
    private ArrayList<PollStructure> queuedPollStructures;

    public BoardStructure(long boardTimeStamp, String boardDate, String boardName, ArrayList<NoticeStructure> presentNoticeStructures, ArrayList<NoticeStructure> queuedNoticeStructures, ArrayList<PollStructure> presentPollStructures, ArrayList<PollStructure> queuedPollStructures) {
        this.boardTimeStamp = boardTimeStamp;
        this.boardDate = boardDate;
        this.boardName = boardName;
        this.presentNoticeStructures = presentNoticeStructures;
        this.queuedNoticeStructures = queuedNoticeStructures;
        this.presentPollStructures = presentPollStructures;
        this.queuedPollStructures = queuedPollStructures;
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

    public ArrayList<NoticeStructure> getQueuedNoticeStructures() {
        return queuedNoticeStructures;
    }

    public void setQueuedNoticeStructures(ArrayList<NoticeStructure> queuedNoticeStructures) {
        this.queuedNoticeStructures = queuedNoticeStructures;
    }

    public ArrayList<PollStructure> getPresentPollStructures() {
        return presentPollStructures;
    }

    public void setPresentPollStructures(ArrayList<PollStructure> presentPollStructures) {
        this.presentPollStructures = presentPollStructures;
    }

    public ArrayList<PollStructure> getQueuedPollStructures() {
        return queuedPollStructures;
    }

    public void setQueuedPollStructures(ArrayList<PollStructure> queuedPollStructures) {
        this.queuedPollStructures = queuedPollStructures;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }
}
