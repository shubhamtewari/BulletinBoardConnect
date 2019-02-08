package core;

public class PollStructure implements Pinnable {
    private long pollTimeStamp;
    private String pollDate;
    private String pollQuestion;
    private int numberOfOptions;
    private String pollOptions[];
    private int pollOptionsVote[];
    private CustomerStructure Customer;

    public PollStructure(long pollTimeStamp, String pollDate, String pollQuestion, int numberOfOptions, String pollOptions[], int pollOptionsVote[], CustomerStructure customer) {
        this.pollTimeStamp = pollTimeStamp;
        this.pollDate = pollDate;
        this.pollQuestion = pollQuestion;
        this.numberOfOptions = numberOfOptions;
        this.pollOptions = pollOptions;
        this.pollOptionsVote = pollOptionsVote;
        Customer = customer;
    }

    public long getPollTimeStamp() {
        return pollTimeStamp;
    }

    public void setPollTimeStamp(long pollTimeStamp) {
        this.pollTimeStamp = pollTimeStamp;
    }

    public String getPollQuestion() {
        return pollQuestion;
    }

    public void setPollQuestion(String pollQuestion) {
        this.pollQuestion = pollQuestion;
    }

    public int getNumberOfOptions() {
        return numberOfOptions;
    }

    public String[] getPollOptions() {
        return pollOptions;
    }

    public void setPollOptions(String[] pollOptions) {
        this.pollOptions = pollOptions;
    }

    public int[] getPollOptionsVote() {
        return pollOptionsVote;
    }

    public void setPollOptionsVote(int[] pollOptionsVote) {
        this.pollOptionsVote = pollOptionsVote;
    }

    public void setNumberOfOptions(int numberOfOptions) {
        this.numberOfOptions = numberOfOptions;
    }

    public CustomerStructure getCustomer() {
        return Customer;
    }

    public void setCustomer(CustomerStructure customer) {
        Customer = customer;
    }

    public String getPollDate() {
        return pollDate;
    }

    public void setPollDate(String pollDate) {
        this.pollDate = pollDate;
    }
}