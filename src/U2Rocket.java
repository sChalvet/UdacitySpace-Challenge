public class U2Rocket extends URocket{
    static int num = 1;
    U2Rocket(){
        super(120, 18000, 29000, 4, 8, MissionMars.U2RocketName, num);
        //System.out.println("Creating U2 rocket #" + num);
        num++;
    }
}