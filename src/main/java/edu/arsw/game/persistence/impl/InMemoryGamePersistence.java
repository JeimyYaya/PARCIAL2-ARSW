package edu.arsw.game.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import edu.arsw.game.model.Hall;
import edu.arsw.game.persistence.GamePersistence;
import edu.arsw.game.persistence.GamePersistenceException;


@Repository
public class InMemoryGamePersistence implements GamePersistence {

    private List<Hall> halls;

    public InMemoryGamePersistence() {

        Hall hall1 = new Hall("Hall 1");
        Hall hall2 = new Hall("Hall 2");
        Hall hall3 = new Hall("Hall 3");
        halls = List.of(hall1, hall2, hall3);

    }
    @Override
    public void createHall(String name) throws GamePersistenceException {
        for (Hall hall : halls) {
            if (hall.getName().equals(name)) {
                throw new GamePersistenceException("El hall ya existe: " + name);
            }
        }
        Hall newHall = new Hall(name);
        halls.add(newHall);
    }

    @Override  
    public Hall loadHall(String name) throws GamePersistenceException {
        for (Hall hall : halls) {
            if (hall.getName().equals(name)) {
                return hall;
            }
        }
        throw new GamePersistenceException("Hall no encontrado: " + name);
    }

    @Override
    public List<Hall> getAllHalls() throws GamePersistenceException {
        return halls;
    }

    

}
