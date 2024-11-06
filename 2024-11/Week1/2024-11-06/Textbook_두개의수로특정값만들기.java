
import java.util.HashMap;

public class Textbook_두개의수로특정값만들기 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] arr = {2,3,5,9};
        int target = 10;

        System.out.println(solution.solution(arr, target));

    }

    private static class Solution {

        public String solution(int[] arr, int target) {

            HashMap<Integer, Integer> map = new HashMap<>();

            for (int tmp : arr) {

                int value = target - tmp;

                map.put(tmp, value);

                // System.out.println("key: " + tmp + " value : " + value);
            }

            System.out.println(map.toString());

            for (int i = 0; i < arr.length; i++) {
                if (map.containsValue(arr[i]) && map.get(arr[i]) != arr[i]) {
                    return "true";
                }
            }

            return "false";
        }
    }
}
