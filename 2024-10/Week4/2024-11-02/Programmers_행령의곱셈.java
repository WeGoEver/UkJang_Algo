import java.util.HashSet;

public class Programmers_행령의곱셈 {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[][] arr1 = { { 1, 4 }, { 3, 2 }, { 4, 1 } };
        int[][] arr2 = { { 3, 3 }, { 3, 3 } };

        // System.out.println(arr1.length);
        // System.out.println(arr1[0].length);

        int [][] answer = solution.solution(arr1,arr2);

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                System.out.print(answer[i][j] + ",");
            }
            System.out.println();
        }

    }

    // Solution 클래스를 정적(static)으로 변경
    private static class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {

            int r1 = arr1.length;
            int c1 = arr1[0].length;
            int r2 = arr2.length;
            int c2 = arr2[0].length;

            int[][] answer = new int[r1][c2];

            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c2; j++) {

                    int tmp = 0;

                    for(int t = 0; t < c1; t++){
                        tmp = tmp + arr1[i][t] * arr2[t][j];
                    }

                    answer[i][j] = tmp;

                }
            }

            return answer;
        }
    }
}
