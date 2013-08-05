import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class GameTest {

    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void canRoll() {
        game.roll(0);
    }

    private void rollMany(int rolls, int pins) {
        for (int i=0; i<rolls; i++) game.roll(pins);
    }

    @Test
    public void gutterGame() {
        rollMany(20, 0);
        assertThat(game.getScore(), is(0));
    }

    @Test
    public void ollOnes() {
        rollMany(20, 1);
        assertThat(game.getScore(), is(20));
    }

    @Test
    public void oneSpare() {
        game.roll(5);
        game.roll(5); // spare
        game.roll(3);
        rollMany(17, 0);
        assertThat(game.getScore(), is(16));
    }

    @Test
    public void oneStrike() {
        game.roll(10); // strike
        game.roll(5);
        game.roll(3);
        rollMany(16, 0);
        assertThat(game.getScore(), is(26));
    }

    @Test
    public void perfectGame() {
        rollMany(10, 10);
        game.roll(10);
        game.roll(10);
        assertThat(game.getScore(), is(300));
    }

    @Test
    public void lackPerfectGame() {
        rollMany(10, 10);
        game.roll(10);
        game.roll(9);
        assertThat(game.getScore(), is(299));
    }
}
