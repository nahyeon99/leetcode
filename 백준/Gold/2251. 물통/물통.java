import java.io.*;
import java.util.*;

public class Main {

	static FastReader sc = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int[] limit;
	static boolean[] possible;
	static boolean[][][] visited;

	static void input() {
		limit = new int[3];
		for (int i = 0; i < 3; i++) {
			limit[i] = sc.nextInt();
			visited = new boolean[205][205][205];
			possible = new boolean[205];
		}
	}

	static void pro() {
		bfs(0, 0, limit[2]);
		for (int i = 0; i <= 200; i++) {
			if (possible[i])
				sb.append(i).append(' ');
		}
		System.out.println(sb);
	}

	// 물통 탐색 시작~
	static void bfs(int x1, int x2, int x3) {

		Queue<State> queue = new LinkedList<>();

		queue.add(new State(new int[] {x1, x2, x3}));
		visited[x1][x2][x3] = true;

		while (!queue.isEmpty()) {
			State currNode = queue.poll();
			if (currNode.X[0] == 0)
				possible[currNode.X[2]] = true;

			for (int from = 0; from < 3; from++) {
				for (int to = 0; to < 3; to++) {
					if (from == to)
						continue;

					// i번 물통에서 j번 물통으로 물을 옮긴다.
					State next = currNode.move(from, to, limit);

					// 만약 바뀐 상태를 탐색한 적이 없다면
					if (!visited[next.X[0]][next.X[1]][next.X[2]]) {
						visited[next.X[0]][next.X[1]][next.X[2]] = true;
						queue.add(next);
					}
				}
			}

		}
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

// 물통의 현재 상태와 물을 붓는 행위를 관리하는 구조체
class State {
	int[] X;

	State(int[] _X) {
		X = new int[3];
		for (int i = 0; i < 3; i++)
			X[i] = _X[i];
	}

	State move(int from, int to, int[] limit) {
		int[] nx = new int[] {X[0], X[1], X[2]};

		// 만약 from을 전부 부을 수 있다면
		if (X[from] + X[to] <= limit[to]) {
			nx[to] = nx[from] + nx[to];
			nx[from] = 0;
		} else { // from의 일부만 옮길 수 있다면
			nx[from] -= (limit[to] - nx[to]);
			nx[to] = limit[to];
		}
		return new State(nx);
	}
}