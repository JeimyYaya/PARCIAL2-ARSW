package edu.arsw.game.persistence;

import java.util.List;

import edu.arsw.game.model.Hall;

public interface GamePersistence {

    public Hall loadHall(String name) throws GamePersistenceException;
   
    public void createHall(String name) throws GamePersistenceException;

    public List<Hall> getAllHalls() throws GamePersistenceException;
        

}
