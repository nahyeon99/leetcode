package boj.q11003_최솟값_찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        public int index;
        public int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int N = scan.nextInt();
        int L = scan.nextInt();

        Deque<Node> myDeque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            int now = scan.nextInt();

            while (!myDeque.isEmpty() && myDeque.getLast().value > now)
                myDeque.removeLast();

            myDeque.addLast(new Node(i, now));

            // 범위에서 벗어난 값은 덱에서 제거
            if (myDeque.getFirst().index <= i - L)
                myDeque.removeFirst();

            sb.append(myDeque.getFirst().value).append(" ");
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
