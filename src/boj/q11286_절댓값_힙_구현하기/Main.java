package boj.q11286_절댓값_힙_구현하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        int N = scan.nextInt();
        PriorityQueue<Integer> myQueue = new PriorityQueue<>(((o1, o2) -> {

            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);
            if (abs1 == abs2) // 절댓값이 같다면 음수 우선 정렬
                return o1 > o2 ? 1 : -1;
            else
                return abs1 - abs2;
        }));

        for (int i = 0; i < N; i++) {

            int num = scan.nextInt();
            if (num == 0) {

                if (myQueue.isEmpty())
                    sb.append(0).append('\n');
                else
                    sb.append(myQueue.poll()).append('\n');
            } else {
                myQueue.add(num);
            }
        }
        System.out.println(sb);
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
