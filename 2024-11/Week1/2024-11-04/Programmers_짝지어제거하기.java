import java.util.ArrayDeque;

public class Programmers_짝지어제거하기{
    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.solution("cc"));

    }

    // Solution 클래스를 정적(static)으로 변경
    private static class Solution{
        public int solution(String str){

            // ArrayDeque 인터페이스로 Stack 선언
            ArrayDeque<Character> stack = new ArrayDeque<>();

            // for 문을 이용해서 짝이 있는지 확인
            for(int i = 0; i < str.length(); i++){
                char tmp = str.charAt(i);

                if(stack.isEmpty() || stack.peekLast() != tmp){
                    stack.addLast(tmp);
                }else if(stack.peekLast() == tmp){
                    stack.pollLast();
                }
            }

            // int answer = 0;

            // if(stack.isEmpty()){
            //     answer = 1;
            // }

            // 삼항 연산자로 출력 가능
            return stack.isEmpty() ? 0 : 1; 
        }
    }
}
