public class Baekjoon_5337 {
    public static void main(String[] args){

        Solution solution = new Solution();

        System.out.print(solution.solution(4));
    }
}

class Solution{
    public int solution(int n){
    
        int answer = 0;

        for(int i = 1; i <= n; i++){
            
            int tmp = 6 * i;
            
            if( tmp % n == 0){
                answer = i;
                break;
            }

            answer = i;
        }

        return answer;
    }
}