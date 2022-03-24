package com.midorlo.jeuclidean;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EuclideanArrayList extends ArrayList<EuclideanObject> {

    public static final Comparator<EuclideanObject> orderByXDesc = Comparator.comparing(EuclideanObject::getX);
    public static final Comparator<EuclideanObject> orderByYDesc = Comparator.comparing(EuclideanObject::getY);
    public static final Comparator<EuclideanObject> orderByZDesc = Comparator.comparing(EuclideanObject::getZ);
    public static final Comparator<EuclideanObject> orderByXAsc  = orderByXDesc.reversed();
    public static final Comparator<EuclideanObject> orderByYAsc  = orderByXDesc.reversed();
    public static final Comparator<EuclideanObject> orderByZAsc  = orderByXDesc.reversed();

    public List<EuclideanObject> orderBy(Perspective eucledianPerspective) {

        return stream().sorted(eucledianPerspective.getValue()).collect(Collectors.toList());
    }

    public EuclideanArrayList slice(Axis axis, int index) {

        return stream().filter(euclideanObject -> axis.getValue().apply(index).test(euclideanObject))
                       .collect(Collectors.toCollection(EuclideanArrayList::new));

    }

    public Dimension3D getMaxDimension3D() {

        return new Dimension3D(stream().max(orderByXDesc).map(EuclideanObject::getX).orElse(0),
                               stream().max(orderByYDesc).map(EuclideanObject::getY).orElse(0),
                               stream().max(orderByZDesc).map(EuclideanObject::getZ).orElse(0));
    }

    public Dimension3D getMinDimension3D() {

        return new Dimension3D(stream().min(orderByXDesc).map(EuclideanObject::getX).orElse(0),
                               stream().min(orderByYDesc).map(EuclideanObject::getY).orElse(0),
                               stream().min(orderByZDesc).map(EuclideanObject::getZ).orElse(0));
    }

    public enum Axis {

        X(x -> euclideanObject -> euclideanObject.getX().equals(x)),
        Y(y -> euclideanObject -> euclideanObject.getY().equals(y)),
        Z(z -> euclideanObject -> euclideanObject.getZ().equals(z));

        private final Function<Integer, Predicate<EuclideanObject>> value;

        Axis(Function<Integer, Predicate<EuclideanObject>> value) {this.value = value;}

        private Function<Integer, Predicate<EuclideanObject>> getValue() {

            return value;
        }
    }

    public enum Perspective {

        FRONTAL(orderByXDesc.thenComparing(orderByYDesc)),
        BACK(orderByXAsc.thenComparing(orderByYAsc)),

        TOP(orderByXDesc.thenComparing(orderByZDesc)),
        BOTTOM(orderByXAsc.thenComparing(orderByZAsc)),

        LEFT(orderByYDesc.thenComparing(orderByZDesc)),
        RIGHT(orderByYAsc.thenComparing(orderByZAsc));

        private final Comparator<EuclideanObject> value;

        Perspective(Comparator<EuclideanObject> value) {

            this.value = value;
        }

        private Comparator<EuclideanObject> getValue() {

            return value;
        }
    }
}
