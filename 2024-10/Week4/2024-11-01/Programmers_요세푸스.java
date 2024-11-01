import java.util.ArrayDeque;

class Programmers_요세푸스{
    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.print(solution.solution(5, 2));
    }

    private static class Solution {
        public int solution(int N, int K) {

            ArrayDeque<Integer> queue = new ArrayDeque<>();

            for (int i = 1; i <= N; i++) {
                queue.addLast(i);
            }

            System.out.println(queue);

            int index = 1;

            while (queue.size() > 1) {

                if (index % K != 0) {

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