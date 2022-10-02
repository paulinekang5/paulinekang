public class Employee {

    public String empName;
    private String empID;
    private double empSalary;

    public Employee(){

    }

    public Employee(String name, String ID, double sal){
        this.empName = name;
        this.empID = ID;
        this.empSalary = sal;
    }

    // Modifier Methods
    public void setName(String theName){
        empName = theName;
    }

    public void setID(String theID){
        empID = theID;
    }

    public void setSalary(double pay){
        empSalary = pay;
    }


    // Accessor Methods
    public String getName(){
        return empName;
    }

    public String getID(){
        return empID;
    }

    public double getSal(){
        return empSalary;
    }
}
