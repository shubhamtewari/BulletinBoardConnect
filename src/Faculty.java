public class Faculty extends Customer {
    private Designation designation;
    private Section section;

    /*
    constructor
    faculty given administration by default
     */
    Faculty(String name, Designation designation, Section section) {
        super(name);
        this.designation = designation;
        this.section = section;
        writeAccess = true;
        administrator = true;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
