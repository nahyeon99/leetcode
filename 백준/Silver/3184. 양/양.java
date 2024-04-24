import java.io.*;
import java.util.*;

public class Main {

	static FastReader sc = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int sheep, wolf;
	static int row, height;

	static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	static Character[][] A;
	static boolean[][] visited;


	static void input() {
		sheep = 0; wolf = 0;
		row = sc.nextInt();
		height = sc.nextInt();
		A = new Character[row][height];
		visited = new boolean[row][height];

		for (int i = 0; i < row; i++) {
			String inputLine = sc.nextLine();
			for (int j = 0; j < height; j++) {
				A[i][j] = inputLine.charAt(j);
			}
		}
	}

	static void pro() {
		int sheepTotal = 0;
		int wolfTotal = 0;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < height; j++) {
				if (A[i][j] != '#' && A[i][j] != '.' && !visited[i][j]) {
					sheep = 0;
					wolf = 0;
					dfs(i, j);
					if (sheep > wolf) {
						sheepTotal += sheep;
					} else {
						wolfTotal += wolf;
					}
				}
			}
		}

		sb.append(sheepTotal).append(' ').append(wolfTotal);
		System.out.println(sb);
	}

	static void dfs(int x, int y) {
		visited[x][y] = true;

		if (A[x][y] == 'o')
			sheep++;
		else if (A[x][y] == 'v')
			wolf++;

		for (int k = 0; k < dir.length; k++) {
			int nx = x + dir[k][0];
			int ny = y + dir[k][1];

			if (nx < 0 || ny < 0 || nx >= row || ny >= height)
				continue;
			if (visited[nx][ny] || A[nx][ny] == '#')
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