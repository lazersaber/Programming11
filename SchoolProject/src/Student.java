//Class represents student.  It has fields for first name, last name, grade, and student number

public class Student {
    private String first_name;
    private String last_name;
    private int grade;
    private int student_number;
    static int id_number = 1;
    //fields for first name, last name, grade, student number
    //student number is set to id number which goes up in increments of 1

    Student(String first_name, String last_name, int grade) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.grade = grade;
        this.student_number = id_number;
        id_number++;
    }
    //constructor

    @Override
    public String toString() {
        return "Name:\t" + first_name + " " + last_name + "\n" +
                "Grade:\t" + grade + "\n";
    }
    //overrides and returns string with the correct fields

    //getters and setters
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getStudent_number() {
        return student_number;
    }

    public void setStudent_number(int student_number) {
        this.student_number = student_number;
    }
}