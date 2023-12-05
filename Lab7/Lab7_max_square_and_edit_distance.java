import java.util.Arrays;

public class Lab7_max_square_and_edit_distance {
    public static void main(String[] args) {
        L7_T1_MaxSquare maxSquare = new L7_T1_MaxSquare();

        int[][] data = {
                { 0, 1, 1, 0, 1 },
                { 1, 1, 0, 1, 0 },
                { 0, 1, 1, 1, 0 },
                { 1, 1, 1, 1, 0 },
                { 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0 }
        };

        maxSquare.q1_2_maximum_size_square_sub_matrix(data);

        int editDistance = q2_string_edit_distance("abd", "acd");
        System.out.println("Q2 Edit Distance : " + editDistance);
    }

    private static int q2_string_edit_distance(String str1, String str2) {
        int[][] cache = new int[str1.length() + 1][str2.length() + 1];
        for (int[] row : cache)
            Arrays.fill(row, Integer.MAX_VALUE);

        for (int r = 0; r < cache.length; r++) {
            cache[r][str2.length()] = str2.length() - r;
        }

        for (int c = 0; c < cache[0].length; c++) {
            cache[str1.length()][c] = str1.length() - c;
        }

        for (int i = str1.length() - 1; i >= 0; i--) {
            for (int j = str2.length() - 1; j >= 0; j--) {
                int insert = cache[i][j + 1] + 1;
                int delete = cache[i + 1][j] + 1;
                int replace = cache[i + 1][j + 1] + (str1.charAt(i) == str2.charAt(j) ? 0 : 1);

                cache[i][j] = Math.min(Math.min(insert, delete), replace);
            }
        }

        return cache[0][0];
    }
}
