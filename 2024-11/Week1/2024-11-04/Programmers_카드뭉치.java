public class Programmers_카드뭉치 {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // ["i", "drink", "water"] ["want", "to"] ["i", "want", "to", "drink", "water"]
        // "Yes"
        // ["i", "water", "drink"] ["want", "to"]

        String[] card1 = { "i", "drink", "water" };
        String[] card2 = { "want", "to" };
        String[] goal = { "i", "want", "to", "drink", "water" };

        System.out.println(solution.solution(card1, card2, goal));

    }

    // Solution 클래스를 정적(static)으로 변경
    private static class Solution {
        public String solution(String[] cards1, String[] cards2, String[] goal) {

            // a : cards1 의 인덱스
            // b : cards2 의 인덱스
            int a = 0;
            int b = 0;

            for (int i = 0; i < goal.length; i++) {

                String item = goal[i];

                if (item.equals(cards1[a])) {
                    a++;
                    if (a >= cards1.length) {
                        a = cards1.length - 1;
                    }
                } else if (item.equals(cards2[b])) {
                    b++;
                    if (b >= cards2.length) {
                        b = cards2.length - 1;
                    }
                } else {
                    return "No";
                }

            }

            return "Yes";
        }
    }
}