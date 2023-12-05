public class L7_T1_MaxSquare {
    private static int[][] matrix;
    private static int[][] memo;
    private static int rows;
    private static int cols;
    private static int max_so_far_for_recursion = -1;

    public static int find_max_area_recurse_entry(int[][] mat) {
        matrix = mat;
        rows = matrix.length;
        cols = matrix[0].length;
        memo = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                memo[i][j] = -1;
            }
        }
        q1_1_find_max_area_recurse(0, 0);
        return max_so_far_for_recursion * max_so_far_for_recursion;
    }

    private static int q1_1_find_max_area_recurse(int r, int c) {
        if (r == rows || c == cols)
            return 0;

        if (memo[r][c] != -1) {
            return memo[r][c];
        }

        int right = q1_1_find_max_area_recurse(r, c + 1);
        int down = q1_1_find_max_area_recurse(r + 1, c);
        int diagonal = q1_1_find_max_area_recurse(r + 1, c + 1);

        int size = 0;
        if (matrix[r][c] == 1) {

            size = 1 + Math.min(Math.min(right, down), diagonal);
        }

        memo[r][c] = size;
        max_so_far_for_recursion = size > max_so_far_for_recursion ? size : max_so_far_for_recursion;

        return size;
    }

    public void q1_2_maximum_size_square_sub_matrix(int[][] data) {
        int m = data.length;
        int n = data[0].length;

        int[][] sub = new int[m + 1][n + 1];

        int maxLength = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (data[i - 1][j - 1] == 1) {
                    sub[i][j] = Math.min(Math.min(sub[i - 1][j], sub[i][j - 1]), sub[i - 1][j - 1]) + 1;
                    maxLength = Math.max(maxLength, sub[i][j]);
                } else {
                    sub[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(sub[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Q1 Maximum Size Square Sub-Matrix : " + maxLength);
    }
}