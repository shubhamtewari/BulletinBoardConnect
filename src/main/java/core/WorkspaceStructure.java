package core;

public class WorkspaceStructure {
    private String name;
    private long timeStamp;

    public WorkspaceStructure(String name, long timeStamp) {
        this.name = name;
        this.timeStamp = timeStamp;
    }

    public String getName() {
        return name;
    }

    public long getTimeStamp() {
        return timeStamp;
    }
}
