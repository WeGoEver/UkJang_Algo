import java.io.*;

public class Softeer_TrendelFin {

    public static void main(String[] args) throws IOException{

        // 1. N개 입력 받음
        // 입력 받은 문자열을 " "(공백) 기준으로 [0][1] 2차원 배열에 저장
        // [1] 값 중에 가장 작은 값 기록

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //System.out.println(n);

        int[][] stations = new int[n][2];
        int min = 1001;
        int index = -1;

        for(int i = 0; i < n; i++){

            String[] tmp = br.readLine().split(" ");

            //System.out.println(tmp.length);

            stations[i][0] = Integer.parseInt(tmp[0]);
            stations[i][1] = Integer.parseInt(tmp[1]);

            if(stations[i][1] < min){
                min = stations[i][1];
                index = i;
            }
        }

            System.out.printf("%d %d",stations[index][0],stations[index][1]);
    }
}
