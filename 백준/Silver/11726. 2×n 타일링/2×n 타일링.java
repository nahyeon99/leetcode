import java.io.*;
import java.util.*;

public class Main {

	static FastReader sc = new FastReader();

	static int[] Dy;

	static void preprocess() {
		Dy = new int[1_005];
		// TODO: 초기값 구하기
		Dy[1] = 1;
		Dy[2] = 2;
		Dy[3] = 3;

		// TODO: 점화식을 토대로 Dy 배열 채우기
		for (int i = 4; i <= 1000; i++) {
			Dy[i] = (Dy[i - 1] + Dy[i - 2]) % 10_007;
		}
	}

	static void pro() {
		int N = sc.nextInt();
		System.out.println(Dy[N]);
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