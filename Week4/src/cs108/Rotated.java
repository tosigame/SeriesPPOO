package cs108;

public class Rotated<T> implements Image<T> {
    double angleInRads;
    private final Image<T> image;
    public Rotated(double angleInRads,Image<T> image){
        this.angleInRads=angleInRads;
        this.image=image;
    }
    @Override
    public T apply(double x, double y) {
        return image.apply(x*Math.cos(angleInRads)+y*Math.sin(angleInRads),y*Math.cos(angleInRads)-x*Math.sin(angleInRads));
    }
}
