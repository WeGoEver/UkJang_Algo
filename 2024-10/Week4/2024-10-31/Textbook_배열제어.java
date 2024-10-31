import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class Textbook_배열제어{
    public static void main(String[] args){

        int[] input = {4,2,2,1,3,4};

        System.out.println(Arrays.toString(solution(input)));
    }

    private static int[] solution(int[] arr){

        // array to ArrayList
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            list.add(arr[i]);
        }

        // 중복 값 제거 후 새로운 list에 추가
        ArrayList<Integer> newList = new ArrayList<>();

        for(int i = 0; i < list.size(); i++){

            int tmp = list.get(i);

            if(!newList.contains(tmp)){
                newList.add(i);
            }
        }

        //Integer[] result = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);
        
        // 내림차순 정렬
        Collections.sort(newList, Collections.reverseOrder());
        

        // ArrayList to array
        int[] answer = new int[newList.size()];

        for(int i = 0; i < newList.size(); i++){
            answer[i] = newList.get(i);
        }

        return answer;
    }
}

