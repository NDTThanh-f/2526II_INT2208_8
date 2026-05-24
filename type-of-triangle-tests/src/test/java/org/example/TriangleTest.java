package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Type of Triangle Tests")
class TriangleTest {

    @Test
    @DisplayName("Invalid Input (a < 1)")
    void invalidInputTest1() {
        assertEquals("Invalid Input", Triangle.typeOfTriangle(0, 50, 50));
    }

    @Test
    @DisplayName("Invalid Input (a > 100)")
    void invalidInputTest2() {
        assertEquals("Invalid Input", Triangle.typeOfTriangle(101, 50, 50));
    }

    @Test
    @DisplayName("Invalid Input (b < 1)")
    void invalidInputTest3() {
        assertEquals("Invalid Input", Triangle.typeOfTriangle(50, 0, 50));
    }

    @Test
    @DisplayName("Invalid Input (b > 100)")
    void invalidInputTest4() {
        assertEquals("Invalid Input", Triangle.typeOfTriangle(50, 101, 50));
    }

    @Test
    @DisplayName("Invalid Input (c < 1)")
    void invalidInputTest5() {
        assertEquals("Invalid Input", Triangle.typeOfTriangle(50, 50, 0));
    }

    @Test
    @DisplayName("Invalid Input (c > 100)")
    void invalidInputTest6() {
        assertEquals("Invalid Input", Triangle.typeOfTriangle(50, 50, 101));
    }

    @Test
    @DisplayName("Not a Triangle (a + b < c)")
    void notATriangleTest1() {
        assertEquals("Not a Triangle", Triangle.typeOfTriangle(10, 20, 50));
    }

    @Test
    @DisplayName("Not a Triangle (a + b = c) & Lowerbound (a = 1)")
    void notATriangleTest2() {
        assertEquals("Not a Triangle", Triangle.typeOfTriangle(1, 2, 3));
    }

    @Test
    @DisplayName("Equilateral")
    void equilateralTest1() {
        assertEquals("Equilateral", Triangle.typeOfTriangle(50, 50, 50));
    }

    @Test
    @DisplayName("Equilateral & Upperbound (a = b = c = 100)")
    void equilateralTest2() {
        assertEquals("Equilateral", Triangle.typeOfTriangle(100, 100, 100));
    }

    @Test
    @DisplayName("Isosceles (a = b)")
    void isoscelesTest1() {
        assertEquals("Isosceles", Triangle.typeOfTriangle(50, 50, 40));
    }

    @Test
    @DisplayName("Isosceles (b = c)")
    void isoscelesTest2() {
        assertEquals("Isosceles", Triangle.typeOfTriangle(40, 50, 50));
    }

    @Test
    @DisplayName("Isosceles (a = c)")
    void isoscelesTest3() {
        assertEquals("Isosceles", Triangle.typeOfTriangle(50, 40, 50));
    }

    @Test
    @DisplayName("Scalene")
    void scaleneTest1() {
        assertEquals("Scalene", Triangle.typeOfTriangle(3, 4, 5));
    }

    @Test
    @DisplayName("Scalene & Upperbound (c = 100)")
    void scaleneTest2() {
        assertEquals("Scalene", Triangle.typeOfTriangle(98, 99, 100));
    }
}