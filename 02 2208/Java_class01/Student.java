package Java_class01;


public class Student extends Person {
    private String majors;

    public Student(int ID, String firstName, String lastName, String address, String sex, String majors) {
        super(ID, firstName, lastName, address, sex);
        this.majors = majors;
    }
    public String getMajors() {
    	return majors;
    }
    public void setMajors(String majors) {
    	this.majors = majors;
    }
    @Override
    public String toString() {
        return super.toString() + ", Majors: " + majors;
    }
}

