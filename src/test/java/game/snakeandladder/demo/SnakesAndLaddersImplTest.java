package game.snakeandladder.demo;

import game.snakeandladder.demo.models.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SnakesAndLaddersImplTest extends Base {

    @Test
    @DisplayName("Test service methods")
    void testService() {
        when(snakesAndLadders.games(anyList())).thenReturn(setupTestPlayers());
        List<Player> initList = snakesAndLadders.games(setupTestPlayers());

        assertEquals( 1,initList.get(0).getPosition());
        assertEquals(1, initList.get(1).getPosition());
        assertEquals(true, initList.get(0).isDoRollOfDie());
        assertEquals(false, initList.get(1).isDoRollOfDie());
    }

    @Test
    void testWinners() {
        when(utils.getGeneratedPosition()).thenReturn(99);
        when(utils.checkPositionNumber(any(Player.class), anyInt())).thenReturn(true);
        when(snakesAndLadders.getUtils()).thenReturn(utils);
        when(snakesAndLadders.gameStart()).thenReturn(setupTestPlayers());
        when(snakesAndLadders.games(anyList())).thenCallRealMethod();

        List<Player> playerList = snakesAndLadders.gameStart();
        List<Player> game = snakesAndLadders.games(playerList);

        System.out.println(game);
        assertEquals(true, game.get(0).isWinner());
        assertEquals(100, game.get(0).getPosition());
        assertEquals(false, game.get(1).isWinner());
    }
}
