package com.sfedu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    private final double DELTA = 0.00001;

    public static void main(String[] args) {

        List<Point<Integer>> points = new ArrayList<>();
        List<Point<Double>> doublePoints = new ArrayList<>();

        points.add(new Point<>(2, 5));
        points.add(new Point<>(7, 10));
        points.add(new Point<>(0, 6));
        points.add(new Point<>(3, 4));

        doublePoints.add(new Point<>(3.0, 4.0));
        doublePoints.add(new Point<>(2.5, 1.7));
        doublePoints.add(new Point<>(5.4, 7.4));
        doublePoints.add(new Point<>(5.3, 0.5));

        System.out.println("Integer: " + points);
        System.out.println("Double: " + doublePoints);

        System.out.println("=========================Task 1=======================");
        System.out.println("Наибольшая точка по X (Integer) - " + getMaxX(points));
        System.out.println("Наибольшая точка по X (Double) - " + getMaxX(doublePoints));
        System.out.println("======================================================");

        System.out.println("=========================Task 2=======================");
        System.out.println("Integer: ");
        getDistance(points)
                .forEach(System.out::println);
        System.out.println("======================================================");
        System.out.println("Double: ");
        getDistance(doublePoints)
                .forEach(System.out::println);
        System.out.println("======================================================");

        System.out.println("=========================Task 3=======================");
        getPointsWithDistanceBiggerThan5(points)
                .forEach(System.out::println);
        System.out.println("======================================================");
        System.out.println("Double: ");
        getPointsWithDistanceBiggerThan5(doublePoints)
                .forEach(System.out::println);
        System.out.println("======================================================");

        System.out.println("=========================Task 4=======================");
        System.out.println("Integer: ");
        System.out.println(sortPoints(points));
        System.out.println("======================================================");
        System.out.println("Double: ");
        System.out.println(sortPoints(doublePoints));
        System.out.println("======================================================");

    }

    public static <T extends Number & Comparable<T>> Point<T> getMaxX(List<Point<T>> points) {
        return points
                .stream()
                .max(Comparator.comparing(Point::getX))
                .orElseThrow(NoSuchElementException::new);
    }

    public static <T extends Number> Stream<Double> getDistance(List<Point<T>> points) {
        return points
                .stream()
                .map(Point::distance);
    }

    public static <T extends Number> Stream<Point<T>> getPointsWithDistanceBiggerThan5(List<Point<T>> points) {
        return points
                .stream()
                .filter(point -> point.distance() > 5);
    }

    public static <T extends Number> List<Point<T>> sortPoints(List<Point<T>> points) {
        return points
                .stream()
                .sorted(Comparator.comparingDouble(Point::distance)).collect(Collectors.toList());
    }
}
