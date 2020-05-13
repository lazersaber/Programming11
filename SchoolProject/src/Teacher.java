//Class represents teacher.  It has fields for first name, last name, and subject

public class Teacher {
    private String first_name;
    private String last_name;
    private String subject;
    //fields for first name, last name, subject
        

    Teacher(String first_name, String last_name, String subject){
        this.first_name = first_name;
        this.last_name = last_name;
        this.subject = subject;
    }
    //constructor

    @Override
    public String toString() {
        return "Name:\t" + first_name + " " + last_name + "\n" +
                "Subject:\t" + subject + "\n";
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
