import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Puzzle8 {
    static int size = 3;
    int[] sequence;
    ArrayList<Puzzle8State> explored;
    Stack<Puzzle8State> dfs;
    // HashMap<Integer, Tile> tileMap;

    public Puzzle8(int[] seq) {
        sequence = new int[size * size];
        int i = 0;
        for (int j = 0; j < seq.length; j += 3) {
            sequence[i++] = seq[j];
        }
    }

    public void displayBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sequence.length; i++) {
            if (i != 0 && i % 3 == 0) {
                sb.append("\n");
            }
            sb.append((sequence[i] == 9) ? " " : sequence[i]);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }

    public void generateNextMove() {
        explored = new ArrayList<>();
        int blankPos = 0;
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] == 9) {
                blankPos = i;
                break;
            }
        }
        if (blankPos + 3 < size * size) {// south
            int[] tmpArr = sequence.clone();
            tmpArr[blankPos + 3] = sequence[blankPos];
            tmpArr[blankPos] = sequence[blankPos + 3];
            Puzzle8State p8s = new Puzzle8State(tmpArr);
            System.out.println("pushing south " + p8s);
            explored.add(p8s);
        }
        if (blankPos - 3 > -1) {// north
            int[] tmpArr = sequence.clone();
            tmpArr[blankPos - 3] = sequence[blankPos];
            tmpArr[blankPos] = sequence[blankPos - 3];
            Puzzle8State p8s = new Puzzle8State(tmpArr);
            System.out.println("pushing north " + p8s);
            explored.add(p8s);
        }
        if (blankPos % 3 < 2) {// east
            int[] tmpArr = sequence.clone();
            tmpArr[blankPos + 1] = sequence[blankPos];
            tmpArr[blankPos] = sequence[blankPos + 1];
            Puzzle8State p8s = new Puzzle8State(tmpArr);
            System.out.println("pushing east " + p8s);
            explored.add(p8s);
        }
        if (blankPos % 3 > 0) {// west
            int[] tmpArr = sequence.clone();
            tmpArr[blankPos - 1] = sequence[blankPos];
            tmpArr[blankPos] = sequence[blankPos - 1];
            Puzzle8State p8s = new Puzzle8State(tmpArr);
            System.out.println("pushing west " + p8s);
            explored.add(p8s);
        }
    }

    public void nextMoveWithStack() {
        explored = new ArrayList<>();
        dfs = new Stack<>();
        Puzzle8State p8s = new Puzzle8State(sequence.clone());
        if (isGoal(p8s.sequence)) {
            System.out.println("found goal " + Arrays.toString(p8s.sequence));
            return;
        }
        dfs.push(p8s);
        explored.add(p8s);
        while (!dfs.isEmpty()) {
            Puzzle8State p = dfs.pop();
            System.out.println(
                    Arrays.toString(p.sequence) + " stack size: " + dfs.size() + " explored size " + explored.size());
            int blankPos = 0;
            for (int i = 0; i < p.sequence.length; i++) {
                if (p.sequence[i] == 9) {
                    blankPos = i;
                    break;
                }
            }
            if (blankPos + 3 < size * size) {// south
                int[] tmpArr = p.sequence.clone();
                tmpArr[blankPos + 3] = p.sequence[blankPos];
                tmpArr[blankPos] = p.sequence[blankPos + 3];
                Puzzle8State p8 = new Puzzle8State(tmpArr);
                if (isGoal(p8.sequence)) {
                    System.out.println("found goal " + Arrays.toString(p8.sequence));
                    return;
                }
                if (!explored.contains(p8)) {
                    // System.out.println("south");
                    dfs.push(p8);
                    explored.add(p8);
                }
            }
            if (blankPos - 3 > -1) {// north
                int[] tmpArr = p.sequence.clone();
                tmpArr[blankPos - 3] = p.sequence[blankPos];
                tmpArr[blankPos] = p.sequence[blankPos - 3];
                Puzzle8State p8 = new Puzzle8State(tmpArr);
                if (isGoal(p8.sequence)) {
                    System.out.println("found goal " + Arrays.toString(p8.sequence));
                    return;
                }
                if (!explored.contains(p8)) {
                    // System.out.println("north");
                    dfs.push(p8);
                    explored.add(p8);
                }
            }
            if (blankPos % 3 < 2) {// east
                int[] tmpArr = p.sequence.clone();
                tmpArr[blankPos + 1] = p.sequence[blankPos];
                tmpArr[blankPos] = p.sequence[blankPos + 1];
                Puzzle8State p8 = new Puzzle8State(tmpArr);
                if (isGoal(p8.sequence)) {
                    System.out.println("found goal " + Arrays.toString(p8.sequence));
                    return;
                }
                if (!explored.contains(p8)) {
                    // System.out.println("east");
                    dfs.push(p8);
                    explored.add(p8);
                }
            }
            if (blankPos % 3 > 0) {// west
                int[] tmpArr = p.sequence.clone();
                tmpArr[blankPos - 1] = p.sequence[blankPos];
                tmpArr[blankPos] = p.sequence[blankPos - 1];
                Puzzle8State p8 = new Puzzle8State(tmpArr);
                if (isGoal(p8.sequence)) {
                    System.out.println("found goal " + Arrays.toString(p8.sequence));
                    return;
                }
                if (!explored.contains(p8)) {
                    // System.out.println("west");
                    dfs.push(p8);
                    explored.add(p8);
                }
            }
            // System.out.println(dfs);
        }
    }

    private boolean isGoal(int[] seq) {
        if (Arrays.equals(seq, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 })) {
            System.out.println("from isGoal " + Arrays.toString(seq));
            return true;
        }
        return false;
    }
}
