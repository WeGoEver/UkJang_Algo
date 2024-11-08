import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        //[3, 76, 24]	[3, 1, 2]

        int[] emergency = {3, 76, 24};

        System.out.print(Arrays.toString(solution.solution(emergency)));
    }

    private static class Solution {
        public int[] solution(int[] emergency) {

            HashMap<Integer, Integer> map = new HashMap<>();

            ArrayList<Integer> list = new ArrayList<>();

            for(int i = 0; i < emergency.length; i++){
                map.put(emergency[i] , i);
                list.add(emergency[i]);
            }

            System.out.println(map.toString());

            Collections.sort(list, Collections.reverseOrder());

            for(int i = 0; i < list.size(); i++){
                map.put(list.get(i) , i + 1);
            }

            int[] answer = new int[emergency.length];

            for (int i = 0; i < emergency.length; i++){

                answer[i] = map.get(emergency[i]);

            }
            
            return answer;
        }
    }

}
