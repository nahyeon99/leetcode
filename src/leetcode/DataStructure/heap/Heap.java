package leetcode.DataStructure.heap;

public class Heap {

    private int[] array;
    private int n; // number of items

    public Heap(int capacity) {
        this.array = new int[capacity];
        this.n = 0;
    }

    public void push(int k) {
        if (n == array.length)
            throw new RuntimeException("Heap Overflow");

        array[n] = k;
        bubbleUp(n); // Heap의 맨 마지막 요소인 array[n]부터 bubble up
        n++;
    }

    /**
     * array[i]에서부터 시작해서 부모인 array[(i-1)/2]를 기준으로 하는 서브 트리가
     * Heap을 만족하도록 조정하면서 올라갑니다.
     *
     * @param i
     */
    private void bubbleUp(int i) {
        int child = i;
        int parent = (i - 1) / 2;

        if (parent >= 0 && array[child] > array[parent]) {
            int tmp = array[child];
            array[child] = array[parent];
            array[parent] = tmp;
            bubbleUp(parent);
        }
    }

    /**
     * Heap 에서 최대 값을 반환하고 삭제합니다.
     */
    public int pop() {
        if (n == 0)
            throw new RuntimeException("Heap Underflow");

        int max = array[0];
        array[0] = array[n - 1];
        n--;
        bubbleDown(0);
        return max;
    }

    /**
     * array[i]를 루트(root)로 하는 서브 트리 array[i, i+1, .., n-1] 범위 내에서
     * 힙 특성을 만족하도록 조정하면서 leaf 노드까지 내려갑니다.
     *
     * @param i
     */
    private void bubbleDown(int i) {
        int child = 2 * i + 1; // default: left child
        int rightChild = 2 * i + 2;

        if (child < n) {
            // Determine the larger child
            if (rightChild < n && array[rightChild] > array[child])
                child = rightChild;

            // If the parent is smaller than larger child, swap & bubbleDown
            if (array[i] < array[child]) {
                int tmp = array[i];
                array[i] = array[child];
                array[child] = tmp;

                bubbleDown(child);
            }
        }
    }

    /**
     * 리프노드의 가장 작은 서브트리부터 거슬러 올라가 모든 서브트리를 heapify() 합니다.
     */
    public void Heapify() {
        // array[n-1] -> array[n-2] -> ... -> array[0]
        for (int i = (n - 2) / 2; i >= 0; i--) {
            bubbleDown(i);
        }
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public static void main(String[] args) {
        Heap heap = new Heap(20);

        heap.push(20);
        heap.push(4);
        heap.push(8);
        heap.push(10);
        heap.push(5);
        heap.push(7);
        heap.push(6);
        heap.push(2);
        heap.push(9);
        heap.push(1);

        System.out.println("Values in max order:");

        while (!heap.isEmpty()) {
            System.out.println("heap = " + heap.pop());
        }
    }
}
