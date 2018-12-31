package core;

/**
 * this is the like dislike bar above each notice
 */
public class OpinionBar {
    private Opinion opinion;//the opinion object associated with the object
    private Notice parent;//the parent notice to whom the bar belongs

    //constructor
    OpinionBar(Notice parent) {
        opinion = new Opinion();
        this.parent = parent;
    }

    //getter and setter methods
    public Opinion getOpinion() {
        return opinion;
    }

    public Notice getParent() {
        return parent;
    }
}
