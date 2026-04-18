package com.codejourney.math;

import java.util.*;
import java.util.stream.Collectors;

/**
 * A collection of mathematical / algorithmic problems solved with Java Streams.
 *
 * Problem 1 — Find the Missing Number:
 *   Given a list of n integers (0 to n with one missing), find the missing value.
 *   Approach: Use the formula for the sum of first n natural numbers: n*(n+1)/2.
 *   Subtract the actual sum of the list. The difference is the missing number.
 *
 * Problem 2 — K Nearest Points to Origin:
 *   Given a list of (latitude, longitude) points, sort them by Euclidean distance
 *   from the origin (0, 0) and return all sorted by proximity.
 *   Approach: Compute distance = √(x² + y²) for each point.
 *   Sort points by this distance using Comparator.comparingDouble.
 *
 * Important Methods:
 *   n * (n + 1) / 2                          // Gauss formula
 *   Math.sqrt(x * x + y * y)                 // Euclidean distance
 *   Comparator.comparingDouble(Point::distanceFromOrigin)
 *   .sorted(comparator).collect(Collectors.toList())
 *   record Point(int latitude, int longitude) // concise data class
 */
public class MathProblems {

    // --- Problem 2 helper ---
    record Point(int latitude, int longitude) {
        public double distanceFromOrigin() {
            return Math.sqrt((double) latitude * latitude + (double) longitude * longitude);
        }
    }

    public static void main(String[] args) {

        // Problem 1: Find the missing number
        System.out.println("=== Problem 1: Find the Missing Number ===");
        List<Integer> listWithMissing = Arrays.asList(0, 3, 2, 5, 4, 1);  // missing: 6
        int missing = findMissingNumber(listWithMissing);
        System.out.println("List: " + listWithMissing);
        System.out.println("Missing number: " + missing);

        List<Integer> anotherList = Arrays.asList(1, 2, 3, 5);  // missing: 4
        System.out.println("\nList: " + anotherList);
        System.out.println("Missing number: " + findMissingNumber(anotherList));

        // Problem 2: Nearest points to origin
        System.out.println("\n=== Problem 2: K Nearest Points to Origin ===");
        List<Point> points = Arrays.asList(
                new Point(2, 3),
                new Point(0, 2),
                new Point(2, 2),
                new Point(5, 5),
                new Point(1, 1),
                new Point(7, 9)
        );
        sortPointsByDistance(points);

        System.out.println("\n-- 3 Nearest Points --");
        findKNearestPoints(points, 3);
    }

    /**
     * Problem 1: Missing Number
     * Uses Gauss formula: expected sum = n*(n+1)/2
     * Missing = expectedSum - actualSum
     */
    private static int findMissingNumber(List<Integer> list) {
        int n = list.size();
        int expectedSum = n * (n + 1) / 2;
        int actualSum = list.stream().mapToInt(Integer::intValue).sum();
        return expectedSum - actualSum;
    }

    /**
     * Problem 2: Sort all points by distance from origin
     */
    private static void sortPointsByDistance(List<Point> points) {
        List<Point> sorted = points.stream()
                .sorted(Comparator.comparingDouble(Point::distanceFromOrigin))
                .collect(Collectors.toList());
        System.out.println("Points sorted by distance from origin:");
        sorted.forEach(p -> System.out.printf(
                "  Point(%d, %d) → distance: %.4f%n",
                p.latitude(), p.longitude(), p.distanceFromOrigin()));
    }

    /**
     * Problem 2 variant: Find the K nearest points to origin
     */
    private static void findKNearestPoints(List<Point> points, int k) {
        List<Point> nearest = points.stream()
                .sorted(Comparator.comparingDouble(Point::distanceFromOrigin))
                .limit(k)
                .collect(Collectors.toList());
        System.out.println(k + " nearest points: " + nearest);
    }
}
