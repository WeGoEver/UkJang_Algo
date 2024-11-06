import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Programmers_짝지어제거하기 {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int N = 5;
        int[] stage = { 2, 1, 2, 6, 2, 4, 3, 3 };

        System.out.println(Arrays.toString(solution.solution(N, stage)));

    }

    // Solution 클래스를 정적(static)으로 변경
    private static class Solution {
        public int[] solution(int N, int[] stages) {

            // 스테이지 통과한 유저의 수 배열
            int[] pass = new int[N + 1];

            // 스테이지에 머무르고 있는 유저의 수 배열
            int[] stay = new int[N + 1];

            for (int stage : stages) {
                for (int i = 0; i < stage; i++) {
                    pass[i]++;
                }

                stay[stage - 1]++;
            }

            // 실패율 배열
            double[] fail = new double[N];

            for (int i = 0; i < N; i++) {
                // 0으로 나눌 시 에러 방지
                if (pass[i] != 0) {
                    fail[i] = (double) stay[i] / (double) pass[i];
                } else {
                    fail[i] = 0;
                }

                // System.out.println(fail[i]);
            }

            // HashMap에 실패율 추가
            HashMap<Double, ArrayList<Integer>> map = new HashMap<>();

            for (int i = 0; i < N; i++) {
                if (map.containsKey(fail[i])) {
                    map.get(fail[i]).add(i + 1);
                } else {

                    ArrayList<Integer> tmp = new ArrayList<>();

                    tmp.add(i + 1);

                    map.put(fail[i], tmp);
                }
            }

            // System.out.println("map" + map.toString());

            // double 배열을 Double 배열로 변환
            Double[] doubleArr = Arrays.stream(fail).boxed().toArray(Double[]::new);

            // Double 배열을 내림차순으로 정렬
            Arrays.sort(doubleArr, Collections.reverseOrder());

            // System.out.println("doubleArr" + Arrays.toString(doubleArr));

            ArrayList<Integer> answer = new ArrayList<>();

            for (Double key : doubleArr) {

                ArrayList<Integer> tmp = map.get(key);

                // 중복되는 값을 없애기 위해 사용한 배열은 0 값으로 초기화
                ArrayList<Integer> none = new ArrayList<>();

                map.put(key,none);

                // 중복되는 값이 있는 경우 오름차순으로 정렬해서 추가
                Collections.sort(tmp);

                answer.addAll(tmp);
            }

            int[] answerArr = answer.stream().mapToInt(Integer::intValue).toArray();

            return answerArr;
        }
    }
}
