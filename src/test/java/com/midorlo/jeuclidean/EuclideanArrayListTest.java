package com.midorlo.jeuclidean;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class EuclideanArrayListTest {

    EuclideanArrayList testObject, equalTestObject, nonEqualTestObject;

    @BeforeEach
    void init() {

        testObject         = EucledianTestUtils.createExampleData();
        equalTestObject    = testObject;
        nonEqualTestObject = EucledianTestUtils.createExampleData(10, 10, 10);
    }


    @Test
    @DisplayName("equals()")
    void testEquals() {

        assertEquals(testObject, equalTestObject);
        assertNotEquals(testObject, nonEqualTestObject);
    }

    @Test
    void orderBy() {

        List<EuclideanObject> l = nonEqualTestObject.orderBy(EuclideanArrayList.Perspective.FRONTAL);
        assertEquals(1, (int) l.get(0).getX());
        assertEquals(1, (int) l.get(0).getY());
        assertEquals(10, (int) l.get(l.size() - 1).getX());
        assertEquals(10, (int) l.get(l.size() - 1).getY());
    }

    @Test
    void slice() {

        nonEqualTestObject.slice(EuclideanArrayList.Axis.X, 0).forEach(i -> assertEquals(i.getX(), 0));
        nonEqualTestObject.slice(EuclideanArrayList.Axis.Y, 1).forEach(i -> assertEquals(i.getY(), 1));
        nonEqualTestObject.slice(EuclideanArrayList.Axis.Z, 10).forEach(i -> assertEquals(i.getZ(), 10));
    }

    @Test
    void getMaxDimension3D() {

        assertEquals(10, nonEqualTestObject.getMaxDimension3D().getDepth());
    }

    @Test
    void getMinDimension3D() {
        assertEquals(1, nonEqualTestObject.getMinDimension3D().getDepth());
    }
}