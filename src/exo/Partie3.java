package exo;

import models.Trip;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.ToDoubleFunction;

public class Partie3 {

    private static final Comparator<Trip> byPrice =
            (t1, t2) -> Double.compare(t2.price(), t1.price());

    private static final Comparator<Trip> byRating =
            (t1, t2) -> Double.compare(t2.rating(), t1.rating());


    public List<Trip> top10ExpensiveTrips(List<Trip> trips) {
        return trips
                .stream()
                .sorted(byPrice)
                .limit(10)
                .toList();
    }

    public Optional<Trip> bestTrip(List<Trip> trips) {
        return trips
                .stream()
                .max(byRating);
    }
}
