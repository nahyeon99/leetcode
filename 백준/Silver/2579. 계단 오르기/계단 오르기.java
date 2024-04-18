import java.io.*;
import java.util.*;

public class Main {

	static FastReader sc = new FastReader();

	static int[][] Dy;
	static int[] A;
	static int N;

	static void input() {
		N = sc.nextInt();
		A = new int[N+1];
		Dy = new int[N+1][2];

		for (int i = 1; i <= N; i++) {
			A[i] = sc.nextInt();
		}
	}

	static void pro() {
		// 초기값 구하기
		Dy[1][0] = 0;
		Dy[1][1] = A[1];

		if (N >= 2) {
			Dy[2][0] = A[2];
			Dy[2][1] = A[1] + A[2];
		}

		// TODO: 점화식을 토대로 Dy 배열 채우기
		for (int i = 3; i <= N; i++) {
			Dy[i][0] = Math.max(Dy[i - 2][0] + A[i], Dy[i - 2][1] + A[i]);
			Dy[i][1] = Dy[i - 1][0] + A[i];
		}

		// TODO: Dy 배열로 정답 계산하기
		int ans = Math.max(Dy[N][0], Dy[N][1]);

		System.out.println(ans);
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