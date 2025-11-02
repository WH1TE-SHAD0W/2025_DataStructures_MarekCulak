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
     * @return integer of the length
     */
    public int size() {
        return this.size;
    }

    /**
     * Gives out once the requested index of something in the list is out of range
     * @param index, the index of this list to verify its existence
     * @throws IndexOutOfBoundsException, stops the program before accessing the wrong index.
     */
    private void validateOutOfRange(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Loop out of range!");
        }
    }

    /**
     * Validation method to give out if the list is null and would have get accessed data
     * @param message, that would say the usage for better traceability
     * @throws NullPointerException, gives out about empty list
     */
    private void validateNull(String message) {
        if (isEmpty()) {
            throw new NullPointerException(message);
        }
    }

    /**
     * Validation method to give out if the list is null and would have get accessed data
     * this if an override, so it wouldn't need the input.
     * @throws NullPointerException, gives out about empty list
     */
    private void validateNull() {
        if (isEmpty()) {
            throw new NullPointerException("The list is empty, can't iterate any element.");
        }
    }

    /**
     * Method to retrieve the data at a specific index
     * @param index, at which to look for the value
     * @return String the value the Node holds
     * @throws IndexOutOfBoundsException if requested value from a Node that is out of the list range
     */
    public String get(int index) {
        validateOutOfRange(index);

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    /**
     * Retrieves the actual object Node at an index
     * @param index, position at the list
     * @return the Node object
     * @throws IndexOutOfBoundsException if requested a node that is not the list size
     */
    private Node get_node(int index) {
        validateOutOfRange(index);

        if (index == 0) {
            return head;
        } else if (index == size) {
            return tail;
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
     * @return integer, the index of the Node otherwise -1 if not found
     * @throws NullPointerException once requested a position and the list is empty
     */
    public int indexOf(String value) {
        validateNull();
        Node current = head;
        for (int i = 0; i < this.size; i++) {
            if (current.data.equals(value)) {
                return i;
            } else {
                current = current.next;
            }
        }
        return -1;
    }

    /**
     * "Appends" the List by creating a node at the end with the given value.
     * @param value, to add to the end
     */
    public void add(String value) {
        Node newNode = new Node(value);

        if (head == null || tail == null) {
            head = newNode;
        }

        else {
            tail.next = newNode;
        }
        tail = newNode;

        size++;
    }

    /**
     * Adds a new Node at the given index to LinkedList
     * @param index, at which it is created
     * @param value, that the Node holds
     * @throws IndexOutOfBoundsException if the index is set to add it out of list size
     */
    public void add(int index, String value) {
        validateOutOfRange(index);

        Node newNode = new Node(value);

        Node node = get_node(index);
        newNode.next = node.next;
        node.next = newNode;

        size++;
    }

    /**
     * Sets the given value to the Node that sits at the given index
     * @param index of the Node
     * @param value to set in the Node
     * @return value that was deleted
     * @throws NullPointerException if the list is empty and tried to set an element
     * @throws IndexOutOfBoundsException as if tried to set an element that is not there
     */
    public String set(int index, String value) {
        validateNull();
        validateOutOfRange(index);

        Node node = get_node(index);
        String old_value = node.data;
        node.data = value;

        return old_value;
    }

    /**
     * Removes the node at the given index
     * @param index, the value to delete
     * @return the deleted value if not found, gives the not found string
     * @throws NullPointerException once tried to remove from an empty list
     * @throws IndexOutOfBoundsException if tried to remove an element that is not inside of the list.
     */
    public String remove(int index) {
        validateNull();
        validateOutOfRange(index);

        if (index == size) {
            Node node = get_node(index-1);
            String return_value = node.next.data;
            node.next = null;
            tail = node;
            size--;
            return return_value;
        }
        if (index == 0) {
            String return_value = head.data;
            head = head.next;
            size--;
            return return_value;
        }

        Node node = get_node(index);
        String return_value = node.next.data;
        node.next = node.next.next;
        size--;
        return return_value;
    }

    /**
     * Removes all Nodes in the List that contains the value inserted
     * @param value to remove from list
     * @return boolean whether any of the Nodes got removed
     * @throws NullPointerException if tried to remove anything from the empty list
     */
    public boolean removeAll(String value) {
        validateNull();

        boolean removed_any = false;
        Node current = this.head;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(value)) {
                remove(i);
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
        tail = null;
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
     * @return the deduplicated List
     * @throws NullPointerException if engaged to deduplicate an empty list
     */
    public LinkedList deduplicate() {
        validateNull();
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
     * @return the rotated list
     * @throws NullPointerException if the list data is null
     */
    public LinkedList rotate(int positions) {
        validateNull();

        // normalizes the index rotation number, handles multiples and negative
        positions = ((positions % size) + size) % size;

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
        tail.next = other.head;
        tail = other.tail;
        size += other.size;
    }
}
