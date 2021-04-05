package game.snakeandladder.demo.controller;

import game.snakeandladder.demo.models.Player;
import game.snakeandladder.demo.service.SnakesAndLaddersImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class SnakeAndLaddersController {

    private SnakesAndLaddersImpl snakesAndLaddersImpl;

    public SnakeAndLaddersController(SnakesAndLaddersImpl snakesAndLaddersImpl) {
        this.snakesAndLaddersImpl = snakesAndLaddersImpl;
    }

    @PostMapping(value = "/starts", produces = "application/json")
    public ResponseEntity<List<Player>> initGame() {
        return new ResponseEntity(snakesAndLaddersImpl.gameStart(), HttpStatus.CREATED);
    }

    @PutMapping(value = "/games", produces = "application/json")
    public ResponseEntity<List<Player>> startGame(@RequestBody @NonNull List<Player> players) {
        return new ResponseEntity(snakesAndLaddersImpl.games(players), HttpStatus.OK);
    }

}
