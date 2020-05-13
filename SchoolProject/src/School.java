//Class represents the school.  It creates arraylists for teacher, students, and courses.  There are also methods for removing/adding/printing students/teachers

import java.util.ArrayList;

public class School {
    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Course> courses = new ArrayList<>();
    //creates arraylists for students, teachers, and courses

    private String name = new String();
    private String location = new String();
    private int classrooms;

    School(String name, String location, int classroom) {
        this.name = name;
        this.location = location;
        this.classrooms = classrooms;
        //constructor

    }

    //Methods
    public void add_teacher(Teacher teacher){
        teachers.add(teacher);
    }
    //adds a teacher

    public void remove_teacher(String subject){
        for(int i = 0; i < teachers.size(); i++){
            if(teachers.get(i).getSubject().equals(subject)){
                teachers.remove(i);
                break;
            }
        }
    }
    //removes a teacher

    public void add_student(Student student){
        students.add(student);
    }
    //adds a student

    public void remove_student(int student_number){
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getStudent_number() == student_number){
                students.remove(i);
                break;
            }
        }
    }
    //removes a student

    public void print_teachers(){
        for(int i = 0; i < teachers.size(); i++){
            System.out.println(teachers.get(i).toString());
        }
    }
    //prints out all teachers

    public void print_students(){
        for(int i = 0; i < students.size(); i++){
            System.out.println(students.get(i).toString());
        }
    }
    //prints out all students

    //getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(int classrooms) {
        this.classrooms = classrooms;
    }
}
