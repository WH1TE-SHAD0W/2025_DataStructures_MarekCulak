import datastructures.ArrayList;
import datastructures.LinkedList;
import performance.PerformanceMeasurement;

public class main {
    public void displayList(LinkedList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println();
    }
    public void displayList(ArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println();
    }
    void main() {
        double start = System.nanoTime();
        ArrayList list = PerformanceMeasurement.randomArrayList(20000000, 8);
        double finish = System.nanoTime();
        double timing = finish - start;
        double elapsedSeconds = (finish - start) / 1_000_000_000.0;
        System.out.println(timing+" nanoseconds, which is in seconds: "+elapsedSeconds);

//        displayList(list);

    }
}
