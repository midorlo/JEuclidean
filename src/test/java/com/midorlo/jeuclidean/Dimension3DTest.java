package com.midorlo.jeuclidean;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class Dimension3DTest {

    Dimension3D testObject, equalTestObject, nonEqualTestObject;

    @BeforeEach
    void init() {

        testObject         = new Dimension3D(1, 1, 1);
        equalTestObject    = new Dimension3D(1, 1, 1);
        nonEqualTestObject = new Dimension3D(1, 1, 2);
    }

    @Test
    @DisplayName("equals()")
    void testEquals() {

        assertEquals(testObject, equalTestObject);
        assertNotEquals(testObject, nonEqualTestObject);
    }

    @Test
    @DisplayName("canEqual()")
    void canEqual() {

        assertTrue(testObject.canEqual(equalTestObject));
        assertTrue(testObject.canEqual(nonEqualTestObject));
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