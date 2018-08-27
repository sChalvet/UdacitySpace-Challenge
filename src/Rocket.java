import java.util.ArrayList;

public class Rocket implements SpaceShip {

    int cargoCarried;
    int cargoLimit;
    ArrayList<Item> RocketInventory = new ArrayList<>();

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    final public boolean canCarry(Item item) {
        if( (item.getItemWeight()+cargoCarried)>cargoLimit ){ return false; }
        else{ return true; }
    }

    @Override
    final public boolean carry(Item item) {
        cargoCarried += item.getItemWeight();
        //System.out.println("Cargo weight: " + cargoCarried + " of " + cargoLimit);
        addItemsToLoad(item);
        return true;
    }

    @Override
    final public ArrayList<Item> getRocketInventory() {
        return RocketInventory;
    }

    @Override
    final public boolean addItemsToLoad(Item item) {
        RocketInventory.add(item);
        return true;
    }
}
