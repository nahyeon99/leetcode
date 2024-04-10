import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static FastReader sc = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static char[][] matrix;

	public static void main(String[] args) {
		int N = sc.nextInt();
		matrix = new char[4 * (N - 1) + 1][4 * (N - 1) + 1];
		int SIZE = (2 * N - 1) * 2 - 1;

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				matrix[i][j] = ' ';
			}
		}

		recursive(0, 0, N);

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				sb.append(matrix[i][j]);
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}

	public static void recursive(int x, int y, int step) {
		if (step == 1) {
			matrix[y][x] = '*';
			return;
		}

		int length = (2 * step - 1) * 2 - 1;

		for (int i = 0; i < length; i++) {
			// upper, bottom line
			matrix[y][x + i] = '*';
			matrix[y + length - 1][x + i] = '*';
		}
		for (int i = 0; i < length - 1; i++) {
			// both side line
			matrix[y + i][x] = '*';
			matrix[y + i][x + length - 1] = '*';
		}

		recursive(x + 2, y + 2, step - 1);
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
