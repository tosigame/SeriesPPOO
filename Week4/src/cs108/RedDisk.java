package cs108;

import static java.lang.Math.sqrt;

public final class RedDisk implements ImageRGB {
    public static final ImageRGB IMAGE = new RedDisk();
    
    @Override
    public ColorRGB apply(double x, double y) {
        double r = sqrt(x * x + y * y);
        return r <= 1d ? ColorRGB.RED : ColorRGB.WHITE;
    }
}