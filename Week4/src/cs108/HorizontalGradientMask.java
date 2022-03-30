package cs108;

public class HorizontalGradientMask<T> implements Image<ColorRGB>{
    private final Image<T> image;
    private final double clearness;
    public HorizontalGradientMask(Image<T> image,double clearness){
        this.image=image;
        this.clearness=clearness;
    }
    @Override
    public ColorRGB apply(double x, double y) {

        return this.clearness
    }
}
