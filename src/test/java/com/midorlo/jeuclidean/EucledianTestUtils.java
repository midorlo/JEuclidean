package com.midorlo.jeuclidean;

import javax.swing.*;
import java.awt.*;
import java.security.SecureRandom;

public class EucledianTestUtils {

    static SecureRandom secureRandom = new SecureRandom();

    public static EuclideanArrayList createExampleData() {

        return createExampleData(
                secureRandom.nextInt(10),
                secureRandom.nextInt(10),
                secureRandom.nextInt(10));
    }

    public static EuclideanArrayList createExampleData(int rx, int ry, int rz) {

        EuclideanArrayList l = new EuclideanArrayList();
        for (int x = 1; x <= rx; x++) {
            for (int y = 1; y <= ry; y++) {
                for (int z = 1; z <= rz; z++) {
                    l.add(new EuclideanObject("" + x + y + z, x, y, z, 0, 0));
                }
            }
        }
        return l;
    }


    public static void main(String[] args) {
SwingUtilities.invokeLater(() -> {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1024, 768);
        frame.setLocationRelativeTo(null);

frame.setContentPane(new JPanel(new GridLayout(0, 10)));
        createExampleData(3, 3, 2).stream().map(EuclideanObjectUi::new).forEach(u -> frame.getContentPane().add(u));
        frame.setVisible(true);
    System.out.print("x");
    });}
}
