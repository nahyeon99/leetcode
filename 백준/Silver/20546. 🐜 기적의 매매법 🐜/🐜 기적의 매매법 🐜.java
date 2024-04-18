import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static FastReader sc = new FastReader();

	static int BNPMoney, BNPShareCnt, timingMoney, timingShareCnt = 0;
	static List<Integer> stock;

	public static void main(String[] args) throws IOException {
		int money = sc.nextInt();
		BNPMoney = money;
		timingMoney = money;

		stock = new ArrayList<>(14);

		int[] stockList = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		for (int i = 0; i < 14; i++) {
			stock.add(stockList[i]);
		}

		calculateBnp();
		calculateTiming();

		System.out.println(match());
	}

	static void calculateBnp() {
		for (int i = 0; i < stock.size(); i++) {
			if (BNPMoney >= stock.get(i)) {
				int buyCnt = BNPMoney / stock.get(i);
				BNPShareCnt += buyCnt;
				BNPMoney -= buyCnt * stock.get(i);

				if (BNPMoney <= 0) {
					break;
				}
			}
		}
	}

	static void calculateTiming() {
		for (int day = 3; day < stock.size(); day++) {
			boolean buyCond = buy(day);
			if (!buyCond) {
				sell(day);
			}
		}
	}

	// 3일 연속 가격이 전일 대비 하락한다면, 전량 매수한다.
	static boolean buy(int day) {

		int dayBefore3 = stock.get(day - 3);
		int dayBefore2 = stock.get(day - 2);
		int dayBefore1 = stock.get(day - 1);
		int today = stock.get(day);

		if (dayBefore3 > dayBefore2 && dayBefore2 > dayBefore1 && dayBefore1 > today) {
			int buyCnt = timingMoney / stock.get(day);
			timingShareCnt += buyCnt;
			timingMoney -= buyCnt * stock.get(day);
			return true;
		}
		return false;
	}

	// 3일 연속 가격이 전일 대비 상승한다면, 전량 매도한다.
	static void sell(int day) {

		int dayBefore3 = stock.get(day - 3);
		int dayBefore2 = stock.get(day - 2);
		int dayBefore1 = stock.get(day - 1);
		int today = stock.get(day);

		if (dayBefore3 < dayBefore2 && dayBefore2 < dayBefore1 && dayBefore1 < today) {
			timingMoney += timingShareCnt * stock.get(day);
			timingShareCnt = 0;
		}
	}

	static String match() {
		int BNPResult = BNPMoney + BNPShareCnt * stock.get(stock.size() - 1);
		int timingResult = timingMoney + timingShareCnt * stock.get(stock.size() - 1);

		if (BNPResult == timingResult)
			return "SAMESAME";
		else if (BNPResult > timingResult)
			return "BNP";
		else
			return "TIMING";
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