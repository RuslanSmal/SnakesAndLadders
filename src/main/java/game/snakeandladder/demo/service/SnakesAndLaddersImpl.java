package game.snakeandladder.demo.service;


import game.snakeandladder.demo.models.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SnakesAndLaddersImpl implements SnakesAndLadders {

    private Utils utils;

    private static String NAME_1 = "Name1";
    private static String NAME_2 = "Name2";

    public SnakesAndLaddersImpl(Utils utils) {
        this.utils = utils;
    }

    public Utils getUtils() {
        return utils;
    }

    @Override
    public List<Player> gameStart() {
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

    @Override
    public List<Player> games(List<Player> players) {
        int generatedPosition = getUtils().getGeneratedPosition();
        for (Player p : players) {
            if (p.isDoRollOfDie()) {
                if (getUtils().checkPositionNumber(p, generatedPosition))
                    p.setPosition(p.getPosition() + generatedPosition);
                p.setDoRollOfDie(false);
                if (p.getPosition() == 100) {
                    p.setWinner(true);
                    break;
                }
            } else {
                p.setDoRollOfDie(true);
            }
        }
        return players;
    }

}

