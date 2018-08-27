import java.util.ArrayList;

public interface SpaceShip {

    boolean launch();

    boolean land();

    boolean canCarry(Item item);

    boolean carry(Item item);

    ArrayList<Item> getRocketInventory();

    boolean addItemsToLoad(Item item);
}
