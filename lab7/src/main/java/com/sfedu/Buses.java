package com.sfedu;

import java.util.*;

public class Buses {

    private final Map<Integer, Bus> buses;
    private int number;

    public Buses() {
        buses = new LinkedHashMap<>();
        number = 1;
    }

    public int addBus(String name, String[] stops) throws Exception {
        for (Bus bus : buses.values()) {
            if (Arrays.equals(bus.stops, stops))
                throw new Exception("Already exists for " + bus.number);
        }

        Bus bus = new Bus(name, stops);
        buses.put(number, bus);
        bus.number = number;
        return number++;
    }

    public List<String> sbusesForStop(String nameStop) throws Exception {
        List<String> busesName = new ArrayList<>();
        if (!buses.values().stream().anyMatch(bus -> Arrays.asList(bus.stops).contains(nameStop)))
            throw new Exception("No stop");

        for (Bus bus : buses.values()) {
            if (Arrays.asList(bus.stops).contains(nameStop))
                busesName.add(bus.name);
        }

        return busesName;
    }

    public Set<Integer> nbusesForStop(String nameStop) throws Exception {
        Set<Integer> busesNumbers = new HashSet<>();
        if (!buses.values().stream().anyMatch(bus -> Arrays.asList(bus.stops).contains(nameStop)))
            throw new Exception("No stop");

        for (Bus bus : buses.values()) {
            if (Arrays.asList(bus.stops).contains(nameStop))
                busesNumbers.add(bus.number);
        }

        return busesNumbers;
    }

    public Map<String, Set<Integer>> stopsForBus(String name) throws Exception {
        if (!buses.values().stream().anyMatch(bus -> bus.name.equals(name)))
            throw new Exception("No bus");

        Map<String, Set<Integer>> stops = new HashMap<>();

        Bus currentBus = buses.values().stream().filter(bus -> bus.name.equals(name)).findFirst().get();

        for (String stop : currentBus.stops)
            stops.put(stop, new HashSet<>(Collections.singletonList(currentBus.number)));

        for (Bus bus : buses.values()) {
            if (bus.number != currentBus.number) {
                for (String stop : bus.stops) {
                    if (stops.containsKey(stop)) {
                        stops.get(stop).add(bus.number);
                    }
                }
            }
        }

        return stops;
    }

    public List<String> allBuses() throws Exception {
        if (buses.isEmpty())
            throw new Exception("No buses");

        List<String> busNames = new ArrayList<>();

        for (Bus bus : buses.values()) {
            busNames.add(bus.name);
        }

        Collections.sort(busNames);

        return busNames;
    }

    private static class Bus {
        private final String name;
        private final String[] stops;
        private int number;

        public Bus(String name, String[] stops) {
            this.name = name;
            this.stops = stops;
        }
    }
}
