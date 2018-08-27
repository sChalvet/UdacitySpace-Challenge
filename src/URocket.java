import java.util.Random;

public class URocket extends Rocket {
    int rocketCost;
    int rocketWeight;
    int rocketMaxWeight;
    private int rocketNumber;

    int rocketLaunchExplosionChance;
    int rocketLandCrashChance;

    String rocketType;

    URocket(){
        rocketCost = 0;
        super.cargoCarried =0;
        rocketWeight = 0;
        rocketMaxWeight = 0;
        rocketLandCrashChance = 0;
        rocketLaunchExplosionChance = 0;
        super.cargoLimit = rocketMaxWeight - rocketWeight;
        rocketType = "unknown";
    }

    URocket(int rocketCost, int rocketWeight, int rocketMaxWeight, int rocketLandCrashChance, int rocketLaunchExplosionChance, String rocketType, int rocketNumber){
        this.rocketCost = rocketCost;
        this.rocketWeight = rocketWeight;
        this.rocketMaxWeight = rocketMaxWeight;
        this.rocketLandCrashChance = rocketLandCrashChance;
        this.rocketLaunchExplosionChance = rocketLaunchExplosionChance;
        super.cargoLimit = rocketMaxWeight - rocketWeight;
        this.rocketType = rocketType;
        super.cargoCarried = 0;
        this.rocketNumber = rocketNumber;
    }

    @Override
    public final boolean land() {

        float oddsOfFailure = ( (float) rocketLandCrashChance * cargoCarried/cargoLimit );    //Chance of landing crash = % * (cargo carried / cargo limit)
        if(MissionMars.LOGGING_ON) System.out.println("Landing odds of failure: " + oddsOfFailure + "%");
        if ( oddsOfFailure < getSuccessChance() ){
            return true; //successful landing
        }
        if(MissionMars.LOGGING_ON) System.out.println("!!!!Landing Fail for " + this.rocketType + " #" + this.getRocketNumber() + " with failure odds at " + oddsOfFailure + "%");
        return false;
    }

    @Override
    public final boolean launch() {

        int oddsOfFailure = ( rocketLaunchExplosionChance * cargoCarried/cargoLimit );  //Chance of launch explosion = % * (cargo carried / cargo limit)
        if(MissionMars.LOGGING_ON) System.out.println("Launching odds of failure: " + oddsOfFailure + "%");
        if ( oddsOfFailure < getSuccessChance() ){
            return true; //successful launch
        }
        if(MissionMars.LOGGING_ON) System.out.println("!!!!Launch Fail for " + this.rocketType + " #" + this.getRocketNumber() + " with failure odds at " + oddsOfFailure + "%");
        return false;
    }

    private int getSuccessChance(){
        int odds = new Random().nextInt(100)+1;
        if(MissionMars.LOGGING_ON) System.out.println("Random odds (must  be higher than above odds for success): " + odds + "%");
        return odds;
    }

    public int getRocketNumber() {
        return rocketNumber;
    }
}
