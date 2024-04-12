import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static FastReader sc = new FastReader();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N1 = sc.nextInt();
		int N2 = sc.nextInt();

		// 개미 입력 받기
		List<Ant> ants = new ArrayList<>();
		String group1 = sc.nextLine();
		for (int i = group1.length() - 1; i >= 0; i--) {
			ants.add(new Ant(group1.charAt(i), 1));
		}
		String group2 = sc.nextLine();
		for (int i = 0; i < group2.length(); i++) {
			ants.add(new Ant(group2.charAt(i), 2));
		}
		int T = sc.nextInt();

		// 개미 이동 시작
		while (T-- > 0) {
			for (int i = 0; i < ants.size() - 1; i++) {
				Ant curr = ants.get(i);
				Ant next = ants.get(i + 1);

				if (curr.dir != 2 && curr.dir != next.dir) { // 다음 개미가 나랑 방향 다르면 바꿔준다.
					ants.set(i, next);
					ants.set(i + 1, curr);
					i++;
				}
			}
		}

		for (int i = 0; i < ants.size(); i++) {
			sb.append(ants.get(i).data);
		}

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

class Ant {
	char data;
	int dir;

	public Ant(char data, int dir) {
		this.data = data;
		this.dir = dir;
	}
}