package drones;

import java.util.Random;

public class Monster2k19 extends Drone {
    private static Random rnd = new Random();
    public Monster2k19() {
        super(rnd.nextInt(20), rnd.nextInt(10));
    }
}
