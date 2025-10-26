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
        private String data;

        public Node(String data) {
            this.next = null;
            this.data = data;
        }
    }

    public int size() {
        return this.size;
    }

    public String get(int index) {
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

    public int indexOf(String value) {
        if (!isEmpty()) {
            Node current = head;
            for (int i = 0; i < this.size; i++) {
                if (current.data.equals(value)) {
                    return i;
                } else {
                    current = current.next;
                }
            }
        }
        throw new NullPointerException("Can't loop through an empty list!");
    }

    public void add(String value) {
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

    public void add(int index, String value) {
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

    public String set(int index, String value) {
        if (isEmpty()) {
            throw new NullPointerException("Can't loop through an empty list!");
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("");
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        String old_value = current.data;
        current.data = value;

        return old_value;
    }

    public String remove(String value) {
        Node current = head;
        if (current.data.equals(value)) {
            String return_value = current.data;
            head = head.next;
            return return_value;
        }
        for (int i = 0; i < this.size; i++) {
            if (current.next == null) {
                return value;
            }
            if (current.next.data.equals(value)) {
                String return_value = current.next.data;
                current.next = current.next.next;
                size--;
                return return_value;
            }
            current = current.next;
        }
        return value;
    }

    public boolean removeAll(String value) {
        boolean removed_any = false;
        Node current = this.head;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(value)) {
                remove(value);
            }
            current = current.next;
        }
        return false;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean contains(String value) {
        if (!isEmpty()) {
            Node current = head;
            for (int i = 0; i < this.size; i++) {
                if (current.data.equals(value)) {
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
