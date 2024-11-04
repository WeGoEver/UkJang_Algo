import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Programmers_기능개발{
    public static void main(String[] args) {

        Solution solution = new Solution();

        // [93, 30, 55] [1, 30, 5]

        int[] progresses = { 95, 90, 99, 99, 80, 99 };
        int[] speeds = { 1, 1, 1, 1, 1, 1 };

        System.out.println(Arrays.toString(solution.solution(progresses, speeds)));

    }

    // Solution 클래스를 정적(static)으로 변경
    private static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {

            // 작업의 개수
            int n = progresses.length;

            // 기능 개발까지 걸리는 일 수 que에 저장
            ArrayDeque<Integer> que = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
//                int remain = 100 - progresses[i];
//
//                // 나머지가 없는 경우 몫 추가
//                if (remain % speeds[i] == 0) {
//                    que.add(remain / speeds[i]);
//                }
//                // 나머지 있는 경우 몫 + 1 추가
//                else {
//                    que.add(remain / speeds[i] + 1);
//                }
                // Math.ceil을 사용하면 아래와 같이 작성 가능
                que.add((int)Math.ceil((100.0 - progresses[i]) / speeds[i]));
            }

//            System.out.println(que.toString());

            ArrayList<Integer> schedule = new ArrayList<>();

            while (!que.isEmpty()) {

                int day = 1;

                int tmp = que.pollFirst();

//                System.out.println(tmp);


                while ( !que.isEmpty() && tmp >= que.getFirst()) {
                    que.pollFirst();
                    day = day + 1;
                }

                schedule.add(day);
            }

//            int[] answer = new int[schedule.size()];
//
//            for (int i = 0; i < schedule.size(); i++) {
//                answer[i] = schedule.get(i);
//            }


            // ArrayList to Array
            // ArrayList.stream().mapToInt(Integer::intValue).toArray();
            int[] answer = schedule.stream().mapToInt(Integer::intValue).toArray();
            
            return answer;
        }
    }
}