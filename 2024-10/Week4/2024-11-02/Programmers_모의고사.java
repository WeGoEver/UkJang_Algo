import java.util.ArrayList;
import java.util.Arrays;

public class Programmers_모의고사 {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] answers = { 1,3,2,4,2 };

        System.out.println(Arrays.toString(solution.solution(answers)));
    }

    // Solution 클래스를 정적(static)으로 변경
    private static class Solution {
        public int[] solution(int[] answers) {

            // 수포자들의 답안
            int[] first = { 1, 2, 3, 4, 5 };
            int[] second = { 2, 1, 2, 3, 2, 4, 2, 5 };
            int[] third = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

            // 정답 개수 배열
            int[] corrected = new int[3];

            // 체점
            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == first[i % first.length]) {
                    corrected[0]++;
                }
                if (answers[i] == second[i % second.length]) {
                    corrected[1]++;
                }
                if (answers[i] == third[i % third.length]) {
                    corrected[2]++;
                }
            }

            // corrected에서 max 값 찾기
            int max = 0;

            for (int tmp : corrected) {
                if (max <= tmp) {
                    max = tmp;
                }
            }

            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < corrected.length; i++) {

                if (corrected[i] == max) {

                    list.add(i + 1);
                }

            }

            int[] winner = new int[list.size()];

            for (int i = 0; i < winner.length; i++) {
                winner[i] = list.get(i);
            }

            return winner;
        }
    }
}
