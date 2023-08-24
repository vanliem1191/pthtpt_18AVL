package Java_class01;


public class Teacher extends Person {
	private String degree;
    public Teacher(int ID, String firstName, String lastName, String address, String sex, String degree) {
		super(ID, firstName, lastName, address, sex);
		this.degree = degree;
		// TODO Auto-generated constructor stub
	}
   
    public String getDegree () {
    	return degree;
    }
    public void setDegree(String degree) {
    	this.degree = degree;
    }


    @Override
    public String toString() {
        return super.toString() + ", Degree: " + degree;
    }
}
