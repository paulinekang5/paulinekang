// Name: Pauline Kang
// Project: Craps Game --> Calculations Class
// Due: 9/28/2021

public class Calculations {

    private int dice1, dice2, sum;
    private static int point, numOfRolls;

    private boolean endOfGame = false;
    private static String output = "";

    private boolean winLose; // true = win ; false = lose


    Calculations() {
        //dice1 = firstDice;
       // dice2 = secondDice;
        while(endOfGame == false){
            Stats();
        }
    }

    private void Stats(){
        DiceRoll rollClass = new DiceRoll();
        dice1 = rollClass.getDice0();
        dice2 = rollClass.getDice1();
        sum = dice1+dice2;
        numOfRolls++;

        if (numOfRolls == 1){
            if(sum == 7 || sum == 11){
                output = "You win! You Rolled a " + sum;
                winLose = true;
                endOfGame = true;
                numOfRolls = 0;
            }
            else if(sum == 2 || sum == 3 || sum == 12){
                output = "CRAPS! You lost! You Rolled a " + sum;
                winLose = false;
                endOfGame = true;
                numOfRolls = 0;
            }
            else{
                point = sum;
            }
        }
        else{
            if(sum == 7){
                output += " \n You lost! You rolled a 7 after your first roll";
                endOfGame = true;
                winLose = false;
                numOfRolls = 0;
            }
            else if(sum == point){
                output += "\n You win! You rolled your point!";
                endOfGame = true;
                winLose = true;
                numOfRolls = 0;
            }
        }
    }

    public int getSum(){
        return sum;
    }

    public String getOutput(){
        return output;
    }

    public boolean getResults(){
        return endOfGame;
    }

    public boolean getWinLose(){
        return winLose;
    }


}
