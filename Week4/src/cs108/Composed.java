package cs108;

class Composed implements Image<ColorRGB> {
    private final Image<ColorRGB> bg, fg;
    private final Image<Double> mask;

    public Composed(Image<ColorRGB> bg,
                    Image<ColorRGB> fg,
                    Image<Double> mask) {
        this.bg = bg;
        this.fg = fg;
        this.mask = mask;
    }

    @Override
    public ColorRGB apply(double x, double y) {
        return bg.apply(x, y)
                .mixWith(fg.apply(x, y), mask.apply(x, y));
    }
}
