package edu.arsw.game.persistence;

public class GamePersistenceException extends Exception {
    public GamePersistenceException(String message) {
        super(message);
    }

    public GamePersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

}
