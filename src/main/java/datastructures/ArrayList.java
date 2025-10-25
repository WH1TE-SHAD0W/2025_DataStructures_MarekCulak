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

    public String get(int index) {
        return "";
    }

    public int indexOf(String s) {
        return 0;
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
