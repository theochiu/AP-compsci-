public class Product{

    private String name;
    private double price;

    public Product(String productName , double productPrice){
        name = productName;
        price = productPrice;
    }

    public void reducePrice(double discount){
        price-=discount;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    
    }
}