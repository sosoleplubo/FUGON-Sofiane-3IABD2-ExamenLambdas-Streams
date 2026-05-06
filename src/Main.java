import factory.TripFactory;
import models.Trip;
import exo.Partie1;
import exo.Partie2;
import exo.Partie3;
import exo.Partie4;

void main() {

    // appeler les méthodes des exos ici
    // pour tester si ça marche bien, générer une liste de 10 éléments et afficher le résultat

    System.out.println("Partie 1\n");

    Partie1 partie1 = new Partie1();

    System.out.println("exo1\n");
    List<Trip> trips = TripFactory.generateTrips(10);

    List<Trip> result = partie1.longAndExpensiveTrips(trips);
    result.forEach(System.out::println);

    System.out.println("exo2\n");
    trips = TripFactory.generateTrips(10);

    result = partie1.badTrips(trips);
    result.forEach(System.out::println);

    System.out.println("exo3\n");
    trips = TripFactory.generateTrips(20);

    result = partie1.recentTrips(trips);
    result.forEach(System.out::println);

    System.out.println("Partie 2\n");

    Partie2 partie2 = new Partie2();

    System.out.println("exo4 \n");
    trips = TripFactory.generateTrips(10);

    Map<String, Long> result4 = partie2.countByCity(trips);
    result4.forEach((city, count) -> System.out.println(city + " " + count));

    System.out.println("exo5 \n");
    trips = TripFactory.generateTrips(10);

    Map<String, Double> result5 = partie2.revenueByDriver(trips);
    result5.forEach((driver, revenue) -> System.out.println(driver + " " + revenue));

    System.out.println("exo6 \n");
    trips = TripFactory.generateTrips(10);

    Map<String, Double> result6 = partie2.avgDurationByCity(trips);
    result6.forEach((city, count) -> System.out.println(city + " " + count));

    System.out.println("Partie 3\n");





}