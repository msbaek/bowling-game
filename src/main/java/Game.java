public class Game {
    private int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public Integer score() {
        int score = 0;
        int firstFrame = 0;
        for(int frame = 0; frame < 10; frame++) {
            if(rolls[firstFrame] == 10) { // strike
                score += 10 + rolls[firstFrame + 1] + rolls[firstFrame + 2];
                firstFrame += 1;
            }
            else if(isSpare(firstFrame)) {
                score += 10 + rolls[firstFrame + 2];
                firstFrame += 2;
            }
            else {
                score += rolls[firstFrame] + rolls[firstFrame + 1];
                firstFrame += 2;
            }
        }
        return score;
    }

    private boolean isSpare(int firstFrame) {
        return rolls[firstFrame] + rolls[firstFrame + 1] == 10;
    }
}
