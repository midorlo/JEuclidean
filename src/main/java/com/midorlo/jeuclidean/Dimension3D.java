package com.midorlo.jeuclidean;

import lombok.Data;

@Data
public class Dimension3D {

    private final Integer width;
    private final Integer height;
    private final Integer depth;

    public Dimension3D(Integer width, Integer height, Integer depth) {

        this.width  = width;
        this.height = height;
        this.depth  = depth;
    }
}
