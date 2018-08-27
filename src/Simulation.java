import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Simulation {

    /**
     * This method loads all items from a text file and returns an ArrayList of Items
     * Should read the text file line by line and create an Item object for each and
     * then add it to an ArrayList of Items. The method should then return that ArrayList.
     * @return ArrayList of Items
     */
    public ArrayList<Item> loadItems(){
        File filePhase1 = new File("phase-1.txt");
        File filePhase2 = new File("phase-2.txt");
        ArrayList<Item> loadedItems = new ArrayList<>();

        loadedItems.addAll(readItemFile(filePhase1));
        loadedItems.addAll(readItemFile(filePhase2));

        return loadedItems;
    }

    /**
     * Loads all the necessary items into as many rockets as it takes
     * @param items, rocketType
     * @return ArrayList of URocket
     */
    public ArrayList<URocket> loadURockets(ArrayList<Item> items, String rocketType){

        ArrayList<URocket> URockets = new ArrayList<>(); //contains list of rockets

        Collections.sort(items, new Comparator<Item>() {  //Sort Item List starting with most heavy. Helps in weight distribution.
            @Override
            public int compare(Item o1, Item o2) {
                return o2.getItemWeight() - o1.getItemWeight();
            }
        });

        if(MissionMars.LOGGING_ON) {
            System.out.println("\nSorted items by weight: ");
            for (Item item : items) {
                System.out.println("item #" + item.getItemNumber() + " weight: " + item.getItemWeight() + "\tItem type: " + item.getItemName());
            }
        }

        boolean flag;
        do {
            URocket rocket = getRocket(rocketType);

            for (Item item : items) {           //for each item, try to load it to the rocket
                if(!item.isLoaded()) {          //if the item is not loaded try to load it
                    if (rocket.canCarry(item)) {
                        rocket.carry(item);
                        item.setLoaded(true);
                    }
                }
            }
            if(MissionMars.LOGGING_ON) System.out.println("Cargo weight: " + rocket.cargoCarried + " of " + rocket.cargoLimit + " limit");
            URockets.add(rocket);           //add the loaded rocket to the ArrayList of loaded rockets

           flag = true;
           for (Item item : items) {       //for every item, if item is not loaded break out of this for-loop
                if(!item.isLoaded()){
                    flag = false;
                    break;
                }
           }
        }while (!flag);

        return URockets;
    }

    private URocket getRocket(String rocketType){
        if(rocketType.equals(MissionMars.U1_ROCKET_NAME)){
            return new U1Rocket();
        }else{
            return new U2Rocket();
        }
    }


    /**
     * Takes an ArrayList of Rockets and calls launch and land methods for each of the rockets in the ArrayList.
     * Every time a rocket explodes or crashes (i.e if launch or land return false) it will have to send that rocket again.
     * All while keeping track of the total budget required to send each rocket safely to Mars.
     * @param URockets
     * @return Total budget required to send all rockets
     */
    public int runSimulation(ArrayList<URocket> URockets){
        int totalCost = 0;

        for (URocket uRocket : URockets) {
            do{
                if(MissionMars.LOGGING_ON) System.out.println("\nLaunching " + uRocket.rocketType + " #" + uRocket.getRocketNumber());
                totalCost += uRocket.rocketCost;
            }while(!uRocket.launch() || !uRocket.land());
        }

        return totalCost;
    }

    private  ArrayList<Item> readItemFile(File file){
        ArrayList<Item> itemList = new ArrayList<>();
        String[] arrStrItem = new String[2];
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                arrStrItem = scanner.nextLine().split("=");
                itemList.add(new Item(arrStrItem[0], Integer.parseInt(arrStrItem[1])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return itemList;
    }
}