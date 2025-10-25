package datastructures;

public class ArrayList {
    private String[] data;
    private int size;

    /**
     * Constructor of the ArrayList
     */
    public ArrayList() {
        data = new String[10];
        size = 0;
    }

    /**
     * Returns the size of the data in the array
     * @return int size, returns the size of data
     */
    public int size() {
        return size;
    }

    /**
     * Returns value of a specified index position in data of the list
     * @param index, the index from which to retrieve the value
     * @return String value, returns the actual value retrieved from the index
     * @throws IndexOutOfBoundsException if parameter index out of range of the size of this array
     */
    public String get(int index) {
        validateOutOfRange(index);
        return data[index];
    }

    /**
     * Throws exception if the index int is not in range of size
     * @param index, the index to validate
     * @throws IndexOutOfBoundsException if out of range
     */
    private void validateOutOfRange(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range.");
        }
    }


    /**
     * Returns first found index of input element
     * @param element, the value to look for
     * @return index of the element, if the element doesn't exist in the array, -1 will be returned
     */
    public int indexOf(String element) {
        for (int i = 0; i < data.length; i++){
            if (element.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    public void add(String element) {

    }

    public void add(String element, int index) {

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

    public ArrayList deduplicate() {
        ArrayList deduplicated_list = new ArrayList();
        return deduplicated_list;
    }

    public void rotate() {

    }

    public void join () {

    }
}
