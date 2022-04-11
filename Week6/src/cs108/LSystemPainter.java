package cs108;

import java.awt.geom.Path2D;
import java.util.ArrayDeque;
import java.util.Deque;

public final class LSystemPainter {
    private LSystemPainter() {}

    public static Path2D paint(LSystem lSystem) {
        String s = lSystem.string();
        Turtle t = new Turtle();
        Deque<Turtle> turtleStack = new ArrayDeque<>();
        Path2D.Double p = new Path2D.Double();
        p.moveTo(t.x(), t.y());
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            switch (c) {
            case '-':
                t = t.turned(-lSystem.turningAngle());
                break;
            case '+':
                t = t.turned(lSystem.turningAngle());
                break;
            case '[':
                turtleStack.addFirst(t);
                break;
            case ']':
                t = turtleStack.removeFirst();
                p.moveTo(t.x(), t.y());
                break;
            default:
                if (lSystem.lineChars().contains(c)) {
                    t = t.moved(1);
                    p.lineTo(t.x(), t.y());
                }
                break;
            }
        }
        return p;
    }
}
