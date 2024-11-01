import java.util.Stack;

public class Programmers_괄호회전하기 {
    public static void main(String[] args) {

        Solution solution = new Solution();

        String input = "[({})]";

        System.out.println(solution.solution(input));
    }

    private static class Solution {
        public int solution(String input){

            String rolling = input;

            int count = 0;

            for(int i = 0; i < rolling.length(); i++){

                if(isValid(rolling)){
                    count++;
                }

                // 문자열 회전
                rolling = rolling.substring(1)+rolling.charAt(0);

            }

            return count;
        }

        public boolean isValid(String string) {

            char[] brackets = string.toCharArray();

            Stack<Character> stack = new Stack<>();

            for(int i = 0; i < brackets.length; i++){

                char tmp = brackets[i];

                if( tmp == '[' || tmp == '{' || tmp == '('){
                    stack.add(tmp);
                }
                else if(tmp == ']'){
                    if(stack.isEmpty() || stack.peek() != '['){
                        return false;
                    }
                    stack.pop();
                }
                else if(tmp == '}'){
                    if(stack.isEmpty() || stack.peek() != '{'){
                        return false;
                    }
                    stack.pop();
                }
                else if(tmp == ')'){
                    if(stack.isEmpty() || stack.peek() != '('){
                        return false;
                    }
                    stack.pop();
                }
            }
            return stack.isEmpty();
        }
    }

}

