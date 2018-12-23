public class Student extends Customer{
    private int level;
    private Section section;

    /*
    constructor
    student is given write access to the bulletin board
     */
    Student(String name) {
        super(name);
        writeAccess = true;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
