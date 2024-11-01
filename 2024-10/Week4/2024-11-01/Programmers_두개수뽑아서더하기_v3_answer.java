import java.util.ArrayList;
import java.util.Arrays;

public class Programmers_두개수뽑아서더하기_v3_answer {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] arr = {2,1,3,4,1};

        System.out.print(Arrays.toString(solution.solution(arr)));
    }

    private static class Solution {
        public int[] solution(int[] arr){

            ArrayList<Integer> list = new ArrayList<>();
            //ArrayList<Integer> notDuplicatedList = new ArrayList<>();

            // 서로 다른 인덱스 두 개 뽑아서 ArrayList에 추가
            for(int i = 0; i < arr.length; i++ ){
                for(int j = i + 1; j < arr.length; j++){

                    int sum = arr[i] + arr[j];

                    if(!list.contains(sum)){
                        list.add(sum);
                    }

                }
            }


            int[] result = new int[list.size()];

            // ArrayList to Array
            for(int i = 0; i < list.size(); i++){
                result[i] = list.get(i);
            }

            // 오름차순으로 정렬
            Arrays.sort(result);

            return result;
        }
    }
}

