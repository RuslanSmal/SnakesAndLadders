package game.snakeandladder.demo.controller;

import game.snakeandladder.demo.models.Players;
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

    public SnakeAndLaddersController(SnakesAndLaddersImpl snakesAndLaddersImpl){
        this.snakesAndLaddersImpl = snakesAndLaddersImpl;
    }

    @PostMapping()
    public ResponseEntity<List<Players>> initGame(){
        return new ResponseEntity(snakesAndLaddersImpl.snakesAndLaddersGameStart(),HttpStatus.CREATED);
    }
    @PutMapping()
    public ResponseEntity<List<Players>> startGame(@RequestBody  @NonNull  List<Players> players) {
        return new ResponseEntity(snakesAndLaddersImpl.snakeAndLaddersGames(players),HttpStatus.OK);
    }

}
