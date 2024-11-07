import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Programmers_베스트앨범_v1 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        // ["classic", "pop", "classic", "classic", "pop"] [500, 600, 150, 800, 2500]
        // [4, 1, 3, 0]

        String[] genres = { "classic", "pop", "classic", "classic", "pop" };
        int[] plays = { 500, 600, 150, 800, 2500 };

        System.out.println(Arrays.toString(solution.solution(genres, plays)));

    }

    private static class Solution {

        public int[] solution(String[] genres, int[] plays) {

            // HashMap
            HashMap<String, ArrayList<int[]>> genreMap = new HashMap<>();
            HashMap<String, Integer> playMap = new HashMap<>();

            int n = genres.length;

            for (int i = 0; i < n; i++) {

                String genre = genres[i];
                int play = plays[i];

                if (!genreMap.containsKey(genre)) {

                    genreMap.put(genre, new ArrayList<>());
                    playMap.put(genre, 0);

                }

                // 장르 : { 인덱스, 플레이 회수}
                genreMap.get(genre).add(new int[] { i, play });

                // 장르 : 총 플레이 회수
                playMap.put(genre, playMap.get(genre) + play);

            }

            System.out.println(genreMap.toString());

            System.out.println(playMap.toString());

            ArrayList<Integer> answer = new ArrayList<>();

            // ❷ 총 재생 횟수가 많은 장르순으로 내림차순 정렬
            List<Map.Entry<String, Integer>> sortedGenres = new ArrayList<>(playMap.entrySet());

            Collections.sort(sortedGenres, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            });

            // ❸ 각 장르 내에서 노래를 재생 횟수 순으로 정렬해 최대 2곡까지 선택
            for (Map.Entry<String, Integer> entry : sortedGenres) {
                List<int[]> songs = genreMap.get(entry.getKey());
                Collections.sort(songs, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o2[1] - o1[1];
                    }
                });

                for (int i = 0; i < songs.size() && i < 2; i++) {
                    answer.add(songs.get(i)[0]);
                }
            }

            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
