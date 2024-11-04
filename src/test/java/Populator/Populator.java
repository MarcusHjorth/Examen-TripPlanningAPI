package Populator;

import app.daos.impl.TripDAO;
import app.dtos.TripDTO;
import app.entities.Guide;
import app.entities.Trip;
import app.enums.Category;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class Populator {
    private static EntityManagerFactory emf;
    private static TripDAO dao;

    public Populator(EntityManagerFactory _emf, TripDAO dao_) {
        this.emf = _emf;
        this.dao = dao_;
    }


    public void populateDataBase() {
        Guide guide1 = Guide.builder()
                .firstname("Gary")
                .lastname("Goodman")
                .email("gary@gmail.com")
                .phone("12345678")
                .yearsOfExperience(12)
                .build();

        Guide guide2 = Guide.builder()
                .firstname("Alice")
                .lastname("Anderson")
                .email("alice@gmail.com")
                .phone("87654321")
                .yearsOfExperience(8)
                .build();

        Trip trip1 = Trip.builder()
                .starttime("12:00")
                .endtime("18:00")
                .startposition("Florida")
                .name("Jungle Trip")
                .price(50.00)
                .category(Category.FOREST)
                .build();

        Trip trip2 = Trip.builder()
                .starttime("10:00")
                .endtime("16:00")
                .startposition("California")
                .name("Mountain Trip")
                .price(60.00)
                .category(Category.SEA)
                .build();

        guide1.setTrip(List.of(trip1, trip2));
        guide2.setTrip(List.of(trip1, trip2));

        try {
            dao.create(new TripDTO(trip1));
            dao.create(new TripDTO(trip2));
            //dao.create(new GuideDTO(guide1));
            //dao.create(new GuideDTO(guide2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
