package datastructures;

public class LinkedList {
    private int size;
    private Node head;
    private Node tail;

    public LinkedList() {
        this.size = 0;
    }

    private static class Node {
        private Node next;
        private int data;

        public Node(int data) {
            this.next = null;
            this.data = data;
        }
    }

    public int size() {
        return this.size;
    }

    public String get(int index) {
        return "";
    }

    public int indexOf(String s) {
        return 0;
    }

    public void add(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        }
        else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void add(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("");
        }

        Node newNode = new Node(value);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
        }

        size++;
    }

    public String set(String element, int index) {
        String replaced_element = "";
        return replaced_element;
    }

    public String remove(int index) {
        String removed_element = "";
        return removed_element;
    }

    public boolean removeAll(String element) {
        return true;
    }

    public void clear() {

    }

    public LinkedList deduplicate() {
        LinkedList deduplicated_list = new LinkedList();
        return deduplicated_list;
    }

    public void rotate() {

    }

    public void join () {

    }
}
