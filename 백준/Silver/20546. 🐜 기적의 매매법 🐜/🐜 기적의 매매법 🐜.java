import java.io.*;
import java.util.*;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int BNP_CNT = 0, BNP_MONEY = 0;
	static int TIMING_CNT = 0, TIMING_MONEY = 0;
	static final int[] money = new int[14];

	static void input() {
		int budget = scan.nextInt();
		BNP_MONEY = budget;
		TIMING_MONEY = budget;
		for (int i = 0; i < 14; i++) {
			money[i] = scan.nextInt();
		}
	}

	static void calculateBnp(int idx) {
		if (idx >= 14 || BNP_MONEY <= 0)
			return;

		int buyCnt = BNP_MONEY / money[idx];
		if (buyCnt > 0) {
			BNP_CNT += buyCnt;
			BNP_MONEY = (BNP_MONEY % money[idx]);
		}
		calculateBnp(idx + 1);
	}

	static void calculateTiming() {
		int decreaseCnt = 0, increaseCnt = 0;
		for (int i = 1; i < 14; i++) {
			if (decreaseCnt == 2 && TIMING_MONEY / money[i] > 0) { // 전량 매수
				TIMING_CNT += (TIMING_MONEY / money[i]);
				TIMING_MONEY = (TIMING_MONEY % money[i]);

				decreaseCnt = 0;
				increaseCnt = 0;
			} else if (increaseCnt == 2 && TIMING_CNT > 0) { // 전량 매도
				int profit = TIMING_CNT * money[i];
				TIMING_CNT = 0;
				TIMING_MONEY += profit;

				decreaseCnt = 0;
				increaseCnt = 0;
			}

			if (money[i] < money[i-1]) {
				decreaseCnt++;
				increaseCnt = 0;
			} else if (money[i] > money[i-1]) {
				increaseCnt++;
				decreaseCnt = 0;
			}
		}
	}

	public static void main(String[] args) {
		input();
		calculateBnp(0);
		calculateTiming();

		// print result
		int bnpResult = BNP_MONEY + BNP_CNT * money[13];
		int timingResult = TIMING_MONEY + TIMING_CNT * money[13];

		if (bnpResult > timingResult)
			sb.append("BNP");
		else if(timingResult > bnpResult)
			sb.append("TIMING");
		else
			sb.append("SAMESAME");

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
	}
}