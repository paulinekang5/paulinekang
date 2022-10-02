public class Main {
    public static void main(String[]args) {

        //declare our frame which is a form
        Inventory frame = new Inventory();
        frame.setSize(500,500);
        frame.setVisible(true);
    }
    /*
    public static void main(String[] args) {
        Inventory hardware = new Inventory();

        hardware.addNewProduct("hammer", 15.95, 100, 10, 3);
        hardware.addNewProduct("saw", 24.50, 15, 5, 7);
        hardware.displayProduct();
        System.out.println(hardware.mustOrder());
    }*/
}
