public class U1Rocket extends URocket{
    static int num = 1;
    U1Rocket(){
        super(100, 10000, 18000, 5, 1, MissionMars.U1_ROCKET_NAME, num);
        if(MissionMars.LOGGING_ON) System.out.println("\nCreating U1 rocket #" + num);
        num++;
    }
}