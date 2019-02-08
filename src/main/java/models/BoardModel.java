package models;


import core.BoardStructure;
import core.NoticeStructure;
import core.PollStructure;

import javax.swing.text.TabExpander;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;

public class BoardModel {
    private BoardStructure boardStructure;

    public BoardModel(String boardName) {
        boardStructure = new BoardStructure(Instant.now().toEpochMilli(), LocalDate.now().toString(), boardName,
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>());
    }

    /**
     * to add a notice to the notice list, if full then add to queue
     * @param isFull boolean true if board is full
     * @param notice the notice to add
     * @return false if notice was added to queue
     */
    public boolean addNoticeToBoard(boolean isFull, NoticeStructure notice) {
        if(isFull) {
            boardStructure.getQueuedNoticeStructures().add(notice);
            return false;
        }
        else {
            boardStructure.getPresentNoticeStructures().add(notice);
            return true;
        }
    }

    /**
     * to add a poll to the poll list, if full then add to queue
     * @param isFull boolean true if board is full
     * @param poll the poll to add
     * @return false if poll was added to queue
     */
    public boolean addPollToBoard(boolean isFull, PollStructure poll) {
        if(isFull) {
            boardStructure.getQueuedPollStructures().add(poll);
            return false;
        }
        else {
            boardStructure.getPresentPollStructures().add(poll);
            return true;
        }
    }

    public BoardStructure getBoardStructure() {
        return boardStructure;
    }

    public void setBoardStructure(BoardStructure boardStructure) {
        this.boardStructure = boardStructure;
    }
}
