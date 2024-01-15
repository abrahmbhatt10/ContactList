public class Teacher extends Person{
    //Initializes instance variable
    private String tclass;

    //constructs using super and initializes instance variables
    public Teacher(String firstName, String lastName, String phoneNumber, String tclass) {
        super(firstName, lastName, phoneNumber);
        this.tclass = tclass;
    }

    //returns tclass
    public String getTclass()
    {
        return tclass;
    }

    //sets tclass
    public void setTclass(String tclass) {
        this.tclass = tclass;
    }

    //returns toString() utilizing super
    public String toString()
    {
        return super.toString() + " " + tclass;
    }
}
