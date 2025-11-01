package edu.arsw.game.controllers;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import edu.arsw.game.model.Hall;
import edu.arsw.game.services.GameServices;
import edu.arsw.game.persistence.GamePersistenceException;




@RestController
@RequestMapping("/api/game")
public class GameAPIController {
    private static final Logger logger = Logger.getLogger(GameAPIController.class.getName());

    @Autowired
    private GameServices gameServices;

    @GetMapping("/halls")
    public ResponseEntity<Iterable<Hall>> getAllHalls() {
        try {
            Iterable<Hall> halls = gameServices.getAllHalls();
            return new ResponseEntity<>(halls, HttpStatus.OK);
        } catch (GamePersistenceException e) {
            logger.severe("Error retrieving halls: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/hall/{hallName}") 
    public ResponseEntity<Hall> loadHall(@PathVariable String hallName) {
        try {
            Hall hall = gameServices.loadHall(hallName);
            return new ResponseEntity<>(hall, HttpStatus.OK);
        } catch (GamePersistenceException e) {
            logger.severe("Error retrieving hall: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/hall/{hallName}")
    public ResponseEntity<Void> createHall(@PathVariable String hallName) {
        try {
            gameServices.createHall(hallName);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (GamePersistenceException e) {
            logger.severe("Error creating hall: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

}
