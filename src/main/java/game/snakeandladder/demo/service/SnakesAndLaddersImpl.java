package game.snakeandladder.demo.service;


import game.snakeandladder.demo.models.Players;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class SnakesAndLaddersImpl implements SnakesAndLadders {

    @Override
    public List<Players> snakesAndLaddersGameStart(){
        return initPlayers();
    }
    @Override
    public List<Players> snakeAndLaddersGames(List<Players> players){
        return doGame(players);
    }

    private List<Players> doGame(List<Players> players){
        Random random = new Random();
        int generatedPosition = random.nextInt(6)+1;

        for (Players p: players){
            if (p.isStatus() ) {

                if (checkPositionNumber(p, generatedPosition))
                    p.setPosition(p.getPosition() + generatedPosition);
                p.setStatus(false);
                if (p.getPosition() == 100){
                    p.setWinner("Yes");
                    break;
                }
            }
            else {
                p.setStatus(true);
            }
        }
        return players;
    }
    private boolean checkPositionNumber(Players p, int position) {
        if(p.getPosition() + position > 100){
            return false;
        } else
            return true;
    }

    private List<Players> initPlayers() {
        List<Players> players = new ArrayList<>();

        Players player1 = new Players();
        player1.setName("Name1");
        player1.setPosition(1);
        player1.setStatus(true);
        player1.setWinner("No");

        Players player2 = new Players();
        player2.setName("Name2");
        player2.setPosition(1);
        player2.setStatus(false);
        player2.setWinner("No");

        players.add(player1);
        players.add(player2);
        return  players;
    }
}

