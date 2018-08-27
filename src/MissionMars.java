import java.util.ArrayList;

public class MissionMars {
    public static final String U1_ROCKET_NAME = "U-1 Rocket";  // The Rocket name allows the correct object type to be built
    public static final String U2_ROCKET_NAME = "U-2 Rocket";
    public static final boolean LOGGING_ON = false;            // Turn logging on or off
    public static final int NUM_OF_SIMULATIONS = 100;          // Set the number of times we want to run the simulation.

    public static void main(String [] args){
        
        Simulation URocketSimulation;
        ArrayList<Item> loadedItems;
        ArrayList<URocket> URockets; //contains list of rockets

        int totalCostU1, totalCostU2;
        totalCostU1 = totalCostU2 = 0;



        for (int i = 0; i < NUM_OF_SIMULATIONS; i++) {   //increase number in loop to run more simulations
            if(MissionMars.LOGGING_ON) System.out.println("\n-+-+-+-+-+-+-+-+-+-+-+-+ SIMULATION #" + (i+1) +" -+-+-+-+-+-+-+-+-+-+-+-+\n");

            URocketSimulation = new Simulation();

            loadedItems = URocketSimulation.loadItems();
            URockets = URocketSimulation.loadURockets(loadedItems, U1_ROCKET_NAME);
            totalCostU1 += URocketSimulation.runSimulation(URockets);

            if(MissionMars.LOGGING_ON) printThis(URockets);

            loadedItems = URocketSimulation.loadItems();
            URockets = URocketSimulation.loadURockets(loadedItems, U2_ROCKET_NAME);
            totalCostU2 += URocketSimulation.runSimulation(URockets);

            if(MissionMars.LOGGING_ON) printThis(URockets);

            if(MissionMars.LOGGING_ON) System.out.println("\n-+-+-+-+-+-+-+-+-+-+-+-+ END OF SIMULATION #" + (i+1) +" -+-+-+-+-+-+-+-+-+-+-+-+\n");
        }


        System.out.println("\nAverage Cost of using U1 rockets: " + totalCostU1/NUM_OF_SIMULATIONS + " million dollars");
        System.out.println("Average Cost of using U2 rockets: " + totalCostU2/NUM_OF_SIMULATIONS + " million dollars");

    }

    public static void printThis(ArrayList<URocket> uRockets){
        for (URocket uRocket : uRockets) {
            System.out.println("\n------------------------------------------------------------------");
            System.out.println(uRocket.rocketType + " #" + uRocket.getRocketNumber());
            System.out.println("--- Cargo Weight: " + uRocket.cargoCarried + " of " + uRocket.cargoLimit + " Tons");
            for (Item item : uRocket.getRocketInventory()) {
                System.out.println(item.getItemName() + ", " + item.getItemWeight() + " tons");
            }
        }
    }
}
