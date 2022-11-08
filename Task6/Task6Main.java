package Task6;

import java.util.Arrays;
import java.util.Scanner;

public class Task6Main {
    public static void main(String[] arg){
        Scanner in = new Scanner(System.in);
        int maxN = in.nextInt();
        GraphTask6 graph = new GraphTask6(maxN);
        for (int i = 0; i < maxN; i++) {
            Scanner in2 = new Scanner(System.in);
            String verSrt = in2.nextLine();
            int[] cordVerArr = Arrays.stream(verSrt.split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.addVertex(cordVerArr[0], cordVerArr[1]);
        }

        Scanner in3 = new Scanner(System.in);
        int k = in3.nextInt();
        graph.addEdge(maxN, k);

        Scanner in4 = new Scanner(System.in);
        String city = in4.nextLine();
        int[] cityNum = Arrays.stream(city.split(" ")).mapToInt(Integer::parseInt).toArray();
        int start = cityNum[0] - 1;
        int end = cityNum[1] - 1;

        int[] distance = graph.passInWidht(start);
        int answer = distance[end];
        System.out.println(answer);
    }
}