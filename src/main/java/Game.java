public class Game {
    private Integer score = 0;

    public void roll(int pins) {
        score += pins;
    }

    public Integer score() {
        return score;
    }
}
