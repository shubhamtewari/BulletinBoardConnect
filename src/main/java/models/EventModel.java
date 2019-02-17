package models;

import core.EventStructure;

import java.time.Instant;
import java.time.LocalDate;

public class EventModel {
    private EventStructure eventStructure;

    public EventModel(String name, String details, String status) {
        eventStructure = new EventStructure(Instant.now().toEpochMilli(), LocalDate.now().toString(), name, details, status );
    }

    public EventModel(String name, String details, String dateStart, String dateEnd, String status) {
        eventStructure = new EventStructure(Instant.now().toEpochMilli(), LocalDate.now().toString(), name, details, dateStart, dateEnd, status);
    }

    public EventStructure getEventStructure() {
        return eventStructure;
    }
}
