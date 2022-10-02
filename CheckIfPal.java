public class CheckIfPal {
    private String str;
    private boolean isPalindrome;

    CheckIfPal(String input) {
        str = input;
        Check();
    }

    private void Check(){
        String reverse = "";
        for(int x = str.length()-1; x > -1; x--){
            reverse += str.substring(x, x+1);
        }

        if(reverse.equalsIgnoreCase(str)){
            isPalindrome = true;
        }
        else{
            isPalindrome = false;
        }
    }

    public boolean getIsPal(){
        return isPalindrome;
    }

}
