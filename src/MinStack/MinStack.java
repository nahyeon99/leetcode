package MinStack;

class MinStack {

    private Node top;
    private Node min;

    class Node {
        private int value;
        private Node next;

        public Node(int val) {
            this.value = val;
            this.next = null;
        }

        public Node(int val, Node next) {
            this.value = val;
            this.next = next;
        }
    }

    public MinStack() {
        top = null;
        min = null;
    }

    public void push(int val) {
        Node newNode = new Node(val);
        if (top == null) {
            this.top = newNode;
            this.min = newNode;
        }
        else {
            newNode.next = this.top;
            this.top = newNode;

            if (this.top.value < this.min.value)
                this.min = this.top;
        }
    }

    public void pop() {
        if (top == null)
            throw new RuntimeException("Stack Empty Exception");

        Node removeNode = this.top;
        this.top = this.top.next;

        if (removeNode == this.min && this.top != null) {
            this.min = this.top;
            Node nd = this.top.next;
            while (nd != null) {
                if (nd.value < this.min.value)
                    this.min = nd;
                nd = nd.next;
            }
        }
    }

    public int top() {
        if (top == null)
            throw new RuntimeException("Stack Empty Exception");
        return this.top.value;
    }

    public int getMin() {
        if (top == null)
            throw new RuntimeException("Stack Empty Exception");
        return this.min.value;
    }
}