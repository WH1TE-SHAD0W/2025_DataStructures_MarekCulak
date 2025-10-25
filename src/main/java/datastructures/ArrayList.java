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

    /**
     * Verifies the capacity of the array, if it is equal to the size (its full) make the capacity doubled
     * Doesn't take in any parameter nor returns any variable
     */
    private void ensureCapacity() {
        if (size == data.length) {
            String[] tmp = new String[data.length * 2];
            System.arraycopy(data, 0, tmp, 0, data.length);
            data = tmp;
        }
    }

    /**
     * Verifies if the input is null, throws an exception. Used in methods where the null input is not accepted.
     * @throws NullPointerException if null input
     */
    private void validateNotNull(String input) {
        if (input == null) {
            throw new NullPointerException("Null input is not accepted.");
        }
    }

    /**
     * Takes in an element to be added to the list, adds it to end
     * @param element, the element to add to the list
     * @throws NullPointerException if null input
     */
    public void add(String element) {
        validateNotNull(element);
        ensureCapacity();

        data[size] = element;
        size++;
    }

    /**
     * Takes in an element to be added to the list, adds it to the index.
     * Puts the element at the index than pushes all elements forward.
     * @param element, the element to add to the list
     * @param index, index at which the element should be added
     * @throws NullPointerException if null input
     */
    public void add(String element, int index) {
        validateNotNull(element);
        ensureCapacity();

        String tmp = "";
        String swap = data[index];
        data[index] = element;

        for (int i = index+1; i < size+1; i++) {
            tmp = data[i];
            data[i] = swap;
            swap = tmp;
        }

        size++;
    }

    /**
     * Takes in an element to be set at the specified index,
     * validates the element taken is not Null and returns a buffered value that was previously set.
     * @param element, the element to set in the list
     * @param index, index at which the element should be set
     * @return replaced_element, returns the value which was replaced from the array
     * @throws NullPointerException if null input
     */
    public String set(String element, int index) {
        validateNotNull(element);

        String replaced_element = data[index];
        data[index] = element;
        return replaced_element;
    }

    /**
     * Takes in an integer index at which the value should be removed from the list
     * @param index, at which the String should be removed
     * @return removed_element, returns the value which was removed
     */
    public String remove(int index) {
        validateOutOfRange(index);

        String removed_element = data[index];

        for (int i = index; i < size-1; i++) {
            data[i] = data[i+1];
        }
        size--;

        return removed_element;
    }

    /**
     * Takes in the element to be removed, iterates through the list and calls this.remove by the index.
     * @param element, the value of the elements to remove from the list
     * @return bool based on the fact if any has been removed, gets set at all removes to true
     */
    public boolean removeAll(String element) {
        boolean removed_any = false;
        for (int i = 0; i < data.length; i++) {
            if (element.equals(data[i])) {
                this.remove(i);
                removed_any = true;
            }
        }
        return removed_any;
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
