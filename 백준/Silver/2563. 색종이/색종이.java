import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static FastReader sc = new FastReader();

	public static void main(String[] args) throws IOException {

		int N = sc.nextInt();

		boolean[][] papers = new boolean[101][101];
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			int left = sc.nextInt();
			int bottom = sc.nextInt();

			for (int x = left; x < left + 10; x++) {
				for (int y = bottom; y < bottom + 10; y++) {
					if (!papers[y][x]) {
						papers[y][x] = true;
						cnt++;
					}
				}
			}
		}

		System.out.println(cnt);

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