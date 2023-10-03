package boj.q17298_오큰수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] arr, result;

    static void input() {
        N = scan.nextInt();
        arr = new int[N];
        result = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scan.nextInt();
        }
    }

    static void pro() {

        Stack<Integer> myStack = new Stack<>();
        myStack.push(0);

        for (int i = 1; i < N; i++) {

            while (!myStack.isEmpty() && arr[myStack.peek()] < arr[i]) {
                result[myStack.pop()] = arr[i];
            }
            myStack.push(i);
        }

        while (!myStack.isEmpty()) {
            result[myStack.pop()] = -1;
        }

        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(' ');
        }

        System.out.println(sb);
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
