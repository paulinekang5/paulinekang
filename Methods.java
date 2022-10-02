public class Methods {

    private double num0;
    private double num1;

    Methods(double number0, double number1){
        num0 = number0;
        num1 = number1;
    }

    public double divideBy3(double value){
        if(value < 1)
            return value;
        else
        {
            return(divideBy3(value/3));
        }
    }

    // Write a method that takes a positive number and outputs that many odd numbers.
    /*
    public int oddNum(int value){
       int num = 1;
       if (value < 0){
           return num;
       }
       else{
           return oddNum(value-1);
       }
    }
    */

    // Write a method that determines if one number is the greatest common factor of another.

}
