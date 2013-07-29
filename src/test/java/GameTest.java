import org.junit.Test;

public class GameTest {
    @Test
    public void canCreateGame() {
        Game g = new Game();
    }

    @Test
    public void canRoll() {
        Game g = new Game();
        g.roll(0);
    }
}
