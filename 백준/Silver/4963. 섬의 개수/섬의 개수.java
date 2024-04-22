import java.io.*;
import java.util.*;

public class Main {

	static FastReader sc = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int group_cnt;
	static ArrayList<Integer> group;

	static boolean[][] A, visited;
	static int w, h;

	static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};


	static void input(String size) {
		// System.out.println("===== input ======");
		int[] mapSize = Arrays.stream(size.split(" ")).mapToInt(Integer::parseInt).toArray();
		w = mapSize[0];
		h = mapSize[1];
		// System.out.println("=== width : " + w + ", height : " + h);

		A = new boolean[w][h];
		visited = new boolean[w][h];

		for (int i = 0; i < h; i++) {
			int[] m = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			for (int j = 0; j < w; j++) {
				A[j][i] = (m[j] == 1) ? true : false;
			}
		}
	}

	static void pro() {
		group_cnt = 0;
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				if (A[i][j] && !visited[i][j]) {
					dfs(i, j);
					group_cnt++;
				}
			}
		}
		group.add(group_cnt);
	}

	static void dfs(int x, int y) {
		visited[x][y] = true;

		for (int k = 0; k < dir.length; k++) {
			int nx = x + dir[k][0];
			int ny = y + dir[k][1];

			if (nx < 0 || ny < 0 || nx >= w || ny >= h)
				continue;
			if (!A[nx][ny] || visited[nx][ny])
				continue;

			dfs(nx, ny);
		}
	}

	public static void main(String[] args) {
		group = new ArrayList<>();
		while (true) {
			String input = sc.nextLine();
			if (input == null || input.isEmpty())
				break;

			input(input);
			pro();
		}
		group.remove(group.size() - 1);

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