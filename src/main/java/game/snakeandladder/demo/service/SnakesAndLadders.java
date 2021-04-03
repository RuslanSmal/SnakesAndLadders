package game.snakeandladder.demo.service;


import game.snakeandladder.demo.models.Players;

import java.util.List;

public interface SnakesAndLadders {
    List<Players> snakesAndLaddersGameStart();
    List<Players> snakeAndLaddersGames(List<Players> players);
}
