package com.midorlo.jeuclidean;

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
}
