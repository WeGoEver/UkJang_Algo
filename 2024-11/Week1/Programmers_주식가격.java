import java.util.ArrayDeque;
import java.util.Arrays;

public class Programmers_주식가격{
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] prices = {1,2,3,2,3};

        System.out.println(Arrays.toString(solution.solution(prices)));
    }

    private static class Solution{
        public int[] solution(int[] prices) {
            // N^2 시간 복잡도
            int[] answer = new int[prices.length];

            for(int i = 0 ; i < prices.length - 1; i++){

                int count = 1;

                for(int j = i+1 ; j < prices.length - 1; j++){
                    if(prices[i] > prices[j]){
                        break;
                    }
                    count++;
                }
                answer[i] = count;
            }
            return answer;
        }
    }
}
