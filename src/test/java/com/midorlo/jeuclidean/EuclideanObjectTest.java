package com.midorlo.jeuclidean;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


@Slf4j
@DisplayName("EuclideanObject Test")
class EuclideanObjectTest {

    EuclideanObject testObject, equalTestObject, nonEqualTestObject;

    @BeforeEach
    void init() {

        testObject         = new EuclideanObject("testObject", 0, 0, 0, 100, 100);
        equalTestObject    = new EuclideanObject("testObject", 0, 0, 0, 100, 100);
        nonEqualTestObject = new EuclideanObject("nonEqualTestObject", 1, 1, 1, 10, 10);
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