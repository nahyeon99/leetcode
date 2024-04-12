import java.io.*;
import java.util.*;

public class Main {

	static FastReader sc = new FastReader();

	public static void main(String[] args) throws IOException {
		int N = sc.nextInt();
		int L = sc.nextInt();

		int position = 0;
		int time = 0;

		for (int i = 0; i < N; i++) {
			int D = sc.nextInt();
			int R = sc.nextInt();
			int G = sc.nextInt();

			time += D - position;
			position = D;

			int gap = time % (R + G);
			if (gap < R)
				time += R - gap;
		}

		time += L - position;

		System.out.println(time);
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