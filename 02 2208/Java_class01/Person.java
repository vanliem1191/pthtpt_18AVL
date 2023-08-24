package Java_class01;

class Person {
    protected int ID;
    protected String firstName;
    protected String lastName;
    protected String address;
    protected String sex;

    public Person(int ID, String firstName, String lastName, String address, String sex) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.sex = sex;
    }
    public int getID() {
    	return ID;    	
    }
    public String getFirstName() {
    	return firstName;
    }
    public String getLastName() {
    	return lastName;
    }
    public String getAddress() {
    	return address;
    }
    public String getSex() {
    	return sex;
    }
    
    
    public void setID(int ID) {
    	this.ID = ID;
    }
    public void setFirstName(String firstName) {
    	this.firstName = firstName;
    }
    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }
    public void setAddress(String address) {
    	this.address = address;
    }
    public void setSex(String sex) {
    	this.sex = sex;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void updateAddress(String newAddress) {
        this.address = newAddress;
    }

    @Override
    public String toString() {
        return "ID: " + ID + ", Name: " + getFullName() + ", Address: " + address + ", Sex: " + sex;
    }
}
