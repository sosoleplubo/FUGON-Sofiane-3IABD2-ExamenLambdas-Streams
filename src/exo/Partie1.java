package exo;

import models.Trip;

import java.time.LocalDate;
import java.util.function.Predicate;

import java.util.List;

public class Partie1 {

    private static final Predicate<Trip> isLong =
            trip -> trip.distanceKm() > 10;
    private static final Predicate<Trip> isExpensive =
            trip -> trip.price() > 20;
    private static final Predicate<Trip> isBad =
            trip -> trip.rating() < 3;
    private static final Predicate<Trip> isRecent = trip -> {
        LocalDate ajd = LocalDate.now();
        LocalDate hier = ajd.minusDays(1);
        LocalDate date = trip.startTime().toLocalDate();
        return date.equals(ajd) || date.equals(hier);
    };

    public List<Trip> longAndExpensiveTrips(List<Trip> trips) {
        // distance > 10km et prix > 20€
        return trips.stream()
                .filter(isLong.and(isExpensive))
                .toList();
    }

    public List<Trip> badTrips(List<Trip> trips) {
        // rating < 3
        return trips.stream()
                .filter(isBad)
                .toList();
    }

    public List<Trip> recentTrips(List<Trip> trips) {
        // aujourd’hui ou hier
        return trips.stream()
                .filter(isRecent)
                .toList();
    }
}
