package models;


import core.BoardStructure;
import core.EventStructure;
import core.NoticeStructure;
import core.PollStructure;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;

public class BoardModel {
    private BoardStructure boardStructure;

    public BoardModel(String boardName) {
        boardStructure = new BoardStructure(Instant.now().toEpochMilli(), LocalDate.now().toString(), boardName,
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>());
    }

    public BoardModel(BoardStructure boardStructure) {
        this.boardStructure = boardStructure;
    }



    /**
     * to add a notice to the notice list
     * @param notice the notice to add
     */
    public boolean addNoticeToBoard(NoticeStructure notice) {
            boardStructure.getPresentNoticeStructures().add(notice);
            return true;
    }

    /**
     * to add a poll to the poll list
     * @param poll the poll to add
     */
    public boolean addPollToBoard(PollStructure poll) {
            boardStructure.getPresentPollStructures().add(poll);
            return true;
    }

    /**
     * to add and event structure to the board structure
     * @param eventStructure the event structure to add
     */
    public void addEventToBoard(EventStructure eventStructure) {
        boardStructure.getPresentEventStructures().add(eventStructure);
    }

    //delete stuff>>>>>>>>>>>>>>>>
    public void removeEventFromBoard(String id) {
        for(int i = 0;i< boardStructure.getPresentEventStructures().size();i++) {
            if((boardStructure.getPresentEventStructures().get(i).getEventId()+"").equals(id)) {
                boardStructure.getPresentEventStructures().remove(i);
            }
        }
    }

    public void removePollFromBoard(String id) {
        for(int i = 0;i< boardStructure.getPresentPollStructures().size();i++) {
            if((boardStructure.getPresentPollStructures().get(i).getPollTimeStamp()+"").equals(id)) {
                boardStructure.getPresentPollStructures().remove(i);
            }
        }
    }

    public void removeNoticeFromBoard(String id) {
        for(int i = 0;i< boardStructure.getPresentNoticeStructures().size();i++) {
            if((boardStructure.getPresentNoticeStructures().get(i).getNoticeTimeStamp()+"").equals(id)) {
                boardStructure.getPresentNoticeStructures().remove(i);
            }
        }
    }
    //delete stuff<<<<<<<<<<<<<<<<<<

    public BoardStructure getBoardStructure() {
        return boardStructure;
    }

    public void setBoardStructure(BoardStructure boardStructure) {
        this.boardStructure = boardStructure;
    }
}
