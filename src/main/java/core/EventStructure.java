package core;

import java.io.Serializable;
import java.time.LocalDate;

public class EventStructure implements Serializable {
    private long eventId;
    private String localDate;
    private String eventName;
    private String eventDetails;
    private String eventStartDate;
    private String eventEndDate;
    private String eventStatus;

    public EventStructure(long eventId, String localDate, String eventName, String eventDetails, String eventStatus) {
        this.eventId = eventId;
        this.localDate = localDate;
        this.eventName = eventName;
        this.eventDetails = eventDetails;
        this.eventStatus = eventStatus;
    }

    public EventStructure(long eventId, String localDate, String eventName, String eventDetails, String eventStartDate, String eventEndDate, String eventStatus) {
        this.eventId = eventId;
        this.localDate = localDate;
        this.eventName = eventName;
        this.eventDetails = eventDetails;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        this.eventStatus = eventStatus;
    }

    public long getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventStartDate() {
        return eventStartDate;
    }

    public String getEventEndDate() {
        return eventEndDate;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public String getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventStartDate(String eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public void setEventEndDate(String eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }
}
