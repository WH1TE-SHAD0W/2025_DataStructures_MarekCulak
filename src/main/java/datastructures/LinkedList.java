package datastructures;

public class LinkedList {
    private int size;
    private Node head;
    private Node tail;

    /**
     * Constructor of the LinkedList
     */
    public LinkedList() {
        this.size = 0;
    }

    /**
     * Class inside a class to define instances of each indexed element
     */
    private static class Node {
        private Node next;
        private String data;

        /**
         * Constructor
         * @param data, value to hold inside the Node upon creation
         */
        public Node(String data) {
            this.next = null;
            this.data = data;
        }
    }

    /**
     * Method to return the size of the List
     * @return, integer of the length
     */
    public int size() {
        return this.size;
    }

    /**
     * Method to retrieve the data at a specific index
     * @param index, at which to look for the value
     * @return, String the value the Node holds
     */
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

    /**
     * Retrieves the actual object Node at an index
     * @param index, position at the list
     * @return, the Node object
     */
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

    /**
     * Once the value is known, the index can be found with this. First ever Node that holds it will be returned.
     * @param value, String to look for
     * @return, integer, the index of the Node
     */
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

    /**
     * "Appends" the List by creating a node at the end with the given value.
     * @param value, to add to the end
     */
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

    /**
     * Adds a new Node at the given index to LinkedList
     * @param index, at which it is created
     * @param value, that the Node holds
     */
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

    /**
     * Sets the given value to the Node that sits at the given index
     * @param index of the Node
     * @param value to set in the Node
     * @return value that was deleted
     */
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

    /**
     * Removes first found Node that has the value by redirecting the pointer to the next Node
     * @param value, the value to delete
     * @returns the deleted value if not found, gives the not found string
     */
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
        return "not found";
    }

    /**
     * Removes all Nodes in the List that contains the value inserted
     * @param value to remove from list
     * @return boolean whether any of the Nodes got removed
     */
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

    /**
     * Clear the whole List to original state => null the head
     */
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Verifies if the List holds any value
     * @return boolean whether it has anything in it
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Verifies if the value given is inside the List
     * @param value to check in
     * @return boolean based on the fact if it is in it or not
     */
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

    /**
     * Deduplicates the whole List by creating a new one and running method contains
     * to verify if it would be added in or not
     * @returns the deduplicated List
     */
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

    /**
     * Rotates the List by creating anew one and assigning all Nodes there by
     * starting from the given position
     * @param positions the int by how many indexes should it be rotated
     * @returns the rotated list
     */
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

    /**
     * Attaches the given List to this one
     * @param other, the List to attach at the end
     */
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
