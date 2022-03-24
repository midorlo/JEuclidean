package com.midorlo.jeuclidean;

import lombok.Data;

@Data
public class EuclideanObject {
    String id;
    Integer x,y,z,w,h;

    public EuclideanObject(String id, Integer x, Integer y, Integer z, Integer w, Integer h) {

        this.id = id;
        this.x  = x;
        this.y  = y;
        this.z  = z;
        this.w  = w;
        this.h  = h;
    }
}
