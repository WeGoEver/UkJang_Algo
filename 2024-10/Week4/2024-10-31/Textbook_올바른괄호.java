import java.util.Stack;

public class Textbook_올바른괄호 {
    public static void main(String[] args) {

        String input = ")()())";

        System.out.println(solution(input));
    }

    private static boolean solution(String input) {

        // String to Char[]
        char[] inputToChar = new char[input.length()];

        input.getChars(0, input.length(), inputToChar, 0);

        // Stack 선언
        Stack<Character> stack = new Stack<>();

        // Char [] 돌면서 올바른 괄호 유무 확인
        for (int i = 0; i < inputToChar.length; i++) {

            char tmp = inputToChar[i];

            if (tmp == '(') {
                stack.push('c');
            } else if (tmp == ')') {
                // Stack이 비어 있는데 ) 들어갈 시 false
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        // stack이 비어 있을 시 괄호가 순서에 맞게 짝을 이루므로 true
        // stack에 괄호가 남아있다면 짝을 이루지 않는 다는 것이므로 false
        return stack.isEmpty();
    }
}
