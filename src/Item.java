public class Item {
    private String itemName;
    private int itemWeight;
    private int itemNumber;     // Assigns a specific unique number to each item (mostly for logging purposes
    private static int num = 1; // Used to assign the item number
    private boolean isLoaded;   // keeps track if the item was loaded onto a rocket

    Item(String itemName, int itemWeight){
        this.itemName = itemName;
        this.itemWeight = itemWeight;
        isLoaded = false;
        this.itemNumber = num++;

        if(MissionMars.LOGGING_ON) System.out.println("item #" + getItemNumber() + " is created");
    }

    public int getItemWeight() {
        return itemWeight;
    }

    public String getItemName() { return itemName; }

    public int getItemNumber() { return itemNumber; }

    public boolean isLoaded() { return isLoaded; }

    public void setLoaded(boolean loaded) {

        if(MissionMars.LOGGING_ON) System.out.println("Loaded item #" + getItemNumber() + " weight: " + getItemWeight() + " Item type: " + getItemName());

        isLoaded = loaded;
    }
}