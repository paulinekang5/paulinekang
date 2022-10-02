public class DiceRoll {
    private int dice0, dice1;

    DiceRoll(){
        Roll();
    }

    private void Roll(){
        dice0 = (int) (Math.random()*(6)+1);
        dice1 = (int) (Math.random()*(6)+1);
    }

    public int getDice0(){
        return dice0;
    }

    public int getDice1(){
        return dice1;
    }
}
