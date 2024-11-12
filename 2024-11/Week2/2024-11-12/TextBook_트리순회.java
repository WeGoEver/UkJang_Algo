
import java.util.*;

public class TextBook_트리순회 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] input = {1, 2, 3, 4, 5, 6, 7};

        System.out.println(Arrays.toString(solution.solution(input)));

    }

    private static class Solution {

        public String[] solution(int[] arr) {

            // 입력 받은 정수 배열 이진 트리로 변환
            int[] binaryTree = new int[arr.length + 1];

            int arrLength = arr.length;

            // arr 배열에 트리 삽입
            for (int i = 1; i <= arrLength; i++) {
                binaryTree[i] = arr[i - 1];
            }

            // System.out.println(Arrays.toString(binaryTree));

            // 전위 순회
            ArrayList<Integer> preorderList = new ArrayList<>();
            int[] preTree = binaryTree.clone();

            preoder(preTree, 1, preorderList);

            // 전위 순회 성공
            // System.out.println(preorderList.toString());

            // 중위 순회
            ArrayList<Integer> inorderList = new ArrayList<>();
            int[] inTree = binaryTree.clone();

            inorder(inTree, 1, inorderList);

            // 중위 순회 성공
            // System.out.println(inorderList.toString());

            // 후위 순회
            ArrayList<Integer> postorderList = new ArrayList<>();
            int[] postTree = binaryTree.clone();

            postorder(postTree, 1, postorderList);

            // 중위 순회 성공
            // System.out.println(postorderList.toString());

            String[] answer = new String[3];

            answer[0] = preorderList.toString();
            answer[1] = inorderList.toString();
            answer[2] = postorderList.toString();

            return answer;
        }

        // 후위 순회
        public static void postorder(int[] tree, int index, ArrayList<Integer> list) {

            // 후위 순회
            // 왼쪽 자식이 존재할 때, 왼쪽 자식을 먼저 방문
            if (index * 2 < tree.length && tree[index * 2] != 0) {
                postorder(tree, index * 2, list);
            }

            // 오른쪽 자식이 존재할 때, 오른쪽 자식을 방문
            if (index * 2 + 1 < tree.length && tree[index * 2 + 1] != 0) {
                postorder(tree, index * 2 + 1, list);
            }

            // 부모 노드 방문 (후위 순회에서 마지막으로 방문)
            if (tree[index] != 0) {
                list.add(tree[index]);
                tree[index] = 0; // 방문한 노드를 0으로 설정해 재방문하지 않도록 합니다.
            }
        }

    }

    // 중위 순회
    public static void inorder(int[] tree, int index, ArrayList<Integer> list) {

        // 부모 노드
        if (tree[index] != 0) {

            if (index * 2 < tree.length && tree[index * 2] != 0) {
                // 값이 있으면 중위 순회 시작
                inorder(tree, index * 2, list);
            }

            list.add(tree[index]);

            tree[index] = 0;

        } else {
            return;
        }

        // 오른쪽 자식 노드
        if (index * 2 + 1 < tree.length && tree[index * 2 + 1] != 0) {
            // 값이 있으면 전위 순회 시작
            inorder(tree, index * 2 + 1, list);

            // list.add(tree[index * 2 + 1]);
            // tree[index * 2 + 1]=0;
        } else {
            return;
        }

    }

    // 전위 순회
    public static void preoder(int[] tree, int index, ArrayList<Integer> list) {

        // 부모 노드
        if (tree[index] != 0) {
            // 값이 있으면 list에 추가
            list.add(tree[index]);

            // 방문한 곳은 0 값으로 변경
            tree[index] = 0;
        } else {
            return;
        }

        // 왼쪽 자식 노드
        if (index * 2 < tree.length && tree[index * 2] != 0) {
            // 값이 있으면 전위 순회 시작
            preoder(tree, index * 2, list);

        } else {
            return;
        }

        // 오른쪽 자식 노드
        if (index * 2 + 1 < tree.length && tree[index * 2 + 1] != 0) {
            // 값이 있으면 전위 순회 시작
            preoder(tree, index * 2 + 1, list);

        } else {
            return;
        }

    }

}

