package drones;

public class Arena {
    public Drone fight(Drone drn1, Drone drn2) {
        while (drn1.isAlive() && drn2.isAlive()) {
            drn1.damage(drn2);
            drn2.damage(drn1);
        }
        if (drn1.isAlive()) {
            return drn1;
        }
        else {
            return drn2;
        }
    }

}
