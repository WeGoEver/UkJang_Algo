
public class Programmers_Level2_예상대진표 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.solution(8, 4, 7));

    }

    private static class Solution {

        public int solution(int n, int a, int b) {

            int answer = 1;

            while (true) {

                // a와 b가 경기하기 위해서는 두 수 중 큰 수가 2의 배수이고 큰 수와 작은 수의 차이가 1이여야함
                // 서로 경기하기 전까지는 항상 이기기 때문에 다음 라운드에서는 2의 2/1 승의 수로 배정을 받음
                if (((a > b) && (a % 2 == 0) && (a - b) == 1) || ((b > a) && (b % 2 == 0) && (b - a) == 1)) {
                    break;
                }

                if (a % 2 == 1) {
                    a = (a + 1) / 2;
                } else {
                    a = a / 2;
                }

                if (b % 2 == 1) {
                    b = (b + 1) / 2;
                } else {
                    b = b / 2;
                }

                // 조건에 부합하지 않으면 1 라운드 증가
                answer++;

            }

            return answer;

        }
    }
}
