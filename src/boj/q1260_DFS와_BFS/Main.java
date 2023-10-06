package boj.q1260_DFS와_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static ArrayList<Integer>[] A;
    static boolean[] isVisited;

    public static void main(String[] args) {

        int N = scan.nextInt();
        int M = scan.nextInt();
        int V = scan.nextInt();

        A = new ArrayList[N + 1];
        isVisited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int v1 = scan.nextInt();
            int v2 = scan.nextInt();
            A[v1].add(v2);
            A[v2].add(v1);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }

        DFS(V);
        sb.append('\n');

        isVisited = new boolean[N + 1];
        BFS(V);

        System.out.println(sb);
    }

    static void DFS(int V) {
        sb.append(V).append(' ');
        isVisited[V] = true;

        for (int i : A[V]) {
            if (!isVisited[i])
                DFS(i);
        }
    }

    static void BFS(int start) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Integer nowNode = queue.poll();
            sb.append(nowNode).append(' ');
            isVisited[nowNode] = true;

            for (int i : A[nowNode]) {
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    queue.add(i);
                }
            }
        }
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
