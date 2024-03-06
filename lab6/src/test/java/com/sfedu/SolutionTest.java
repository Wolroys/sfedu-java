package com.sfedu;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final double DELTA = 0.05;

    @Test
    void getMaxXTest() {
        List<Point<Integer>> points = new ArrayList<>();
        List<Point<Double>> doublePoints = new ArrayList<>();

        points.add(new Point<>(2, 5));
        points.add(new Point<>(7, 10));
        points.add(new Point<>(0, 6));

        doublePoints.add(new Point<>(2.5, 1.7));
        doublePoints.add(new Point<>(5.3, 0.5));
        doublePoints.add(new Point<>(5.4, 7.4));

        assertEquals(7, Solution.getMaxX(points).getX());
        assertEquals(5.4, Solution.getMaxX(doublePoints).getX(), DELTA);
    }

    @Test
    void getDistanceBetweenPointsTest() {
        List<Point<Integer>> points = new ArrayList<>();
        List<Point<Double>> doublePoints = new ArrayList<>();

        points.add(new Point<>(2, 5));
        points.add(new Point<>(7, 10));
        points.add(new Point<>(0, 6));

        doublePoints.add(new Point<>(2.5, 1.7));
        doublePoints.add(new Point<>(5.3, 0.5));
        doublePoints.add(new Point<>(5.4, 7.4));

        Solution.getDistance(points).forEach(System.out::println);
        System.out.println("=============================");
        Solution.getDistance(doublePoints).forEach(System.out::println);

        Stream<Double> intStream = Solution.getDistance(points);
        Stream<Double> doubleStream = Solution.getDistance(doublePoints);

        List<Double> intExpected = List.of(5.38, 12.206, 6.0);
        List<Double> doubleExpected = List.of(3.023, 5.323, 9.16);

        List<Double> intActual = intStream.toList();
        List<Double> doubleActual = doubleStream.toList();

        for (int i = 0; i < intExpected.size(); i++) {
            assertEquals(intExpected.get(i), intActual.get(i), DELTA);
            assertEquals(doubleExpected.get(i), doubleActual.get(i), DELTA);
        }
    }

    @Test
    void filterTest() {
        List<Point<Integer>> points = new ArrayList<>();
        List<Point<Double>> doublePoints = new ArrayList<>();

        points.add(new Point<>(2, 5));
        points.add(new Point<>(7, 10));
        points.add(new Point<>(0, 6));

        doublePoints.add(new Point<>(2.5, 1.7));
        doublePoints.add(new Point<>(5.3, 0.5));
        doublePoints.add(new Point<>(5.4, 7.4));

        Stream<Point<Integer>> intStream = Solution.getPointsWithDistanceBiggerThan5(points);
        Stream<Point<Double>> doubleStream = Solution.getPointsWithDistanceBiggerThan5(doublePoints);

        assertEquals(3, intStream.toList().size());
        assertEquals(2, doubleStream.toList().size());
    }

    @Test
    void sortedListTest() {
        List<Point<Integer>> points = new ArrayList<>();
        List<Point<Double>> doublePoints = new ArrayList<>();

        points.add(new Point<>(2, 5));
        points.add(new Point<>(7, 10));
        points.add(new Point<>(0, 6));

        doublePoints.add(new Point<>(2.5, 1.7));
        doublePoints.add(new Point<>(5.3, 0.5));
        doublePoints.add(new Point<>(5.4, 7.4));

        List<Point<Integer>> actual = Solution.sortPoints(points);
        List<Point<Double>> doubleActual = Solution.sortPoints(doublePoints);


        List<Integer> expectedX = List.of(2, 0, 7);
        List<Double> doubleExpectedX = List.of(2.5, 5.3, 5.4);

        for (int i = 0; i < expectedX.size(); i++) {
            assertEquals(expectedX.get(i), actual.get(i).getX());
            assertEquals(doubleExpectedX.get(i), doubleActual.get(i).getX(), DELTA);
        }
    }
}