package user;

public class Product {

    private double cost;
    private int productID, count;
    private String color, name;

    public Product(String name, String color, double cost, int ID, int count) {
        this.cost = cost;
        this.productID = ID;
        this.name = name;
        this.color = color;
        this.count = count;
    }

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

    public void showStatus() {
        System.out.println("Name: " + this.name + "\t Color: " + this.color
                + "\nCost: " + this.cost + "$" + "\t ID: " + this.productID
                + "\nCurrent number of stock: " + count);
    }

    public boolean isItThisProduct(Product otherProduct) {
        return (this.name.equals(otherProduct.getName()) && this.color.equals(otherProduct.getColor()) && this.cost == otherProduct.getCost() && this.productID == otherProduct.getProductID());
    }

}
