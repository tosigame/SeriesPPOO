

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.StringJoiner;

public final class Steganographer {
    private Steganographer() { }

    public static String extract(BufferedImage image) {
        // TODO: à faire (exercice 1)
        StringBuilder b = new StringBuilder();
        int bits = 0, bitsCount = 0;
        for (int y = 0; y < image.getHeight(); ++y) {
            for (int x = 0; x < image.getWidth(); ++x) {
                int rgb = image.getRGB(x, y);
                bits = (bits << 1) | (rgb & 1);
                if (++bitsCount == Character.SIZE) {
                    b.append((char) bits);
                    bits = bitsCount = 0;
                }
            }
        }
        return b.toString();

    }

    public static BufferedImage insert(BufferedImage image, String string) {
        // TODO: à faire (exercice 2)
        char[] letters= string.toCharArray();
        BufferedImage outImage =
                new BufferedImage(image.getWidth(),
                        image.getHeight(),
                        BufferedImage.TYPE_INT_RGB);
        //System.out.println();
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < letters.length; i++) {
            stringBuilder.append(String.format("%16s", Integer.toBinaryString(i)).replace(' ', '0'));
        }
        for (int i = letters.length; i < outImage.getHeight()*outImage.getWidth(); i++) {
            stringBuilder.append("0");
        }
        String binarySequence= stringBuilder.toString();
       // System.out.println(binarySequence);
        for(int y=0; y < image.getHeight(); y++){
            for(int x=0; x < image.getWidth(); x++){
                int rgb = image.getRGB(x, y);
                int bit = (Integer.parseInt(String.valueOf(binarySequence.charAt(outImage.getHeight()*y+x))) >> --bitI) & 1;
                outImage.setRGB(x, y, (rgb & ~1) | bit);
                outImage.setRGB(x,y,(rgb & ~1) | bit);
            }
        }
        return outImage;
    }
}
