package game.snakeandladder.demo;

import game.snakeandladder.demo.models.Player;
import game.snakeandladder.demo.service.SnakesAndLaddersImpl;
import game.snakeandladder.demo.service.Utils;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

public abstract class Base {
    public static final String NAME_1 = "Name1";
    public static final String NAME_2 = "Name2";
    @MockBean
    protected SnakesAndLaddersImpl snakesAndLadders;

    @MockBean
    protected Utils utils;

    protected List<Player> setupTestPlayers() {
        List<Player> players = new ArrayList<>();

        Player player1 = new Player();
        player1.setName(NAME_1);
        player1.setPosition(1);
        player1.setDoRollOfDie(true);
        player1.setWinner(false);

        Player player2 = new Player();
        player2.setName(NAME_2);
        player2.setPosition(1);
        player2.setDoRollOfDie(false);
        player2.setWinner(false);

        players.add(player1);
        players.add(player2);
        return players;
    }
}
