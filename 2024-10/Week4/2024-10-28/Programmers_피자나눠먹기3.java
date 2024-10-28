public class Programmers_피자나눠먹기3 {
    public static void main(String[] args){

        Solution solution = new Solution();

        System.out.print(solution.solution(7, 10));
    }
}

class Solution{
    public int solution(int slice, int n) {
        int answer = 0;

        int tmp = n % slice;

        if(tmp == 0){
            answer = n / slice;
        } else{
            answer = n / slice + 1;
        }

        return answer;
    }
}