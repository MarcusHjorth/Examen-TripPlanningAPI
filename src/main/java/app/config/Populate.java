package app.config;

import app.entities.Guide;
import app.entities.Trip;
import jakarta.persistence.EntityManagerFactory;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import app.enums.Category;


public class Populate {
    public static void main(String[] args) {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory("tripplanning");

        Set<Guide> guides = getGuides(); // Get guides

        try (var em = emf.createEntityManager()) {
            em.getTransaction().begin();

            // Persist guides
            for (Guide guide : guides) {
                em.persist(guide);
            }

            em.getTransaction().commit();
            em.close();
        }
    }
    @NotNull
    private static Set<Guide> getGuides(){

        List<Trip> trips = new ArrayList<>();
        trips.add(new Trip("12:00", "18:00", "Florida", "Jungle Trip", 50.00 , Category.FOREST));
        trips.add(new Trip("10:00", "16:00", "California", "Mountain Trip", 60.00 , Category.SEA));
        trips.add(new Trip("08:00", "14:00", "New York", "City Trip", 40.00 , Category.CITY));
        Guide guide1 = new Guide("Gary", "Goodman", "gary@gmail.com", "12345678", 12);
        guide1.setTrip(trips);


        // Guide 2
        List<Trip> trips2 = new ArrayList<>();
        trips2.add(new Trip("09:00", "15:00", "Alaska", "Snowy Peaks Adventure", 70.00, Category.SNOW));
        trips2.add(new Trip("13:00", "19:00", "Hawaii", "Sunny Beach Day", 55.00, Category.BEACH));
        trips2.add(new Trip("11:00", "17:00", "Minnesota", "Lake Serenity", 65.00, Category.LAKE));
        Guide guide2 = new Guide("Alice", "Anderson", "alice@gmail.com", "87654321", 8);
        guide2.setTrip(trips2);


        // Guide 3
        List<Trip> trips3 = new ArrayList<>();
        trips3.add(new Trip("07:30", "13:30", "Colorado", "Forest Trail Hike", 45.00, Category.FOREST));
        trips3.add(new Trip("14:00", "20:00", "Miami", "City Lights Tour", 80.00, Category.CITY));
        trips3.add(new Trip("12:00", "18:00", "Maine", "Coastal Sea Adventure", 55.00, Category.SEA));
        Guide guide3 = new Guide("John", "Doe", "john@gmail.com", "11223344", 5);
        guide3.setTrip(trips3);

        // Guide 4
        List<Trip> trips4 = new ArrayList<>();
        trips4.add(new Trip("06:00", "12:00", "Washington", "Deep Forest Walk", 35.00, Category.FOREST));
        trips4.add(new Trip("15:00", "21:00", "California", "Golden Beach Sunset", 75.00, Category.BEACH));
        trips4.add(new Trip("10:00", "16:00", "Montana", "Snowy Mountain Views", 50.00, Category.SNOW));
        Guide guide4 = new Guide("Emma", "Watson", "emma@gmail.com", "55667788", 10);
        guide4.setTrip(trips4);


        Set<Guide> guides = new HashSet<>();
        guides.add(guide1);
        guides.add(guide2);
        guides.add(guide3);
        guides.add(guide4);

        return guides;
    }
}
