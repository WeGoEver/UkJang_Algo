import java.util.Arrays;
import java.util.ArrayList;

public class Programmers_두개수뽑아서더하기_v1 {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] arr = {2,1,3,4,1};

        System.out.print(Arrays.toString(solution.solution(arr)));
    }
}

class Solution {
    public int[] solution(int[] arr){
        
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> notDuplicatedList = new ArrayList<>();
    
        // 서로 다른 인덱스 두 개 뽑아서 ArrayList에 추가
        for(int i = 0; i < arr.length; i++ ){
            for(int j = i + 1; j < arr.length; j++){
                list.add(arr[i] + arr[j]);
            }
        }

        // 중복 제거
        for(int item: list){
            if(!notDuplicatedList.contains(item)){
                notDuplicatedList.add(item);
            }
        }
        
        int[] result = new int[notDuplicatedList.size()];

        // ArrayList to Array
        for(int i = 0; i < notDuplicatedList.size(); i++){
            result[i] = notDuplicatedList.get(i);
        }

        // 오름차순으로 정렬
        Arrays.sort(result);

        return result;
    }
}
