import java.util.Stack;

public class Textbook_10진수2진수 {
    public static void main(String[] args) {

        int input = 12345;

        System.out.println(solution(input));

    }

    private static String solution(int input) {

        // Stack 선언
        Stack<Integer> stack = new Stack<>();

        int tmp = input;

        // 몫 0 나올때 까지 나머지 Stack에 Push
        while( tmp > 0){

            stack.push(tmp % 2);
           
            tmp = tmp / 2;

        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
