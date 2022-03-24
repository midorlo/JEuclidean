package com.midorlo.jeuclidean;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class EuclideanObjectUiTest {

    EuclideanObjectUi testObject, equalTestObject, nonEqualTestObject;

    @BeforeEach
    void init() {

        testObject         = new EuclideanObjectUi(new EuclideanObject("testObject", 0, 0, 0, 100, 100));
        equalTestObject    = new EuclideanObjectUi(new EuclideanObject("testObject", 0, 0, 0, 100, 100));
        nonEqualTestObject = new EuclideanObjectUi(new EuclideanObject("nonEqualTestObject", 1, 1, 1, 10, 10));
    }

    @Test
    @DisplayName("equals()")
    void testEquals() {

        assertEquals(testObject, equalTestObject);
        assertNotEquals(testObject, nonEqualTestObject);
    }


    @Test
    @DisplayName("hashCode()")
    void testHashCode() {

        assertEquals(testObject.hashCode(), equalTestObject.hashCode());
        assertNotEquals(testObject.hashCode(), nonEqualTestObject.hashCode());
    }

    @Test
    @DisplayName("toString()")
    void testToString() {

        assertNotNull(testObject.toString());
    }

}