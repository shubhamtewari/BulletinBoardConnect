package core;

/**
 * notice data structure
 * @author shbmtewari@gmail.com
 */
public class NoticeStructure implements Pinnable{
    static int count = 0;
    private int noticeId;
    private long noticeTimeStamp;
    private String noticeDate;
    private String noticeTitle;
    private String noticeBody;
    private String imagePath;
    private int positiveVotes;
    private int negativeVotes;
    private CustomerStructure noticeCustomer;

    public NoticeStructure(long noticeTimeStamp, String noticeDate, String noticeTitle, String noticeBody, String imagePath,int positiveVotes, int negativeVotes, CustomerStructure noticeCustomer) {
        noticeId = ++count;
        this.noticeTimeStamp = noticeTimeStamp;
        this.noticeDate = noticeDate;
        this.noticeTitle = noticeTitle;
        this.noticeBody = noticeBody;
        this.imagePath = imagePath;
        this.positiveVotes = positiveVotes;
        this.negativeVotes = negativeVotes;
        this.noticeCustomer = noticeCustomer;
    }

    public long getNoticeTimeStamp() {
        return noticeTimeStamp;
    }

    public void setNoticeTimeStamp(long noticeTimeStamp) {
        this.noticeTimeStamp = noticeTimeStamp;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeBody() {
        return noticeBody;
    }

    public void setNoticeBody(String noticeBody) {
        this.noticeBody = noticeBody;
    }

    public int getPositiveVotes() {
        return positiveVotes;
    }

    public void setPositiveVotes(int positiveVotes) {
        this.positiveVotes = positiveVotes;
    }

    public int getNegativeVotes() {
        return negativeVotes;
    }

    public void setNegativeVotes(int negativeVotes) {
        this.negativeVotes = negativeVotes;
    }

    public CustomerStructure getNoticeCustomer() {
        return noticeCustomer;
    }

    public void setNoticeCustomer(CustomerStructure noticeCustomer) {
        this.noticeCustomer = noticeCustomer;
    }

    public String getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(String noticeDate) {
        this.noticeDate = noticeDate;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public static int getCount() {
        return count;
    }

    public int getNoticeId() {
        return noticeId;
    }
}
