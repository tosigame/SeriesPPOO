package cs108;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public final class PathComponent extends JComponent {
    private final static int MARGIN = 5;

    private Path2D path;

    public void setPath(Path2D newPath) {
        path = (Path2D) newPath.clone();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g0) {
        super.paintComponent(g0);
        Graphics2D g = (Graphics2D)g0;

        Rectangle2D bBox = path.getBounds2D();
        double sX = (getWidth() - 2*MARGIN) / bBox.getWidth();
        double sY = (getHeight() - 2*MARGIN) / bBox.getHeight();
        AffineTransform transform = new AffineTransform();
        transform.translate(MARGIN, MARGIN);
        transform.scale(sX, sY);
        transform.translate(-bBox.getMinX(), -bBox.getMinY());

        g.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0));
        g.draw(transform.createTransformedShape(path));
    }
}
