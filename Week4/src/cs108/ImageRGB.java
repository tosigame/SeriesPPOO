package cs108;

/**
 * Une image continue et infinie, représentée par une fonction associant une
 * couleur à chaque point du plan.
 */

public interface ImageRGB {
    ColorRGB apply(double x, double y);
}
