package models;

import core.CustomerStructure;
import core.PollStructure;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class PollModel {
    private PollStructure pollStructure;

    public PollModel(String question, String optionsList[], CustomerStructure customer) {
        int optionsCount = optionsList.length;
        ArrayList<String> arrayListOptionsList = new ArrayList<>(Arrays.asList(optionsList));
        ArrayList<Integer> arrayListOptionsVotes = new ArrayList<>(Arrays.asList(new Integer[]{0,0,0,0}));
        arrayListOptionsVotes.ensureCapacity(optionsCount);
        pollStructure = new PollStructure(Instant.now().toEpochMilli(), LocalDate.now().toString(),
                question,
                optionsCount,
                arrayListOptionsList,
                arrayListOptionsVotes,customer);
    }

    public PollStructure getPollStructure() {
        return pollStructure;
    }
}
