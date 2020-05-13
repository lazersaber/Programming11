//Main class that runs the program.  It creates 10 students and 3 teachers, and then removes 2 students and 1 teacher

public class Main {
    public static void main(String[] args) {
        School school = new School("VLN", "Vancouver", 40);
        //creates school

        school.add_student(new Student("Cian", "Beach", 11));
        school.add_student(new Student("Ammara", "Kennedy", 8));
        school.add_student(new Student("Sheikh", "Chaney", 12));
        school.add_student(new Student("Brian", "Lozano", 9));
        school.add_student(new Student("Sheldon", "Dunlop", 11));
        school.add_student(new Student("Duke", "Hassan", 10));
        school.add_student(new Student("Elysha", "Reeve", 10));
        school.add_student(new Student("Morgan", "Ventura", 12));
        school.add_student(new Student("Imogen", "Mcgill", 9));
        school.add_student(new Student("Brandon", "Wong", 11));
        //adds 10 students to student list

        school.add_teacher(new Teacher("Albert", "Murphy", "Math"));
        school.add_teacher(new Teacher("Nicole", "Green", "English"));
        school.add_teacher(new Teacher("James", "Gonzalez", "Science"));
        //adds 3 teachers to teacher list

        System.out.println("List of Students:");
        school.print_students();
        //prints out list of students

        System.out.println("\nList of Teachers:");
        school.print_teachers();
        //prints out list of teachers

        school.remove_student(1);
        school.remove_student(2);
        school.remove_teacher("Math");
        //removes 2 students and 1 teacher


        System.out.println("\nStudent list after 2 students removed:");
        school.print_students();
        //prints out list of students after 2 removed


        System.out.println("\nTeacher list after 1 teacher removed:");
        school.print_teachers();
        //prints out list of teacher after 1 removed



    }
}
