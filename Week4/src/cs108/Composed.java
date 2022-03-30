package cs108;

public class Composed<T> implements Image<ColorRGB>{

    private final Image<T> image;
    private final Image<T> mask;
    public Composed(Image<T> image,Image<T> mask){
        this.image=image;
        this.mask=mask;
    }
    @Override
    public ColorRGB apply(double x, double y) {


    }
}
