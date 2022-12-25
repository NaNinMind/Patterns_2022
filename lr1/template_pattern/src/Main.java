import java.util.ArrayList;
import java.util.Optional;
//import java.util.Random;

enum Category {
    Dairy,
    Meat_Fish,
    Vegetables_fruit,
    Freezer,
    Bread,
    No_Category,
    PC_parts,
    Smartphones,
    Office
}
enum SpecificInfo {
    Fragile,
    No_Light,
    No_Info,
    Perishable,
}
enum Type{
    Food,
    Electro,
    Household,
    Unknown
}

class Scanner {
    public final static String scan(Product p){
        String res = "";
        switch (p.getType().orElse(Type.Unknown)){
            case Food:
                res = "Food warehouse ||";
                break;
            case Electro:
                res = "Electro warehouse ||";
                break;
            case Household:
                res = "HH warehouse ||";
                break;
            default:
                res = "Manual warehouse ||";
                return res;
        }
        switch( p.getCategory() ){
            case Dairy:
                res += "Dairy Section";
                break;
            case Meat_Fish:
                res += "Meat/Fish Section";
                break;
            case Vegetables_fruit:
                res += "Veg/Fruit Section";
                break;
            case Freezer:
                res += "Freezer Section";
                break;
            case Bread:
                res += "Bread Section";
                break;
            case Office:
                res += "Office Section";
                break;
            case Smartphones:
                res += "Smartphones Section";
                break;
            case PC_parts:
                res += "PC Section";
                break;
            case No_Category:
                res = "Manual decision at " + res;
                return res;
        }
        switch(p.getSpecificInfo()){
            case Fragile:
                res += "|| Mark: Fragile";
                break;
            case No_Light:
                res += "|| Mark: No Light";
                break;
            case Perishable:
            res += "|| Mark: Perishable";
                break;
            case No_Info:
                break;
        }
        
        int size = p.getSize();
        int mass = p.getMass();
        // size + mass >= 10 => floor
        // 5 < size + mass < 10 => pallet
        // size + mass <= 5 => shelf
        if ( size + mass <= 5 ){
            res += " || Shelf";
        }
        else if ( size + mass < 10){
            res += " || Pallete";
        }
        else{
            res += " || Floor";
        }


        return res;
    }
    
}
abstract class Product {
    private int mass, size;
    Category category;

    Product(int mass, int size, Category category){
        this.mass = mass;
        this.size = size;
        this.category = category;
    }
    Product(int mass, int size){
        this.mass = mass;
        this.size = size;
        this.category = Category.No_Category;
    }

    int getMass(){
        return mass;
    }
    int getSize(){
        return size;
    }
    Category getCategory(){
        return category;
    }
    abstract Optional<Type> getType();
    abstract SpecificInfo getSpecificInfo();
}
class FoodProduct extends Product {
    
    FoodProduct(int mass, int size, Category category) {
        super(mass, size, category);
    }
    FoodProduct(int mass, int size){
        super(mass,size);
    }

    @Override
    Optional<Type> getType() {
        return Optional.of(Type.Food);
    }

    @Override
    SpecificInfo getSpecificInfo() { // stupid, i know. here purely for the sake of having template pattern somewhat visible
        return SpecificInfo.values()[(int)(Math.random() * (3 - 0) + 0)];
    }
    
}
class TechProduct extends Product {

    TechProduct(int mass, int size, Category category) {
        super(mass, size, category);
    }

    public TechProduct(int mass, int size) {
        super(mass, size);
    }

    @Override
    Optional<Type> getType() {
        return Optional.of(Type.Electro);
    }

    @Override
    SpecificInfo getSpecificInfo() {// stupid, i know. here purely for the sake of having template pattern somewhat visible
        return SpecificInfo.values()[(int)(Math.random() * (2 - 0) + 0)];
        
    }
    
}
class HouseHoldProduct extends Product {

    HouseHoldProduct(int mass, int size, Category category) {
        super(mass, size, category);
        
    }
    HouseHoldProduct(int mass, int size){
        super(mass, size);
    }
    @Override
    Optional<Type> getType() {
        return Optional.of(Type.Household);
    }

    @Override
    SpecificInfo getSpecificInfo() {// stupid, i know. here purely for the sake of having template pattern somewhat visible
        return SpecificInfo.values()[(int)(Math.random() * (3 - 0) + 0)];
        
    }
    
}
class UnknownTypeProduct extends Product{

    UnknownTypeProduct(int mass, int size, Category category) {
        super(mass, size, category);
    }
    UnknownTypeProduct(int mass, int size) {
        super(mass, size);
    }

    @Override
    Optional<Type> getType() {
        return Optional.empty();
    }

    @Override
    SpecificInfo getSpecificInfo() {
        return null;
    }
    
}
class Main {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<Product>();

        products.add( new FoodProduct(1, 1, Category.Dairy));
        products.add( new FoodProduct(3, 3, Category.Meat_Fish));
        products.add( new FoodProduct(1, 7, Category.Vegetables_fruit));
        products.add( new FoodProduct(2, 1, Category.Freezer));
        products.add( new FoodProduct(5, 6, Category.Bread));
        products.add( new FoodProduct(1, 1));
        products.add( new FoodProduct(2, 2, Category.Dairy));
        products.add(new TechProduct(2, 3));
        products.add(new TechProduct(3, 3, Category.Smartphones));
        products.add(new TechProduct(8, 3, Category.PC_parts));
        products.add(new TechProduct(1, 3, Category.Office));
        products.add(new UnknownTypeProduct(2, 3));
        products.add(new HouseHoldProduct(0, 0));
        products.add(new HouseHoldProduct(10, 1));

        //Scanner scanner = new Scanner();
        for ( Product pr : products){
            System.out.println(Scanner.scan(pr));
        }
    }
}
