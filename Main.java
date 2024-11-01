import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int N = 5;
        int K = 2;

        System.out.print(solution.solution(N, K));
    }

    private static class Solution {
        public int solution(int N, int K) {

            ArrayDeque<Integer> queue = new ArrayDeque();

            for (int i = 1; i <= N; i++) {
                queue.addLast(i);
            }

            int index = 1;

            while (queue.size() > 1) {

                if (index % K != 2) {

                    int tmp = queue.pollFirst();
                    queue.addLast(tmp);

                } else {

                    queue.pollFirst();
                }

                index++;

            }

            return queue.peekFirst();
        }
    }

}
