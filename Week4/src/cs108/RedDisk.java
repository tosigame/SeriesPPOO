package cs108;

import static java.lang.Math.sqrt;

public final class RedDisk implements Image<ColorRGB> {
    public static final Image<Double> IMAGE =
            new HorizontalGradientMask();
    @Override
    public ColorRGB apply(double x, double y) {
        double r = sqrt(x * x + y * y);
        return r <= 1d ? ColorRGB.BLACK : ColorRGB.WHITE;
    }
}