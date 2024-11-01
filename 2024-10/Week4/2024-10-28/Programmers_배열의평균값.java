public class Programmers_배열의평균값 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.print(solution.solution(arr));
    }
    private static class Solution {
        public double solution(int[] numbers) {
            double answer = 0;

            for (int i = 0; i < numbers.length; i++) {
                answer += numbers[i];
            }

            return answer / numbers.length;
        }
    }
}