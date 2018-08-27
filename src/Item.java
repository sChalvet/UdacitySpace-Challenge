public class Item {
    private String itemName;
    private int itemWeight;
    private int itemNumber;
    private static int num = 1;
    private boolean isLoaded;

    Item(String itemName, int itemWeight){
        this.itemName = itemName;
        this.itemWeight = itemWeight;
        isLoaded = false;
        this.itemNumber = num++;
        //System.out.println("item #" + getItemNumber() + " is created");
    }

    public int getItemWeight() {
        return itemWeight;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemNumber() { return itemNumber; }

    public boolean isLoaded() {
        return isLoaded;
    }

    public void setLoaded(boolean loaded) {
        //System.out.println("item #" + getItemNumber() + " is loaded");
        isLoaded = loaded;
    }
}