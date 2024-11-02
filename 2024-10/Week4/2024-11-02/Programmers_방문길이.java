import java.util.HashSet;

public class Programmers_방문길이 {
    public static void main(String[] args) {

        Solution solution = new Solution();

        String dirs = "LULLLLLLU";

        System.out.println(solution.solution(dirs));
    }

    // Solution 클래스를 정적(static)으로 변경
    private static class Solution {
        public int solution(String dirs) {

            // dirs to char 배열로 변경
            char[] dirsArray = dirs.toCharArray();

            // HashSet 선언
            HashSet<String> route = new HashSet<>();

            int[] position = { 5, 5 };

            // char 배열의 길이만큼 for 문 돌면서 경로 탐색
            // 경로 탐색하면서 지나온 루트 HashSet에 추가
            // 루트 이동 시 경계를 넘어가는 숫자는 무시해야함.
            // HashSet을 이용하연 중복된 루트는 자동으로 걸러짐
            for (int i = 0; i < dirsArray.length; i++) {

                // 이동하기 이전 좌표 before
                String before = Integer.toString(position[0]) + Integer.toString(position[1]);

                // 경계를 넘어가면 좌표 이동 X
                if (dirsArray[i] == 'U') {

                    if (position[1] < 10) {
                        position[1]++;
                    }
                } else if (dirsArray[i] == 'D') {

                    if (position[1] > 0) {
                        position[1]--;
                    }
                } else if (dirsArray[i] == 'R') {

                    if (position[0] < 10) {
                        position[0]++;
                    }
                } else if (dirsArray[i] == 'L') {

                    if (position[0] > 0) {
                        position[0]--;
                    }
                }

                // 이동 이후 좌표 after
                String after = Integer.toString(position[0]) + Integer.toString(position[1]);

                //System.out.println(before + after);

                // 이전 좌표 -> 이후 좌표, 이후 좌표 -> 이전 좌표 의 경로는 동일한 route이기 때문에 둘다 HashSet에 저장
                // 이전 좌표 == 이후 좌표 일 경우 이동한 경로가 없는 것.
                if(!before.equals(after)){
                    route.add(before + after);
                    route.add(after + before);
                }
            }

            int answer = route.size() / 2;

            return answer;
        }
    }
}
