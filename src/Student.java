public class Student extends Person{
    //Initializes instance variable
    private int grade;

    //constructs using super and initializes instance variables
    public Student(String firstName, String lastName, String phoneNumber, int grade) {
        super(firstName, lastName, phoneNumber);
        this.grade = grade;
    }

    //returns grade
    public int getGrade() {
        return grade;
    }

    //sets grade
    public void setGrade(int grade) {
        this.grade = grade;
    }

    //returns toString() with super
    public String toString()
    {
        return super.toString() + " Grade: " + grade;
    }
}
