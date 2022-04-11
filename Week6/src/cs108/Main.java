package cs108;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.util.HashMap;
import java.util.Map;

import static javax.swing.SwingUtilities.invokeLater;

public final class Main {
    private static LSystem koch() {
        Map<Character, String> rulesStar = Map.of('F', "F-F++F-F");
        Map<Character, String> rulesSierpinski = Map.of('A',"+B-A-B+",'B',"-A+B+A-");
        Map<Character, String> rulesHilbert = Map.of('A',"-BF+AFA+FB-",'B',"+AF-BFB-FA+");
        Map<Character, String> rulesTree = Map.of('F',"FF+[+F-F-F]-[-F+F+F]");

        return new LSystem("----F", rulesTree, "F", 25);
    }

    public static void main(String[] args) {
        // Le L-système à dessiner
        LSystem lSystem = koch().evolve(6);

        invokeLater(() -> {
            Path2D lSystemPath = LSystemPainter.paint(lSystem);

            JFrame mainWindow = new JFrame("L-Système");
            mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            mainWindow.getContentPane().setLayout(new BorderLayout());
            PathComponent pathComponent = new PathComponent();
            pathComponent.setPreferredSize(new Dimension(400, 400));
            pathComponent.setPath(lSystemPath);
            mainWindow.getContentPane().add(pathComponent, BorderLayout.CENTER);

            mainWindow.pack();
            mainWindow.setVisible(true);
        });
    }
}
