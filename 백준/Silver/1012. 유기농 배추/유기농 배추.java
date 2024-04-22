import java.io.*;
import java.util.*;

public class Main {

	static FastReader sc = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int group_cnt;
	static ArrayList<Integer> group;

	static boolean[][] A, visited;
	static int x, y;

	static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


	static void input() {
		x = sc.nextInt();
		y = sc.nextInt();
		int N = sc.nextInt();
		A = new boolean[x][y];
		visited = new boolean[x][y];

		for (int i = 0; i < N; i++) {
			int[] loc = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			A[loc[0]][loc[1]] = true;
		}
	}

	static void pro() {
		group_cnt = 0;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (A[i][j] == true && !visited[i][j]) {
					group_cnt++;
					dfs(i, j);
				}
			}
		}
		group.add(group_cnt);
	}

	static void dfs(int i, int j) {
		visited[i][j] = true;

		for (int k = 0; k < 4; k++) {
			int nx = i + dir[k][0];
			int ny = j + dir[k][1];

			if (nx < 0 || ny < 0 || nx >= x || ny >= y)
				continue;
			if (!A[nx][ny])
				continue;
			if (visited[nx][ny])
				continue;

			dfs(nx, ny);
		}
	}

	public static void main(String[] args) {
		int tc = sc.nextInt();
		group = new ArrayList<>();

		for (int i = 0; i < tc; i++) {
			input();
			pro();
		}

		for (int size : group) {
			sb.append(size).append('\n');
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

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}