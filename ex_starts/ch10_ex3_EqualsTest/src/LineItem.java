import java.text.NumberFormat;

public class LineItem {

    private Product product;
    private int quantity;

    public LineItem() {
        product = new Product();
        quantity = 0;
    }
    
    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        double total = quantity * product.getPrice();
        return total;
    }
    
    public String getTotalFormatted() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
    }
}