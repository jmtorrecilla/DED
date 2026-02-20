package edu.uoc.ds.adt.util;

import javax.swing.*;
import java.awt.*;

public class ArchimedeanSpiral extends JPanel {

    private final Point[] points;
    private int currentIndex = 0;

    public ArchimedeanSpiral(Point[] points) {
        this.points = points;
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(getWidth() / 2, getHeight() / 2);

        int size = 6;

        g2d.setColor(Color.GREEN);

        for (int i = 0; i <= currentIndex && i < points.length; i++) {
            double x = points[i].x();
            double y = points[i].y();
            g2d.fillOval((int) (x - size / 2), (int) (y - size / 2), size, size);
        }
    }

    public void startAnimation(int delayMs) {
        Timer timer = new Timer(delayMs, e -> {
            if (currentIndex < points.length - 1) {
                currentIndex++;
                repaint();
            } else {
                ((Timer) e.getSource()).stop();
            }

        });
        timer.start();
    }

    public static void main(String[] args) {

        double a = 0;
        double b = 5;
        double thetaMax = 10 * Math.PI;
        double step = 0.05;

//        Point[] points = SpiralGenerator.generate(a, b, thetaMax, step);
        Point[] points = SpiralGeneratorDummy.generate();


        ArchimedeanSpiral panel = new ArchimedeanSpiral(points);

        JFrame frame = new JFrame("Archimedean Spiral Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.add(panel);
        frame.setVisible(true);

        panel.startAnimation(10);
    }
}
