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

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("");
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    private Node get_node(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("");
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }

    public int indexOf(int value) {
        if (!isEmpty()) {
            Node current = head;
            for (int i = 0; i < this.size; i++) {
                if (current.data == value) {
                    return i;
                } else {
                    current = current.next;
                }
            }
        }
        throw new NullPointerException("Can't loop through an empty list!");
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
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean contains(int value) {
        if (!isEmpty()) {
            Node current = head;
            for (int i = 0; i < this.size; i++) {
                if (current.data == value) {
                    return true;
                } else {
                    current = current.next;
                }
            }
        }
        return false;
    }

    public LinkedList deduplicate() {
        LinkedList new_list = new LinkedList();

        Node current = head;

        for (int i = 0; i < this.size; i++) {
            if (!new_list.contains(current.data)) {
                new_list.add(current.data);
            }
            current = current.next;
        }

        return new_list;
    }

    public LinkedList rotate(int positions) {
        int index = size - positions;

        LinkedList new_list = new LinkedList();

        Node current = this.get_node(index);
        for (int i = 0; i < positions; i++) {
            new_list.add(current.data);
            current = current.next;
        }
        current = head;
        for (int i = 0; i < index; i++) {
            new_list.add(current.data);
            current = current.next;
        }

        return new_list;
    }

    public void join(LinkedList other) {
        Node current = head;
        for (int i = 0; i < this.size; i++) {
            current = current.next;
            if (current.next == null) {
                current.next = other.head;
            }
        }
        size += other.size;
    }
}
