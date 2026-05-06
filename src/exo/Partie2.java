package exo;

import models.Trip;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class Partie2 {


    private static final Function<Trip, String> groupByCity =
            trip -> trip.city();

    private static final Function<Trip, String> groupByDriver =
            trip -> trip.driverId();

    private static final ToDoubleFunction<Trip> getRevenue =
            trip ->  trip.price();

    private static final ToDoubleFunction<Trip> getDuree =
            trip ->  trip.durationMin();



    public Map<String, Long> countByCity(List<Trip> trips) {
        return trips.stream()
                .collect(Collectors.groupingBy(groupByCity, Collectors.counting()));

    }

    public Map<String, Double> revenueByDriver(List<Trip> trips) {
        return trips.stream()
                .collect(Collectors.groupingBy(groupByDriver, Collectors.summingDouble(getRevenue)));
    }

    public Map<String, Double> avgDurationByCity(List<Trip> trips) {
        return trips.stream()
                .collect(Collectors.groupingBy(groupByCity, Collectors.averagingDouble(getDuree)));
    }
}