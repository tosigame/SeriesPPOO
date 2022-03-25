


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedImage image = ImageIO.read(new File("Week3/pskov.png"));
        String text = Steganographer.extract(image);
        int bit=0;
        String bits="10000010101010100101000010010000";

        int rgb=(image.getRGB(100,100));
        int red = (rgb>>16)&0x0ff;
        int green=(rgb>>8) &0x0ff;
        int blue= (rgb)    &0x0ff;
        /*System.out.printf("[18]blue: %s\n",Integer.toBinaryString(blue));
        System.out.printf("[19]red: %s\n",Integer.toBinaryString(red));
        System.out.printf("[20]green: %s\n",Integer.toBinaryString(green)); //11111111010110110110111110000010
        System.out.println(String.format("%32s", Integer.toBinaryString((image.getRGB(100,100)))).replace(' ', '0'));
        int mask1 = 1;
        System.out.println(String.format("%32s",Integer.toBinaryString(mask1 | rgb)).replace(' ','0'));
        System.out.println();
        for (int i = 0; i < 32; i++) {
            if(Integer.parseInt(String.valueOf(bits.charAt(i)))==0){
                System.out.println("==0 "+String.valueOf(bits.charAt(i)));
                System.out.println(String.format("%32s", Integer.toBinaryString((rgb & ~mask1))).replace(' ', '0'));
            }else{
                System.out.println("==1 "+String.valueOf(bits.charAt(i)));
                System.out.println(String.format("%32s", Integer.toBinaryString((rgb | mask1))).replace(' ', '0'));
            }

        }

         */

      // System.out.println("Texte extrait de l'image :");
        //System.out.println(text);
        BufferedImage newImage = Steganographer.insert(image,"the hidden text yooo did it workl lam");
        ImageIO.write(newImage, "png", new File("new_image.png"));

        System.out.println(Steganographer.extract(newImage));
    }
}
