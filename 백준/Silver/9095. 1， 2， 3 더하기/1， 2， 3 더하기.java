import java.io.*;
import java.util.*;

public class Main {

	static FastReader sc = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int[] Dy;

	static void preprocess() {
		Dy = new int[15];
		// TODO: 초기값 구하기
		Dy[1] = 1;
		Dy[2] = 2;
		Dy[3] = 4;

		// TODO: 점화식을 토대로 Dy 배열 채우기
		for (int i = 4; i < 11; i++) {
			Dy[i] = Dy[i - 1] + Dy[i - 2] + Dy[i - 3];
		}
	}

	static void pro() {
		int T = sc.nextInt();
		for (int tt = 0; tt < T; tt++) {
			int N = sc.nextInt();
			sb.append(Dy[N]).append('\n');
		}
		System.out.println(sb);
	}

	public static void main(String[] args) {
		preprocess();
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