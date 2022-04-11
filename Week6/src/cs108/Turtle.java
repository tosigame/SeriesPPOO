package cs108;

import static java.lang.Math.cos;
import static java.lang.Math.floorMod;
import static java.lang.Math.sin;
import static java.lang.Math.toRadians;

public final class Turtle {
    private final double x, y;
    private final int theta;

    public Turtle(double x, double y, int theta) {
        this.x = x;
        this.y = y;
        this.theta = theta;
    }

    public Turtle() {
        this(0, 0, 0);
    }

    public double x() { return x; }
    public double y() { return y; }
    public int theta() { return theta; }

    public Turtle turned(int angle) {
        int theta1 = floorMod(theta + angle, 360);
        return new Turtle(x, y, theta1);
    }

    public Turtle moved(double distance) {
        double x1 = x + distance * cos(toRadians(theta));
        double y1 = y + distance * sin(toRadians(theta));
        return new Turtle(x1, y1, theta);
    }
}
