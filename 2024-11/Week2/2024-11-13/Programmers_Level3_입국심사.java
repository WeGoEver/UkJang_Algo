
import java.util.*;

public class Programmers_Level3_입국심사 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        // 6 [7, 10] 28

        int n = 6;
        int[] times = { 7, 10 };

        System.out.println(solution.solution(n, times));

    }

    private static class Solution {

        public long solution(int n, int[] times) {

            // 최대 값 time의 최대 값인 10^9 * 10^5
            // 최소 값 1
            long max = 100000000000000L;
            long min = 1L;

            long answer = 0;

            // 이진 탐색으로 입국 심사 최소 시간을 찾음.
            while (min < max) {

                long mid = (max + min) / 2;

                if (isPossible(mid, n, times)) {
                    // mid 시간이 가능하다는 것은 max 값을 줄여도 된다는 말
                    max = mid;

                } else {
                    // mid 시간이 불가능하다는 것은 시간이 더 필요하다는 말
                    // mid 시간도 불가능이기 때문에 + 1
                    min = mid + 1;

                }

            }

            return min;
        }

        public static boolean isPossible(long mid, int n, int[] times) {

            long available = 0;

            for (int i = 0; i < times.length; i++) {

                available = available + mid / times[i];

            }

            if (n <= available) {
                return true;
            } else {
                return false;
            }
        }

    }
}