// this class keeps track of all the calculations

public class CalculationsClass {
    // class variables

    private double dblRate, dblHours, dblPay;
    // static keeps track of data over time
    private static int numberProcessed = 0;

    // constructor - sets up everything
    // Constructor has the same name as the class
    CalculationsClass(double theRate, double theHours){
        dblRate = theRate;
        dblHours = theHours;

        CalculatePay();
    }

    private void CalculatePay(){
        numberProcessed++;
        dblPay = dblRate * dblHours;
    }
    public int totalPayees(){
        return numberProcessed;
    }

    public double getPay(){
        return dblPay;
    }

}
