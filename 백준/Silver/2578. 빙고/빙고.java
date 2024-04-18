import java.io.*;
import java.util.*;

public class Main {

	static FastReader sc = new FastReader();

	static List<int[]> BINGO = new ArrayList<>(5);
	static boolean[][] match = new boolean[5][5];
	static int bingoCnt = 0;

	public static void main(String[] args) throws IOException {

		// 철수의 빙고판을 입력 받는다.
		for (int i = 0; i < 5; i++) {
			int[] lineNumbers = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			BINGO.add(lineNumbers);
		}

		// 사회자의 호출과 비교한다.
		for (int i = 1; i <= 25; i++) {
			int num = sc.nextInt();
			circleNum(num, i > 4);

			if (bingoCnt >= 3) {
				System.out.println(i);
				return;
			}
		}
	}

	static void circleNum(int num, boolean checkFlag) {
		loop:
		for (int row = 0; row < 5; row++) {
			for (int col = 0; col < 5; col++) {
				if (BINGO.get(row)[col] == num) {
					match[row][col] = true;
					if (checkFlag)
						checkBingo(row, col);
					break loop;
				}
			}
		}
	}

	// 가로, 세로, 왼쪽 대각선, 오른쪽 대각선을 체크한다.
	static void checkBingo(int row, int col) {
		if (checkRow(row))
			bingoCnt++;

		if (checkCol(col))
			bingoCnt++;

		if (checkRightTopToLeftBottomCross(row, col))
			bingoCnt++;

		if (checkLeftTopToRightBottomCross(row, col))
			bingoCnt++;

	}

	static boolean checkRow(int row) {
		boolean result = true;
		for (int col = 0; col < 5; col++) {
			if (!match[row][col])
				result = false;
		}
		return result;
	}

	static boolean checkCol(int col) {
		boolean result = true;
		for (int row = 0; row < 5; row++) {
			if (!match[row][col])
				result = false;
		}
		return result;
	}

	static boolean checkRightTopToLeftBottomCross(int row, int col) {
		boolean containNum = false;
		int bingoCnt = 0;

		for (int r = 0; r < 5; r++) {
			int c = 4 - r;

			if (row == r && col == c)
				containNum = true;
			if (match[r][c])
				bingoCnt++;
		}

		return containNum && bingoCnt == 5;
	}

	static boolean checkLeftTopToRightBottomCross(int row, int col) {
		boolean containNum = false;
		int bingoCnt = 0;

		for (int r = 0; r < 5; r++) {

			if (row == r && col == r)
				containNum = true;
			if (match[r][r])
				bingoCnt++;
		}

		return containNum && bingoCnt == 5;
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
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