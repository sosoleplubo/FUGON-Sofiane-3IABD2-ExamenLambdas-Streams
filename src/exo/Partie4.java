package exo;

import models.Trip;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class Partie4 {

    private static final Function<Trip, Double> getPrix = trip ->
            trip.price();
    private static final Function<Trip, String> groupByCity =
            trip -> trip.city();

    private static final Predicate<Trip> isPremium =
            trip -> trip.price() > 30 && trip.rating() > 4;




    public double totalRevenueSequential(List<Trip> trips) {
        return trips.stream()
                .map(getPrix)
                .reduce(0.0, Double::sum);
    }

    public double totalRevenueParallel(List<Trip> trips) {
        // parallelStream()
        return trips.parallelStream()
                .map(getPrix)
                .reduce(0.0, Double::sum);
    }

    public Map<String, Long> countByCityParallel(List<Trip> trips) {
        // coder ici
        return trips.parallelStream()
                .collect(Collectors.groupingBy(groupByCity, Collectors.counting()));

    }

    public List<Trip> premiumTripsParallel(List<Trip> trips) {
        // prix > 30 et rating > 4
        return trips.parallelStream()
                .filter(isPremium)
                .toList();
    }
}
