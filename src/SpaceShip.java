import java.util.ArrayList;

public interface SpaceShip {

    /**
     * A method that returns either true or false indicating if the launch was successful or if the rocket has crashed.
     * @return true or false indicating if the launch was successful
     */
    boolean launch();

    /**
     * A method that returns either true or false based on the success of the landing.
     * @return true or false based on the success of the landing
     */
    boolean land();

    /**
     * A method that takes an Item as an argument and returns true if the rocket can carry such item or false if it will exceed the weight limit.
     *
     * @param item
     * @return true if the rocket can carry such item or false if it will exceed the weight limit
     */
    boolean canCarry(Item item);

    /**
     * A method that takes an Item object and updates the current weight of the rocket.
     *
     * @param item
     * @return true if successfully added to the weight of the rocket
     */
    boolean carry(Item item);

    /**
     * A method that returns a list of Item objects that are currently loaded on the rocket.
     *
     * @return ArrayList of Item obj
     */
    ArrayList<Item> getRocketInventory();

    /**
     * A method that takes an Item object and adds to the inventory of the rocket.
     *
     * @param item
     * @return true if successfully added to the rocket
     */
    boolean addItemsToLoad(Item item);
}
