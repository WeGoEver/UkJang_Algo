import java.io.*;

public class Softeer_Level2_나무공격 {

    public static void main(String[] args) throws IOException{
        // 시간 제한 1초 = 10^8 연산 이내
        // n * m 크기의 사각형
        // 5 <= n, m <= 10^2
        // L ~ R 행으로 공격 -> R - L = 4

        // 2차원 배열로 구현할 경우 완전 탐색 3번 돌면 됨 -> 최대 시간 복잡도 10^2 * 3
        // 하지만 각 행에 환경 파괴범이 몇명인지만 알면 이차원 배열을 사용하지 않고 문제 풀 수 있음.
        // 각 행에 파괴범 수 구한 후 공격 받으면 -1 씩 하면 되니까.
        // 이 문제에서는 n 만큼 1차원 배열 선언 후 입력 받을 시 1의 개수를 증가시키고
        // 공격 받은 행의 개수를 -1 차감하여 최종 환경 파괴범 수를 구할 거임
        
        // 입력
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. n, m이 공백을 사이에 두고 입력
        String[] nmString = reader.readLine().split(" ");

        int n = Integer.parseInt(nmString[0]);
        int m = Integer.parseInt(nmString[1]);

        // System.out.println("n : " + n);
        // System.out.println("m : " + m);

        // 각 행의 환경 파괴범 수를 저장할 배열 선언
        int[] countVirus = new int[n];
        
        // 2. 2 ~ n + 1 줄 까지 각 행의 정보 입력
        // 0 이면 비어있는 칸, 1이면 환경 파괴범

        for(int i = 0; i < n; i++){
            String[] virus = reader.readLine().split(" ");
            
            // System.out.println(Arrays.toString(virus) + " : " +i);
            
            for(int j = 0 ; j < m ; j++){
                // System.out.println(virus[j]);
                if(virus[j].equals("1")){
                    countVirus[i]++;
                }
            }
        }
        // System.out.println(Arrays.toString(countVirus));
    
        // 3. n + 2 번째 줄에는 L1 R1 값 입력
        // 4. n + 3 번째 줄에는 L2 R2 값 입력

        String[] attack1 = reader.readLine().split(" ");
        String[] attack2 = reader.readLine().split(" ");

        int l1 = Integer.parseInt(attack1[0]);
        int r1 = Integer.parseInt(attack1[1]);
        int l2 = Integer.parseInt(attack2[0]);
        int r2 = Integer.parseInt(attack2[1]);

        // System.out.println("l1 : " + l1 + " r1 : " + r1);
        // System.out.println("l2 : " + l2 + " r2 : " + r2);

        for(int i = l1 -1 ; i < r1 ; i++){
            if(countVirus[i] > 0){
                countVirus[i]--;    
            }
        }

        for(int i = l2 -1 ; i < r2 ; i++){
            if(countVirus[i] > 0){
                countVirus[i]--;    
            }
        }

        // System.out.println(Arrays.toString(countVirus));

        int sum = 0;

        for(int tmp : countVirus){
            sum = sum + tmp;
        }

        System.out.println(sum);
    }
}
