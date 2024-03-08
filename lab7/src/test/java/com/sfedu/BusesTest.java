package com.sfedu;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BusesTest {

    @Test
    void addBusShouldReturn1AndThan2() {
        Buses buses = new Buses();

        int num1 = 0;
        int num2 = 0;
        try {
            num1 = buses.addBus("1", new String[]{"3", "2"});
            num2 = buses.addBus("1", new String[]{"3", "1"});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assertEquals(1, num1);
        assertEquals(2, num2);
    }

    @Test
    void sbusesForStopShouldReturn3BusesInOrder() {
        Buses buses = new Buses();

        List<String> expected = List.of("5", "3", "4");
        List<String> actual;

        try {
            buses.addBus("5", new String[]{"z", "b", "c"});
            buses.addBus("2", new String[]{"z", "x", "c"});
            buses.addBus("3", new String[]{"f", "a", "b"});
            buses.addBus("4", new String[]{"b", "d", "e"});

            actual = buses.sbusesForStop("b");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    void nbusesForStopShouldReturn3BusesInOrder() {
        Buses buses = new Buses();

        Set<Integer> expected = Set.of(1, 3, 4);
        Set<Integer> actual;

        try {
            buses.addBus("5", new String[]{"z", "b", "c"});
            buses.addBus("2", new String[]{"z", "x", "c"});
            buses.addBus("3", new String[]{"f", "a", "b"});
            buses.addBus("4", new String[]{"b", "d", "e"});
            buses.addBus("5", new String[]{"b", "d", "e"});

            actual = buses.nbusesForStop("b");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assertEquals(expected, actual);
    }

    @Test
    void stopsForBus3ShouldReturnMapWithSize3() {
        Buses buses = new Buses();

        Map<String, Set<Integer>> expected = Map.of(
                "a", Set.of(3, 4),
                "b", Set.of(1, 3, 5),
                "f", Set.of(3));

        Map<String, Set<Integer>> actual;

        try {
            buses.addBus("5", new String[]{"z", "b", "c"});
            buses.addBus("2", new String[]{"z", "x", "c"});
            buses.addBus("3", new String[]{"f", "a", "b"});
            buses.addBus("4", new String[]{"a", "d", "e"});
            buses.addBus("5", new String[]{"b", "d", "e"});

            actual = buses.stopsForBus("3");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assertEquals(expected.size(), actual.size());
        assertEquals(expected, actual);
    }

    @Test
    void allBusesShouldReturnListWithSize5() {
        Buses buses = new Buses();

        List<String> expected = List.of("2", "3", "4", "5", "5");

        List<String> actual;

        try {
            buses.addBus("5", new String[]{"z", "b", "c"});
            buses.addBus("2", new String[]{"z", "x", "c"});
            buses.addBus("3", new String[]{"f", "a", "b"});
            buses.addBus("4", new String[]{"a", "d", "e"});
            buses.addBus("5", new String[]{"b", "d", "e"});

            actual = buses.allBuses();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assertEquals(expected.size(), actual.size());

        System.out.println(actual);
    }

}