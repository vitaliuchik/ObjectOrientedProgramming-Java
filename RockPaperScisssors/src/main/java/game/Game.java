package game;

import elements.Element;
import elements.Paper;
import elements.Rock;
import elements.Scissors;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class Game {
    public void start() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Element el2;
        Class[] elements = {Rock.class, Paper.class, Scissors.class};
        Random rand = new Random();
        Element el1 = (Element) elements[rand.nextInt(elements.length)].getConstructor().newInstance();
    }
}
