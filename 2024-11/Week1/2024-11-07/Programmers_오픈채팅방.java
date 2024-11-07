
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Programmers_오픈채팅방{

    public static void main(String[] args) {

        Solution solution = new Solution();

        // ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]	
        // ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]

        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        System.out.println(Arrays.toString(solution.solution(record)));

    }

    private static class Solution {

        public String[] solution(String[] record) {
            
            // user와 nickname을 저장할 HashMap
            HashMap<String, String> map = new HashMap<>();

            for(String command1 : record){

                String[] tmp = command1.split(" ");

                if(tmp[0].equals("Enter")){
                    
                    map.put(tmp[1], tmp[2]);

                }else if(tmp[0].equals("Change")){
                    map.put(tmp[1], tmp[2]);
                }

            }

            System.out.println(map.toString());

            ArrayList<String> list = new ArrayList<>();

            for(String command2 : record){

                String[] tmp = command2.split(" ");

                if(tmp[0].equals("Enter")){
                    
                    list.add(map.get(tmp[1]) + "님이 들어왔습니다.");

                }else if(tmp[0].equals("Leave")){

                    list.add(map.get(tmp[1]) + "님이 나갔습니다.");
                }

            }

            String[] answer = list.toArray(new String[0]);

            return answer;
        }
    }
}
