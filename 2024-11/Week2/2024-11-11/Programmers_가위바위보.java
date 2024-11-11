
public class Programmers_가위바위보 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        String rsp = "205";

        System.out.println(solution.solution(rsp));

    }

    private static class Solution {

        public String solution(String rsp) {
        
            int n = rsp.length();
            
            // System.out.println(n);

            StringBuilder answerBuilder = new StringBuilder();

            for(int i = 0; i < n; i++){

                char tmp = rsp.charAt(i);

                if( tmp == '2' ){
                    answerBuilder.append("0");  
                } else if( tmp == '0' ){
                    answerBuilder.append("5");
                }else if( tmp == '5' ){
                    answerBuilder.append("2");
                }
            }
            
            String answer = answerBuilder.toString();

            return answer;
        }
    }
}
