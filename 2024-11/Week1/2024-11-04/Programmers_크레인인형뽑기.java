import java.util.ArrayDeque;
import java.util.HashMap;

public class Programmers_크레인인형뽑기{
    public static void main(String[] args) {

        Solution solution = new Solution();

        // [[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]
        // [1,5,3,5,1,2,1,4]

        int[][] board = {   {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 3, 0},
                {0, 2, 5, 0, 1, 0},
                {4, 2, 4, 4, 2, 0},
                {3, 5, 1, 3, 1, 1},
                {1, 1, 0, 0, 0, 0} };
        int[] moves = { 6, 5, 2, 3, 4, 6, 5, 1, 2, 3, 4 };

        System.out.println(solution.solution(board, moves));

    }

    // Solution 클래스를 정적(static)으로 변경
    private static class Solution {
        public int solution(int[][] board, int[] moves) {
            int answer = 0;

            // HashMap<Integer, ArrayDeque> 선언
            HashMap<Integer, ArrayDeque<Integer>> map = new HashMap<>();

            int n = board.length;

            // 이중 for문 : board -> ArrayDeque
            for(int i = 0; i < n; i++){

                ArrayDeque<Integer> stack = new ArrayDeque<>();

                for(int j = n - 1 ; j >= 0 ; j--){

                    int doll = board[j][i];
                    if(doll != 0){
                        stack.addLast(doll);
                    }
                }

                map.put(i,stack);
            }

            // Stack 선언 : 바구니 만들기

            ArrayDeque<Integer> bascket = new ArrayDeque<>();

//            for(int i = 0; i < n; i++){
//                System.out.println(map.get(i).toString());
//            }

            // move 대로 움직이미면서 바구니에 담기
            // 인형 뽑아서 Stack에 넣을 때 비어있거나, top 값이 다르면 push
            // top값과 인형 값이 같으면 pop

            for(int i = 0; i < moves.length; i++){

                int location = moves[i] - 1;

                if(!map.get(location).isEmpty()){
                    int getDoll = map.get(location).pollLast();

                    if(bascket.isEmpty() || bascket.peekLast() != getDoll){
                        bascket.addLast(getDoll);
                    } else if (bascket.peekLast() == getDoll) {
                        bascket.pollLast();
                        answer = answer + 2;
                    }
                }

//                System.out.println("i : " + i + " bascekt : " + bascket.toString());

            }


            return answer;
        }
    }
}