package game.snakeandladder.demo.service;


import game.snakeandladder.demo.models.Player;

import java.util.List;

public interface SnakesAndLadders {
    List<Player> gameStart();

    List<Player> games(List<Player> players);
}