import datastructures.ArrayList;
import datastructures.LinkedList;
import performance.PerformanceMeasurement;

import java.util.Arrays;
import java.util.Random;

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
        double[][] result1 = PerformanceMeasurement.PerformanceAdd.performanceAdd();
        System.out.println(Arrays.deepToString(result1));

        double[][] result2 = PerformanceMeasurement.PerformanceGet.performanceGet();
        System.out.println(Arrays.deepToString(result2));

        double[][] result = PerformanceMeasurement.PerformanceRemove.performanceRemove();
        System.out.println(Arrays.deepToString(result));
    }
}
