package leetcode.DataStructure.LinkedList;

public class SinglyLinkedList<E> {

    private leetcode.DataStructure.LinkedList.Node<E> head;
    private leetcode.DataStructure.LinkedList.Node<E> tail;
    private int size = 0;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Inserts the specified element at the beginning of this list.
     *
     * @param data the element to add
     */
    public void addFirst(E data) {

        leetcode.DataStructure.LinkedList.Node node = new leetcode.DataStructure.LinkedList.Node(data);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param data the element to add
     */
    public void addLast(E data) {

        leetcode.DataStructure.LinkedList.Node node = new leetcode.DataStructure.LinkedList.Node(data);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void print() {

        leetcode.DataStructure.LinkedList.Node<E> currNode = head;

        if (currNode == null)
            System.out.println("empty list");

        while (currNode != null) {
            System.out.println(currNode.data);
            currNode = currNode.next;
        }
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param data element to be inserted
     * @throws IndexOutOfBoundsException
     */
    public void add(int index, E data) {

        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        if (index == size)
            addLast(data);
        else if (index == 0)
            addFirst(data);
        else {
            leetcode.DataStructure.LinkedList.Node<E> prevNode = getNode(index - 1);
            leetcode.DataStructure.LinkedList.Node<E> newNode = new leetcode.DataStructure.LinkedList.Node<>(data);
            newNode.next = prevNode.next;
            prevNode.next = newNode;
        }
        size++;
    }

    /**
     * Returns the Node at the specified element index.
     *
     * @param index
     * @return the node at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    private leetcode.DataStructure.LinkedList.Node<E> getNode(int index) {

        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        leetcode.DataStructure.LinkedList.Node<E> currNode = head;
        for (int i = 0; i < index; i++) {
            currNode = currNode.next;
        }
        return currNode;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    public E get(int index) {
        return getNode(index).data;
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index   index of the element to replace
     * @param e element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException
     */
    public E set(int index, E e) {
        leetcode.DataStructure.LinkedList.Node<E> currNode = getNode(index);
        E prevData = currNode.data;
        currNode.data = e;

        return prevData;
    }

    /**
     * Removes the element at the specified position in this list.  Shifts any
     * subsequent elements to the left (subtracts one from their indices).
     * Returns the element that was removed from the list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException
     */
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        leetcode.DataStructure.LinkedList.Node<E> currNode = null;

        if (index == 0) {
            currNode = head;
            head = head.next;
        } else if (index == size - 1) {
            leetcode.DataStructure.LinkedList.Node<E> prevNode = getNode(index - 1);
            currNode = prevNode.next;
            tail = prevNode;
        } else {
            leetcode.DataStructure.LinkedList.Node<E> prevNode = getNode(index - 1);
            currNode = prevNode.next;
            prevNode.next = currNode.next;
        }
        return currNode.data;
    }

    public static void main(String[] args) {
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();

        linkedList.addFirst("A");
        linkedList.addFirst("A-");
        linkedList.addLast("A+");
        linkedList.print(); // (0) A-, (1) A, (2) A+

        leetcode.DataStructure.LinkedList.Node<String> node = linkedList.getNode(2);
        System.out.println("node = " + node.data);

        linkedList.add(0, "N"); // (0) N, (1) A-, (2) A, (3) A+
        linkedList.add(2, "P"); // (0) N, (1) A-, (2) P, (3) A, (4) A+
        linkedList.add(5, "Q"); // (0) N, (1) A-, (2) P, (3) A, (4) A+, (5) Q

        System.out.println(" ======================== ");
        linkedList.print();

        System.out.println(" ======================== ");
        linkedList.set(5, "New Q");
        linkedList.set(0, "New N");
        linkedList.print();

        System.out.println(" ======================== ");
        String remove1 = linkedList.remove(5);
        String remove2 = linkedList.remove(3);
        String remove3 = linkedList.remove(0);
        linkedList.print();
    }
}
