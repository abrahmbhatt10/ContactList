public class Teacher extends Person{
    private String tclass;
    public Teacher(String firstName, String lastName, String phoneNumber, String tclass) {
        super(firstName, lastName, phoneNumber);
        this.tclass = tclass;
    }

    public String getTclass()
    {
        return tclass;
    }

    public void setTclass(String tclass) {
        this.tclass = tclass;
    }

    public String toString()
    {
        return super.toString() + tclass;
    }
}
