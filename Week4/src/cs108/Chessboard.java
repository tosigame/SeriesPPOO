package cs108;



public class Chessboard implements Image<ColorRGB>{

    //public static final Image<ColorRGB> IMAGE = new Chessboard(0.1f,ColorRGB.WHITE, ColorRGB.BLACK);
    private final double side;
    private final double sideByTwo;
    private final ColorRGB primaryColor;
    private final ColorRGB secondaryColor;



    public Chessboard(double side,ColorRGB color1,ColorRGB color2){
        this.side=side;
        this.sideByTwo=this.side*2;
        primaryColor=color1;
        secondaryColor=color2;

    }

    @Override
    public ColorRGB apply(double x, double y) {
        x=x%sideByTwo;
        y=y%sideByTwo;

        boolean black=(Math.abs(x)>=side && Math.abs(y)>=side) || (Math.abs(x)<=side && Math.abs(y)<=side );
        if((x<0 || y<0) && !(x<0 && y<0)){
            black=!black;
        }
        return black ? primaryColor : secondaryColor;
    }
}
