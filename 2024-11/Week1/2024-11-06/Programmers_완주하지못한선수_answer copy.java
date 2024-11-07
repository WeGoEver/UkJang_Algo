
import java.util.HashMap;

public class Programmers_완주하지못한선수_answer {

    public static void main(String[] args) {

        Solution solution = new Solution();

        //["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]	"mislav"
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        System.out.println(solution.solution(participant, completion));

    }

    private static class Solution {

        public String solution(String[] participant, String[] completion) {

            // ❶ 해시맵 생성
            HashMap<String, Integer> hashMap = new HashMap<>();
            // ❷ 완주한 선수들의 이름을 해시맵에 저장
            for (String string : completion) {
                hashMap.put(string, hashMap.getOrDefault(string, 0) + 1);
            }

            // ❸ 참가한 선수들의 이름을 키로 하는 값을 1씩 감소
            for (String string : participant) {
                // ❹ 완주하지 못한 선수를 찾으면 반환
                if (hashMap.getOrDefault(string, 0) == 0) {
                    return string;
                }
                hashMap.put(string, hashMap.get(string) - 1);
            }

            return null;
        }
    }
}
