package game.snakeandladder.demo;

import game.snakeandladder.demo.service.SnakesAndLaddersImpl;
import game.snakeandladder.demo.service.Utils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SnakeAndLadderApplicationTests extends Base {

    private static String TEST_JSON = "[{\"name\":\"Name1\",\"position\":1,\"doRollOfDie\":true,\"false\":\"No\"},{\"name\":\"Name2\",\"position\":1,\"doRollOfDie\":false,\"false\":\"No\"}]";
    private static String BASE_URI = "http://localhost:8080";

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
        doReturn(setupTestPlayers()).when(snakesAndLadders).games(any());

        mockMvc.perform(put(BASE_URI + "/games").contentType(MediaType.APPLICATION_JSON)
                .content(TEST_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].name", is(NAME_1)))
                .andExpect(jsonPath("$.[1].name", is(NAME_2)))
                .andExpect(jsonPath("$.[1].position", is(1)));
    }
}
