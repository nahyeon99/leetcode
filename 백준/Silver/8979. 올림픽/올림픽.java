import java.io.*;
import java.util.*;

public class Main {

	static FastReader sc = new FastReader();
	static int N, K;
	static ArrayList<Result> list = new ArrayList<>();
	static int end_point = 0; // 정렬 후 k번째 국가의 위치를 알기 위한 것

	public static void main(String[] args) throws IOException {

		int[] t = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		N = t[0]; // 국가의 수
		K = t[1]; // 등수를 알고 싶은 국가

		for (int i = 0; i < N; i++) {
			int[] tt = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int country = tt[0];
			int gold = tt[1];
			int silver = tt[2];
			int bronze = tt[3];
			list.add(new Result(country, gold, silver, bronze, 0));
		}
		Collections.sort(list);

		list.get(0).rate = 1; // 정렬을 했으니 리스트의 첫번째 국가는 무조건 1등이다

		for (int i = 1; i < list.size(); i++) {
			int tmp_gold = list.get(i - 1).gold;
			int tmp_silver = list.get(i - 1).silver;
			int tmp_bronze = list.get(i - 1).bronze;
			Result now = list.get(i);
			if (list.get(i).country == K) {  // 국가의 번호가 k번이면 end_point를 찾고 마지막 정답 출력 할 때 사용
				end_point = i;
			}
			if (now.gold == tmp_gold && now.silver == tmp_silver && now.bronze == tmp_bronze) {
				list.get(i).rate = list.get(i - 1).rate;
			} else {
				list.get(i).rate = i + 1;
			}
		}

		System.out.println(list.get(end_point).rate);
	}

	static class FastReader {
		BufferedReader br;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
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

class Result implements Comparable<Result> {
	int country, gold, silver, bronze, rate;

	Result(int country, int gold, int silver, int bronze, int rate) {
		this.country = country;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
		this.rate = rate;
	}

	public int compareTo(Result o) {
		if (this.gold == o.gold) {
			if (this.silver == o.silver) {
				return o.bronze - this.bronze;
			}
			return o.silver - this.silver;
		}
		return o.gold - this.gold;
	}
}