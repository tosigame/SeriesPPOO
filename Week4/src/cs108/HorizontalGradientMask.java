package cs108;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class HorizontalGradientMask implements Image<Double>{

    @Override
    public Double apply(double x, double y) {
        return max(0, min((x + 1d) / 2d, 1d));
    }
}
