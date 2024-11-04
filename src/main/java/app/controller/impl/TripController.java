package app.controller.impl;

import app.config.HibernateConfig;
import app.config.Populate;
import app.daos.impl.TripDAO;
import app.dtos.TripDTO;
import jakarta.persistence.EntityManagerFactory;

import io.javalin.http.Context;

import java.util.List;

public class TripController {

    private final TripDAO dao;

    public TripController() {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory("tripplanning");
        this.dao = TripDAO.getInstance(emf);
    }

    public void read(Context ctx){
        int id = ctx.pathParamAsClass("id", Integer.class).get();
        TripDTO tripDTO = dao.read(id);
        ctx.res().setStatus(200);
        ctx.json(tripDTO, TripDTO.class);
    }

    public void readAll(Context ctx){
        List<TripDTO> tripDTOS = dao.readAll();
        ctx.res().setStatus(200);
        ctx.json(tripDTOS, TripDTO.class);
    }

    public void create(Context ctx){
        TripDTO tripDTO = ctx.bodyAsClass(TripDTO.class);
        TripDTO createdTrip = dao.create(tripDTO);
        ctx.res().setStatus(201);
        ctx.json(createdTrip, TripDTO.class);
    }

    public void update(Context ctx){
        int id = ctx.pathParamAsClass("id", Integer.class).get();
        TripDTO tripDTO = ctx.bodyAsClass(TripDTO.class);
        TripDTO updatedTrip = dao.update(id, tripDTO);
        ctx.res().setStatus(200);
        ctx.json(updatedTrip, TripDTO.class);
    }

    public void delete(Context ctx){
        int id = ctx.pathParamAsClass("id", Integer.class).get();
        dao.delete(id);
        ctx.res().setStatus(204);
    }
}
