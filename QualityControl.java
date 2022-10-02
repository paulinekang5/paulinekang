public class QualityControl extends Product {

    private String item;
    private double price;
    private int quantity;
    private int customerSat;
    private int productQual;

    public QualityControl(String i, double p, int q, int c, int pq) {
        super(i, p, q);
        customerSat = c;
        productQual = pq;
    }

    public int getCustomerSat(){
        return customerSat;
    }

    public int getProductQual(){
        return productQual;
    }

}
