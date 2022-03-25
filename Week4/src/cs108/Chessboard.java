package cs108;

public class Chessboard implements ImageRGB{

    public static final ImageRGB IMAGE = new Chessboard();
    public final static double SIDE=0.1f;
    public final static double SIDESBYTWO=SIDE*2;
    @Override
    public ColorRGB apply(double x, double y) {
        x=x%SIDESBYTWO;
        y=y%SIDESBYTWO;
        System.out.println("g");
        boolean black=(Math.abs(x)>=SIDE && Math.abs(y)>=SIDE) || (Math.abs(x)<=SIDE && Math.abs(y)<=SIDE );
        if((x<0 || y<0) && !(x<0 && y<0)){
            black=!black;
        }
        return black ? ColorRGB.BLACK: ColorRGB.WHITE;
    }
}
