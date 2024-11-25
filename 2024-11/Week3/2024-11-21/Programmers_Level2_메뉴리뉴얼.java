import java.util.*;

public class Programmers_Level2_메뉴리뉴얼 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        //["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]	[2,3,4]
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};

        System.out.println(Arrays.toString(solution.solution(orders, course)));
    }

    private static class Solution {

        private static ArrayList<String> resultList = new ArrayList<>();

        public String[] solution(String[] orders, int[] course) {
            String[] answer = {};

            String input = "ABC";

            combinations(0, input.toCharArray(), "");

            for(String tmp : resultList){
                System.out.println(tmp);
            }

            return answer;
        }

        public static void combinations(int idx, char[] order, String result){
            if(result.length() > 0){
                resultList.add(result);
            }

            for(int i = idx ; i < order.length; i++){
                combinations(i + 1, order, result + order[i]);
            }

            
        }
    }
}
