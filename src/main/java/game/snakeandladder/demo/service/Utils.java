package game.snakeandladder.demo.service;

import game.snakeandladder.demo.models.Player;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Utils {

    public int getGeneratedPosition() {
        return new Random().nextInt(6) + 1;
    }

    public boolean checkPositionNumber(Player p, int position) {
        if (p.getPosition() + position <= 100) {
            return true;
        } else
            return false;
    }
}
