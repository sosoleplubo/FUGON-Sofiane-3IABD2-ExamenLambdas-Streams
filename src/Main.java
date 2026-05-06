import factory.TripFactory;
import models.Trip;
import exo.Partie1;

void main() {

    // appeler les méthodes des exos ici
    // pour tester si ça marche bien, générer une liste de 10 éléments et afficher le résultat

    System.out.println("Partie 1");

    Partie1 partie1 = new Partie1();

    System.out.println("exo1");
    List<Trip> trips = TripFactory.generateTrips(10);

    List<Trip> result = partie1.longAndExpensiveTrips(trips);
    result.forEach(System.out::println);

    System.out.println("exo2");
    trips = TripFactory.generateTrips(10);

    result = partie1.badTrips(trips);
    result.forEach(System.out::println);

    System.out.println("exo3");
    trips = TripFactory.generateTrips(20);

    result = partie1.recentTrips(trips);
    result.forEach(System.out::println);


}