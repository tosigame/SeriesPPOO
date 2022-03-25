package cs108;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static javax.swing.SwingUtilities.invokeLater;

public final class Main {
    public static void main(String[] args) {
        // L'image à afficher, à modifier au fur et à mesure de
        // votre avancement.
        ImageRGB image = RedDisk.IMAGE;

        invokeLater(() -> {
            try {
                var mainWindow = new JFrame("Image viewer");
                mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                mainWindow.getContentPane().setLayout(new BorderLayout());
                var imageComponent = new ImageComponent(image, 0, 0, 4);
                mainWindow.getContentPane().add(imageComponent, BorderLayout.CENTER);

                mainWindow.pack();
                mainWindow.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @SuppressWarnings("serial")
    private static final class ImageComponent extends JComponent {
        private final ImageRGB image;
        private final double centerX, centerY;
        private final double width;

        public ImageComponent(ImageRGB image, double centerX, double centerY, double width) {
            this.image = image;
            this.centerX = centerX;
            this.centerY = centerY;
            this.width = width;
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 280);
        }

        @Override
        protected void paintComponent(Graphics g0) {
            var g = (Graphics2D)g0;

            var jImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
            var inc = width / getWidth();
            var xMin = centerX - inc * (getWidth() / 2.0);
            var yMax = centerY + inc * (getHeight() / 2.0);
            for (var imageX = 0; imageX < getWidth(); imageX += 1) {
                var x = xMin + inc * imageX;
                for (var imageY = 0; imageY < getHeight(); imageY += 1) {
                    var y = yMax - inc * imageY;
                    jImage.setRGB(imageX, imageY, image.apply(x, y).toAWTColor().getRGB());
                }
            }

            g.drawImage(jImage, 0, 0, null);
        }
    }
}
