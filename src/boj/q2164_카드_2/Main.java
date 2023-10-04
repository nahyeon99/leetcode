package boj.q2164_카드_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();

    public static void main(String[] args) {

        int N = scan.nextInt();
        Queue<Integer> myQueue = new LinkedList<>();

        for (int i = 1; i <=N; i++) {
            myQueue.add(i);
        }

        boolean moveFlag = false; // 버릴 것인지 옮길 것인지 체크

        while (myQueue.size() > 1) {
            Integer pollValue = myQueue.poll();
            if (moveFlag) {
                myQueue.add(pollValue);
            }
            moveFlag = !moveFlag;
        }

        System.out.println(myQueue.peek());
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}