import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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

    @Test
    public void gutterGame() {
        int rolls = 20;
        int pins = 0;
        rollMany(rolls, pins);
        assertThat(game.score(), is(0));
    }

    private void rollMany(int rolls, int pins) {
        for(int i = 0; i < rolls; i++)
            game.roll(pins);
    }

    @Test
    public void allOnes() {
        rollMany(20, 1);
        assertThat(game.score(), is(20));
    }
}
