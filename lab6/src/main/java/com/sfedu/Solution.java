package com.sfedu;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

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
