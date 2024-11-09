
public class Programmers_개미군단 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        int hp = 23;

        System.out.println(solution.solution(hp));

    }

    private static class Solution {

        public int solution(int hp) {

            int answer = 0;

            if (hp >= 5) {
                answer = answer + hp / 5;
                hp = hp % 5;
            }

            if (hp >= 3) {
                answer = answer + hp / 3;
                hp = hp % 3;
            }

            if (hp >= 1) {
                answer = answer + hp / 1;
                //hp = hp % 5;
            }

            return answer;
        }
    }
}
