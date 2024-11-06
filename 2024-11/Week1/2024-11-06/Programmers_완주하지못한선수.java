
import java.util.HashMap;

public class Programmers_완주하지못한선수 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        //["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]	"mislav"

        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        System.out.println(solution.solution(participant, completion));

    }

    private static class Solution {

        public String solution(String[] participant, String[] completion) {

            HashMap<String, Integer> map = new HashMap<>();

            String answer = "";

            for(String name : participant){
                if(map.containsKey(name)){
                    int count = map.get(name);
                    map.put(name, ++count);
                }else{
                    map.put(name, 1);
                }
            }

            System.out.println(map.toString());

            for(String name : completion){
                if(map.containsKey(name)){
                    int count = map.get(name);
                    map.put(name, --count);
                }
            }

            System.out.println(map.toString());

            for(String name : participant){
                if(map.get(name) > 0){
                    answer = name;
                }
            }

            return answer;
        }
    }
}
