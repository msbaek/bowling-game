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
        for(int i = 0; i < 20; i++)
            game.roll(0);
        assertThat(game.score(), is(0));
    }

    @Test
    public void allOnes() {
        for(int i = 0; i < 20; i++)
            game.roll(1);
        assertThat(game.score(), is(20));
    }
}
