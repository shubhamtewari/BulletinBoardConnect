package models;

import core.CustomerStructure;
import core.NoticeStructure;

import java.time.Instant;
import java.time.LocalDate;

public class NoticeModel {
    private NoticeStructure noticeStructure;

    public NoticeModel(String title, String body, CustomerStructure customer) {
        noticeStructure = new NoticeStructure(Instant.now().toEpochMilli(), LocalDate.now().toString(),
                title,
                body,
                null,
                0,
                0, customer);
    }

    public NoticeModel(NoticeStructure noticeStructure) {
        this.noticeStructure = noticeStructure;
    }

    public NoticeModel(String title, String body, String imagePath, CustomerStructure customer) {
        noticeStructure = new NoticeStructure(Instant.now().toEpochMilli(), LocalDate.now().toString(),
                title,
                body,
                imagePath,
                0,
                0,customer);
    }

    public NoticeStructure getNoticeStructure() {
        return noticeStructure;
    }
}
