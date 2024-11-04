package app.daos.impl;

import app.daos.IDAO;
import app.entities.Guide;
import jakarta.persistence.EntityManagerFactory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


public class GuideDAO implements IDAO<Guide, Integer> {

    private static GuideDAO instance;
    private static EntityManagerFactory emf;

    public static GuideDAO getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new GuideDAO();
        }
        return instance;
    }


    @Override
    public Guide create(Guide guide) {
        return null;
    }

    @Override
    public List<Guide> readAll() {
        return List.of();
    }

    @Override
    public Guide read(Integer integer) {
        return null;
    }

    @Override
    public Guide update(Integer integer, Guide guide) {
        return null;
    }

    @Override
    public Guide delete(Integer integer) {
        return null;
    }
}
