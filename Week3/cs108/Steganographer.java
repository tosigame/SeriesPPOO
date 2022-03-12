

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
        return null;
    }
}
