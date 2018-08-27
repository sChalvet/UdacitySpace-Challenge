public class U2Rocket extends URocket{
    static int num = 1;
    U2Rocket(){
        super(120, 18000, 29000, 4, 8, MissionMars.U2_ROCKET_NAME, num);
        if(MissionMars.LOGGING_ON) System.out.println("\nCreating U2 rocket #" + num);
        num++;
    }
}