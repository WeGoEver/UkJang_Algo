
import java.util.*;

public class Programmers_신고결과받기{

    public static void main(String[] args) {

        Solution solution = new Solution();

        // ["muzi", "frodo", "apeach", "neo"]
        // ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]
        // 2

        String[] idList = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;


        System.out.println(Arrays.toString(solution.solution(idList, report, k)));

    }

    private static class Solution {

        public int[] solution(String[] idList, String[] report, int k) {

            // 순서 HashMap 선언
            HashMap<String, Integer> userOrder = new HashMap<>();

            for(int i = 0; i < idList.length; i++){
                userOrder.put(idList[i], i);
            }

            // 1. 유저별 신고 목록 정리
            // HashMap<String, ArrayList> 자료구조에 user가 신고한 유저를 정리한다.
            // ArrayList에 신고 유저를 추가할 때 중복이 있는지 확인해야함.
            HashMap<String, ArrayList<String>> userReport = new HashMap<>();

            for(String reportMsg : report){

                String[] splitMsg = reportMsg.split(" ");

                // splitMsg[0] : 신고한 사람
                // splitMsg[1] : 신고 당한 사람

                // userReport에 Key값이 있는지 확인
                if(userReport.containsKey(splitMsg[0])){
                    // 똑같은 사람을 신고할 경우 1번으로 처리하므로 이미 신고한 유저인지 확인
                    if(!userReport.get(splitMsg[0]).contains(splitMsg[1])){
                        userReport.get(splitMsg[0]).add(splitMsg[1]);
                    }
                }else if(!userReport.containsKey(splitMsg[0])){

                    // Key 값이 없으면 새로 추가
                    ArrayList<String> reportedUser = new ArrayList<>();

                    reportedUser.add(splitMsg[1]);

                    userReport.put(splitMsg[0],reportedUser);
                }
            }

            // System.out.println(userReport.toString());

            // 2. 불량 누적 신고량 계산
            HashMap<String, Integer> reportedUserMap = new HashMap<>();

            String[] userKeySet = userReport.keySet().toArray(new String[0]);

            // 유저별 신고 목록을 탐색하면서 신고 당한 유저의 누적 회수를 reportedUserMap(HashMap)에 저장
            for( String userName : userKeySet){

                for( String name :  userReport.get(userName) ){
                    reportedUserMap.put(name, reportedUserMap.getOrDefault(name, 0) + 1);
                }

            }

            // System.out.println(reportedUserMap.toString());

            // 3. 누적 신고량이 K 이상인 유저 리스트 생성
            ArrayList<String> blackList = new ArrayList<>();

            // reportedUserMap(HashMap)의 Value값이 K값이 이상인 User 탐색
            for(String name : reportedUserMap.keySet()){

                if(reportedUserMap.get(name) >= k){
                    blackList.add(name);
                }
            }

            // System.out.println(blackList.toString());

            // 4. 자신이 신고했던 유저 중에 블랙 당한 유저가 몇명인지 확인
            int[] answer = new int[idList.length];

            for(int i = 0; i < idList.length; i++){

                // 유저가 신고했던 목록
                ArrayList<String> tmp = userReport.getOrDefault(idList[i], null);

                if(tmp != null){
                    for(String name: blackList){
                        if(tmp.contains(name)){
                            answer[i]++;
                        }
                    }
                }
            }
            return answer;
        }
    }
}
