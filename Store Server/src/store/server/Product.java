package store.server;

public class Product {

    private double cost;
    private int productID, count = 1;
    private String color, name;

    public Product(String name, String color, double cost, int ID) {
        this.cost = cost;
        this.productID = ID;
        this.name = name;
        this.color = color;

    }

    public void addProduct() {
        count++;
    }

    public void deleteProduct() {
        count--;
    }

    public double getCost() {
        return cost;
    }

    public int getProductID() {
        return productID;
    }

    public int getCount() {
        return count;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public String showStatus() {
        return ("\nName: " + this.name + "\t Color: " + this.color
                + "\nCost: " + this.cost + "$" + "\t ID: " + this.productID
                + "\nCurrent number of stock: " + count + "\n");
    }

    public boolean isItThisProduct(Product otherProduct) {
        return (this.name.equals(otherProduct.getName()) && this.color.equals(otherProduct.getColor()) && this.cost == otherProduct.getCost() && this.productID == otherProduct.getProductID());
    }

    public String statusString() {
        String status = "\n" + name + "\n" + color + "\n" + cost + "\n" + productID + "\n" + count;
        return status;
    }

}
