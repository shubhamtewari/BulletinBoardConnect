package core;

/**
 * notice data structure
 * @author shbmtewari@gmail.com
 */
public class NoticeStructure implements Pinnable{
    private long id;
    private String title;
    private String body;
    private CustomerStructure author;

    public NoticeStructure(long id, String title, String body, CustomerStructure author) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) { this.id = id; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthor() {
        return author.getName();
    }
}
