package main.java.es.ull.app;

import bagel.Image;
import bagel.util.Point;

public class GhostRed extends Ghost {
    private final static Image GHOST_RED_IMAGE = new Image("res/ghostRed.png");
    private final static double SPEED = 2;

    public GhostRed(Point topLeft) {
        super(topLeft, SPEED);
        setImage(GHOST_RED_IMAGE);
        setDirection(RIGHT);
    }

    @Override
    public void changeDirection() {
        if (getDirection() == RIGHT) {
            setDirection(LEFT);
        } else {
            setDirection(RIGHT);
        }
    }

}
