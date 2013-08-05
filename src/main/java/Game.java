public class Game {
    private int[] rolls = new int[24];
    private int rollIndex = 0;

    public void roll(int pins) {
        rolls[rollIndex++] = pins;
        if (pins==10) rolls[rollIndex++] = 0;
    }

    public Integer getScore() {
        int score = 0;
        for (int frame=0; frame<10; frame++) {
            score += getFrameScore(frame);
            if (getFrameScore(frame)==10) score += getNextFrameFirstRoll(frame);
            if (getFirstRoll(frame)==10) score += getNextNextRoll(frame);
        }
        return score;
    }

    private int getFirstRoll(int frame) {
        return rolls[frame*2];
    }

    private int getSecondRoll(int frame) {
        return rolls[frame*2+1];
    }

    private int getNextFrameFirstRoll(int frame) {
        return getFirstRoll(frame + 1);
    }

    private int getNextNextRoll(int frame) {
        if (getNextFrameFirstRoll(frame)==10) return getFirstRoll(frame + 2);
        return getSecondRoll(frame+1);
    }

    private int getFrameScore(int frame) {
        return getFirstRoll(frame) + getSecondRoll(frame);
    }
}
