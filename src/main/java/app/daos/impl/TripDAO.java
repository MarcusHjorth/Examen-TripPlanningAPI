package app.daos.impl;

import app.config.HibernateConfig;
import app.config.Populate;
import app.daos.IDAO;
import app.daos.ITripGuideDAO;
import app.dtos.TripDTO;
import app.entities.Trip;
import app.enums.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Set;

public class TripDAO implements IDAO<TripDTO, Integer>, ITripGuideDAO {

    private static TripDAO instance;
    private static EntityManagerFactory emf;

    public static TripDAO getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new TripDAO();
        }
        return instance;
    }

    @Override
    public List<TripDTO> readAll() {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<TripDTO> query = em.createQuery("SELECT new app.dtos.TripDTO(t) FROM Trip t", TripDTO.class);
            return query.getResultList();
        }
    }

    @Override
    public TripDTO read(Integer id) {
        try(EntityManager em = emf.createEntityManager()){
            Trip trip = em.find(Trip.class, id);
            return new TripDTO(trip);
        }
    }

    @Override
    public TripDTO create(TripDTO tripDTO) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Trip trip = new Trip(tripDTO);

            em.persist(trip);
            em.getTransaction().commit();
            return tripDTO;
            //Catch exceptions
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public TripDTO update(Integer integer, TripDTO tripDTO) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();

            Trip trip = em.find(Trip.class, integer);

            if (tripDTO.getStarttime() != null) {
                trip.setStarttime(tripDTO.getStartposition());
            }
            if (tripDTO.getEndtime() != null) {
                trip.setEndtime(tripDTO.getEndtime());
            }
            if (tripDTO.getStartposition() != null) {
                trip.setStartposition(tripDTO.getStartposition());
            }
            if (tripDTO.getName() != null) {
                trip.setName(tripDTO.getName());
            }
            if (tripDTO.getPrice() != null) {
                trip.setPrice(tripDTO.getPrice());
            }
            if (tripDTO.getCategory() != null) {
                trip.setCategory(tripDTO.getCategory());
            }

            em.getTransaction().commit();
            return tripDTO;
        }
    }

    @Override
    public TripDTO delete(Integer integer) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Trip trip = em.find(Trip.class, integer);
            em.remove(trip);
            em.getTransaction().commit();
            return new TripDTO(trip);
        }
    }




    @Override
    public void addGuideToTrip(int tripId, int guideId) {

       /*
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Trip trip = em.find(Trip.class, tripId);
            Doctor guide = em.find(Doctor.class, guideId);
            trip.addGuide(guide);
            em.getTransaction().commit();
        }

        */
    }

    @Override
    public Set<TripDTO> getTripsByGuide(int guideId) {
        return Set.of();
    }

}
