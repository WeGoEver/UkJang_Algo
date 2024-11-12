import java.util.*;

public class TextBook_트리순회 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] input = { 1, 2, 3, 4, 5, 6, 7 };

        System.out.println(Arrays.toString(solution.solution(input)));

    }

    private static class Solution {

        public String[] solution(int[] arr) {

            // 입력 받은 정수 배열 이진 트리로 변환
            int[]  binaryTree = new int[arr.length + 1];

            // 자신의 자리 찾아서 삽입
            int index = 1;

           for(int tmp : arr){
                if(binaryTree[index] == 0){
                    binaryTree[index] = tmp;
                }

           }
        
            
            String[] answer = {"1","1"};

            return answer;
        }

        public static void insertTree(int[] tree, int number){
            
        }

    }
}
