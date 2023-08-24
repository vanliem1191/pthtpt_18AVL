package Java_class01;


import java.util.ArrayList;
import java.util.List;

public class School {
    private List<Person> peopleList;
     
    public List<Person> getPeople() {
        return peopleList;
    }

    public School() {
        peopleList = new ArrayList<>();
    }

    public void addPerson(Person person) {
        peopleList.add(person);
    }

    public void removePerson(int ID) {
        peopleList.removeIf(person -> person.ID == ID);
    }

    public void updateStudentAddress(int studentID, String newAddress) {
        for (Person person : peopleList) {
            if (person instanceof Student && person.ID == studentID) {
                person.updateAddress(newAddress);
                break;
            }
        }
    }

    public void listAllPeople() {
        for (Person person : peopleList) {
            System.out.println(person);
        }
    }

    public void listStudents() {
        for (Person person : peopleList) {
            if (person instanceof Student) {
                Student student = (Student) person;
                System.out.println(student);
            }
        }
    }
}
