
import java.util.HashMap;

public class Programmers_할인행사{

    public static void main(String[] args) {

        Solution solution = new Solution();

        // ["banana", "apple", "rice", "pork", "pot"]	
        // [3, 2, 2, 2, 1]	
        // ["chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"]

        // ["apple"]	[10]	["banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"]

        String[] want = {"apple"};
        int[] number = {10};
        String[] discount = {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"};

        System.out.println(solution.solution(want, number, discount));

    }

    private static class Solution {

        public int solution(String[] want, int[] number, String[] discount) {

            // 원하는 제품을 할인 받아서 살 수 있는 날
            int answer = 0;
            // 사야하는 제품의 합
            int wantSum = 0;

            // Key: want 목록 - Value: want 개수
            HashMap<String, Integer> wantMap = new HashMap<>();

            // 사야하는 물품 wantMap에 저장
            for(int i = 0 ; i < want.length; i++){

                wantMap.put(want[i], number[i]);
                wantSum = wantSum + number[i];

            }

            HashMap<String, Integer> discountMap = new HashMap<>();

            // 10일동안 할인하는 제품 Map저장
            for(int i = 0; i <= discount.length - wantSum; i++){

                // 할인이 끝나는 날 총 10일
                int end = i + 10;

                // outofindex 방지
                if(end > discount.length){
                    end = discount.length - 1;
                }

                for(int j = i; j < end; j++){

                    // Key - 물품 이 있으면 기존 값에 +1, 없으면 1
                    discountMap.put(discount[j],discountMap.getOrDefault(discount[j], 0) + 1);

                }

                // System.out.println(discountMap.toString());

                int wantCategory = wantMap.keySet().size();
                int count = 0;

                for(String name : wantMap.keySet()){

                    if(wantMap.get(name) == discountMap.get(name)){
                        count++;
                    }
                }

                if(count == wantCategory){
                    answer++;
                }

                discountMap = new HashMap<>();

            }
            
            return answer;
        }
    }
}
