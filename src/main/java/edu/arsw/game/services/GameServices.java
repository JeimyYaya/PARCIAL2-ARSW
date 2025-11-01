package edu.arsw.game.services;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.arsw.game.model.Hall;
import edu.arsw.game.persistence.GamePersistence;
import edu.arsw.game.persistence.GamePersistenceException;


@Service
public class GameServices {

    @Autowired
    private GamePersistence gamePersistence;

    public void createHall(String hallName) throws GamePersistenceException {
        gamePersistence.createHall(hallName);
    }

    public Hall loadHall(String hallName) throws GamePersistenceException {
        return gamePersistence.loadHall(hallName);
    }

    public List<Hall> getAllHalls() throws GamePersistenceException {
        return gamePersistence.getAllHalls();
    }


}
