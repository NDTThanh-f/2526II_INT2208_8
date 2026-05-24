package org.example;

public class Triangle {
    public static String typeOfTriangle(int a, int b, int c) {
        if (a < 1 || b < 1 || c < 1 || a > 100 || b > 100 || c > 100)
            return "Invalid Input";

        if (a + b <= c || b + c <= a || a + c <= b)
            return "Not a Triangle";

        if (a == b && b == c)
            return "Equilateral";

        if (a == b || b == c || c == a)
            return "Isosceles";

        return "Scalene";
    }
}