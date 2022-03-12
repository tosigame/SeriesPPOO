


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedImage image = ImageIO.read(new File("Week3/pskov.png"));
        String text = Steganographer.extract(image);
        System.out.println("Texte extrait de l'image :");
        System.out.println(text);
    }
}
