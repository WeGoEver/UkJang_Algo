import java.util.Arrays;

public class Textbook_배열정렬{
    public static void main(String[] args){

        int[] input = {6,1,7};

        System.out.println(Arrays.toString(solution(input)));
    }

    private static int[] solution(int[] arr){

        // arr 값은 참조 값으로 넘어오기 때문에 원본 배열을 수정하지 않으려면 clone 메서드 사용
        int[] clone = arr.clone();
        Arrays.sort(clone);
        return clone;
    }
}
