import java.util.ArrayList;
import java.util.Dictionary;

/**
 * the notice posted on the bulletin board
 */
public class Notice {
    String title;
    String body;
    Poll poll;
    Customer author;
    boolean authenticated;
    OpinionBar opinionBar;
    ArrayList<Customer> customerReactList;

    Notice(String title, String body, Customer author, boolean authenticated) {
        this.title = title;
        this.body = body;
        this.author = author;
        this.authenticated = authenticated;
        poll = new Poll();
        opinionBar = new OpinionBar(this);
        customerReactList = new ArrayList<>();
    }
}
