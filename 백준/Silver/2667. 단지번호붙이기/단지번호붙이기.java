import java.io.*;
import java.util.*;

public class Main {

	static FastReader sc = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, group_cnt;
	static String[] A;
	static boolean[][] visited;
	static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static ArrayList<Integer> group;

	static void input() {
		N = sc.nextInt();
		A = new String[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.next();
		}
		visited = new boolean[N][N];
	}

	static void pro() {
		group = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && A[i].charAt(j) == '1') {
					// TODO: 갈 수 있는 칸인데, 방문처리 되지 않은, 즉 새롭게 만난 단지인 경우
					group_cnt = 0;
					dfs(i, j);
					group.add(group_cnt);
				}
			}
		}

		// TODO: 찾은 단지의 정보를 출력하기
		Collections.sort(group);
		sb.append(group.size()).append('\n');

		for (int cnt : group) {
			sb.append(cnt).append('\n');
		}
		System.out.println(sb);
	}

	// x, y 를 갈 수 있다는 걸 알고 방문한 상태
	static void dfs(int x, int y) {
		// TODO: 단지에 속한 집의 개수 증가, visit 체크 하기
		group_cnt++;
		visited[x][y] = true;

		// TODO: 인접한 집으로 새로운 방문하기
		for (int k = 0; k < 4; k++) {
			int nx = x + dir[k][0];
			int ny = y + dir[k][1];

			if (nx < 0 || ny < 0 || nx >= N || ny >= N)
				continue;
			if (A[nx].charAt(ny) == '0')
				continue;
			if (visited[nx][ny])
				continue;

			dfs(nx, ny);
		}
	}

	public static void main(String[] args) {
		input();
		pro();

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