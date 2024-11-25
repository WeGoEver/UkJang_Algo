import java.io.*;

public class Softeer_Level2_YeahButHow {

    public static void main(String[] args) throws IOException{
        // 문제에서 원하는 조건을 명확하게 파악하자.
        // ()사이에는 1을 넣어주고
        // )( 사이에는 + 를 넣어주면 제대로 된 수식이 만들어진다.
        // 주어진 조건에서 "가능한 수식이 여러 가지 인 경우, 그중 아무거나 하나를 출력한다."이 있으므로 테스트 조건과 완전히 일치하지 않아도 된다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        s = s.replace("()", "(1)").replace(")(", ")+(");
        System.out.println(s);
    }
}
