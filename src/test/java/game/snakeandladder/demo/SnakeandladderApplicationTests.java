package game.snakeandladder.demo;

import game.snakeandladder.demo.models.Player;
import game.snakeandladder.demo.service.SnakesAndLaddersImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SnakeAndLadderApplicationTests {


    private static String TEST_JSON = "[{\"name\":\"Name1\",\"position\":1,\"doRollOfDie\":true,\"false\":\"No\"},{\"name\":\"Name2\",\"position\":1,\"doRollOfDie\":false,\"false\":\"No\"}]";
    private static String BASE_URI = "http://localhost:8080";
    private static String NAME_1 = "Name1";
    private static String NAME_2 = "Name2";

    @MockBean
    private SnakesAndLaddersImpl snakesAndLadders;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Testing start the game (POST /starts)")
    void snakesAndLaddersStartGameTest() throws Exception {
        doReturn(setupTestPlayers()).when(snakesAndLadders).gameStart();

        mockMvc.perform(post(BASE_URI + "/starts").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.[0].name", is(NAME_1)))
                .andExpect(jsonPath("$.[0].winner", is(false)))
                .andExpect(jsonPath("$.[1].name", is(NAME_2)))
                .andExpect(jsonPath("$.[1].winner", is(false)));
    }

    @Test
    @DisplayName("Test game (PUT /games)")
    void snakesAndLaddersGameTest() throws Exception {
        doReturn(setupTestPlayers()).when(snakesAndLadders).games(ArgumentMatchers.any());

        mockMvc.perform(put(BASE_URI + "/games").contentType(MediaType.APPLICATION_JSON)
                .content(TEST_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].name", is(NAME_1)))
                .andExpect(jsonPath("$.[1].name", is(NAME_2)))
                .andExpect(jsonPath("$.[1].position", is(1)));
    }

    @Test
    @DisplayName("Test service methods")
    void testService() {
        doCallRealMethod().when(this.snakesAndLadders).games(ArgumentMatchers.any());
        List<Player> initList = this.snakesAndLadders.games(setupTestPlayers());

        assertNotEquals(initList.get(0).getPosition(), 1);
        assertEquals(initList.get(1).getPosition(), 1);
        assertEquals(initList.get(0).isDoRollOfDie(), false);
        assertEquals(initList.get(1).isDoRollOfDie(), true);
    }

    private List<Player> setupTestPlayers() {
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
