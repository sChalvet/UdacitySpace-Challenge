import java.util.ArrayList;

public class MissionMars {
    public static final String U1RocketName = "U-1 Rocket";
    public static final String U2RocketName = "U-2 Rocket";

    public static void main(String [] args){

        Simulation U1RocketSimulation = new Simulation();
        Simulation U2RocketSimulation = new Simulation();

        ArrayList<Item> loadedItems1 = new ArrayList<>();
        ArrayList<Item> loadedItems2 = new ArrayList<>();

        ArrayList<URocket> URockets1 = new ArrayList<>(); //contains list of rockets
        ArrayList<URocket> URockets2 = new ArrayList<>(); //contains list of rockets
        int totalCostU1, totalCostU2;
        totalCostU1 = totalCostU2 = 0;

        for (int i = 0; i < 10000; i++) {
            loadedItems1 = U1RocketSimulation.loadItems();
            loadedItems2 = U2RocketSimulation.loadItems();

            URockets1 = U1RocketSimulation.loadURockets(loadedItems1, U1RocketName);
            totalCostU1 += U1RocketSimulation.runSimulation(URockets1);

            //printThis(URockets1);

            URockets2 = U2RocketSimulation.loadURockets(loadedItems2, U2RocketName);
            totalCostU2 += U2RocketSimulation.runSimulation(URockets2);

            //printThis(URockets2);
        }


        System.out.println("Cost of U1 rockets: " + totalCostU1/10000 + " million dollars");
        System.out.println("Cost of U2 rockets: " + totalCostU2/10000 + " million dollars");

    }

    public static void printThis(ArrayList<URocket> uRockets){
        for (URocket uRocket : uRockets) {
            System.out.println("\n------------------------------------------------------------------");
            System.out.println(uRocket.rocketType + " #" + uRocket.getRocketNumber());
            System.out.println("--- Cargo Weight: " + uRocket.cargoCarried + " of " + uRocket.cargoLimit + " Tons");
            for (Item item : uRocket.getRocketInventory()) {
                System.out.println(item.getItemName() + ", " + item.getItemWeight() + " tons");
            }
            System.out.println("------------------------------------------------------------------\n");
        }
    }
}
