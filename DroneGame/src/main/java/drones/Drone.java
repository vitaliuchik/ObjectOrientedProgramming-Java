package drones;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Drone {
    private int health;
    private int power;

//analog AllArgsConstructor
//    Drone(int health, int power) {
//        this.health = health;
//        this.power = power;
//    }

    public boolean isAlive() {
        return health > 0;
    }

    public void damage(Drone drone) {
        drone.health -= power;
        if (drone.health < 0) {
            drone.health = 0;
        }
    }
}
