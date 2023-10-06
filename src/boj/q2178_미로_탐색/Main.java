package boj.q2178_미로_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();

    // 상하좌우 탐색 용도
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int N, M;
    static int[][] A;
    static boolean[][] isVisited;

    public static void main(String[] args) {

        N = scan.nextInt();
        M = scan.nextInt();

        A = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {

            String row = scan.next();
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(row.substring(j, j + 1));
            }
        }

        BFS(0, 0);
        System.out.println(A[N - 1][M - 1]);
    }

    static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        isVisited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int k = 0; k < 4; k++) {
                int moveX = now[0] + dx[k];
                int moveY = now[1] + dy[k];

                // 좌표 유효성 검사
                if (moveX >= 0 && moveY >= 0 && moveX < N && moveY < M) {

                    // 갈 수 있는 칸 여부 & 방문 여부 검사
                    if (A[moveX][moveY] != 0 && !isVisited[moveX][moveY]) {
                        isVisited[moveX][moveY] = true;
                        A[moveX][moveY] = A[now[0]][now[1]] + 1; // depth 업데이트
                        queue.add(new int[]{moveX, moveY});
                    }
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
