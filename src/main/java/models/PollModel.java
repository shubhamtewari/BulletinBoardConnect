package models;

import core.CustomerStructure;
import core.PollStructure;

import java.time.Instant;
import java.time.LocalDate;

public class PollModel {
    private PollStructure pollStructure;

    public PollModel(String question, String optionsList[], CustomerStructure customer) {
        int optionsCount = optionsList.length;
        pollStructure = new PollStructure(Instant.now().toEpochMilli(), LocalDate.now().toString(),
                question,
                optionsCount,
                optionsList,
                new int[optionsCount],customer);
    }

    public PollStructure getPollStructure() {
        return pollStructure;
    }
}
