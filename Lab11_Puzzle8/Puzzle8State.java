import java.util.Arrays;

public class Puzzle8State {
    int score;
    int[] sequence;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Puzzle8State other = (Puzzle8State) obj;
        if (!Arrays.equals(sequence, other.sequence))
            return false;
        return true;
    }

    public Puzzle8State(int[] seq) {
        sequence = seq;
        setScore();
    }

    private void setScore() {
        for (int j = 0; j < sequence.length; j++) {
            if (sequence[j] != 9) {
                int sRow = j / 3;
                int sCol = j % 3;
                int gRow = (sequence[j] - 1) / 3;
                int gCol = (sequence[j] - 1) % 3;
                score += Math.abs(gRow - sRow) + Math.abs(gCol - sCol);
            }
        }

    }

    @Override
    public String toString() {
        return String.valueOf(score + " " + Arrays.toString(sequence));
    }

}
