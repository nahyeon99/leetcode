package MinStack;

import java.util.ArrayList;

class MinStack {

    class Node {
        private int value;
        private int minValue;

        public Node(int value, int minValue) {
            this.value = value;
            this.minValue = minValue;
        }
    }

    private ArrayList<Node> stack;
    private int capacity;

    public MinStack() {
        stack = new ArrayList<>();
        capacity = 0;
    }

    public void push(int val) {

        if (capacity < 1) {
            Node newNode = new Node(val, val);
            stack.add(newNode);

        } else {
            Node prevNode = stack.get(capacity - 1);
            int minVal = Integer.min(prevNode.minValue, val);
            Node newNode = new Node(val, minVal);
            stack.add(newNode);
        }

        capacity++;
    }

    public void pop() {
        if (isEmpty())
            throw new RuntimeException("Stack Empty Exception");

        stack.remove(capacity - 1);
        capacity--;
    }

    public int top() {
        if (isEmpty())
            throw new RuntimeException("Stack Empty Exception");
        return this.stack.get(capacity - 1).value;
    }

    public int getMin() {
        if (isEmpty())
            throw new RuntimeException("Stack Empty Exception");
        return this.stack.get(capacity - 1).minValue;
    }

    private boolean isEmpty() {
        if (capacity < 1)
            return true;
        return false;
    }
}