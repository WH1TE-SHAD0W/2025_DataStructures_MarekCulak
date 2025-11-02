package performance;

import datastructures.ArrayList;
import datastructures.LinkedList;

import java.util.Arrays;
import java.util.Random;

public class PerformanceMeasurement {
    /**
     * Method for testing out the performance of requested method on a given list.
     * @param list, the list taken in to tets on
     * @param method, requested method on which to test
     * @return time in nanoseconds
     */
    public static double timed(ArrayList list, String method) {
        double start = 0;
        double finish = 0;
        Random random = new Random();
        int random_int = random.nextInt(list.size());
        start = System.nanoTime();
        switch (method) {
            case "Add":
                list.add(utils.Random.randomString(16));
            case "Get":
                list.get(random_int);
            case "Remove":
                list.remove(random_int);
        }
        finish = System.nanoTime();
        double timing = finish - start;
        double elapsedSeconds = (finish - start) / 1_000_000_000.0;
        System.out.println(timing+" nanoseconds, which is in seconds: "+elapsedSeconds);
        return timing;
    }

    /**
     * An override method for testing out the performance of requested method on a given list with the specified index.
     * @param list, the list taken in to tets on
     * @param index, the index which is used for all methods
     * @param method, requested method on which to test
     * @return time in nanoseconds
     */
    public static double timed(ArrayList list, String method, int index) {
        double start = 0;
        double finish = 0;
        start = System.nanoTime();
        switch (method) {
            case "Add":
                list.add(utils.Random.randomString(16), index);
            case "Get":
                list.get(index);
            case "Remove":
                list.remove(index);
        }
        finish = System.nanoTime();
        double timing = finish - start;
        double elapsedSeconds = (finish - start) / 1_000_000_000.0;
        System.out.println(timing+" nanoseconds, which is in seconds: "+elapsedSeconds);
        return timing;
    }

    /**
     * Additional override definition to accept {@link LinkedList}
     * An override method for testing out the performance of requested method on a given list.
     * @param list, the list taken in to tets on
     * @param method, requested method on which to test
     * @return time in nanoseconds
     */
    public static double timed(LinkedList list, String method) {
        double start = 0;
        double finish = 0;
        Random random = new Random();
        int random_int = random.nextInt(list.size());
        start = System.nanoTime();
        switch (method) {
            case "Add":
                list.add(utils.Random.randomString(16));
            case "Get":
                list.get(random_int);
            case "Remove":
                list.remove(random_int);
        }
        finish = System.nanoTime();
        double timing = finish - start;
        double elapsedSeconds = (finish - start) / 1_000_000_000.0;
        System.out.println(timing+" nanoseconds, which is in seconds: "+elapsedSeconds);
        return timing;
    }

    /**
     * Additional override definition to accept {@link LinkedList}
     * An override method for testing out the performance of requested method on a given list with the specified index.
     * @param list, the list taken in to tets on
     * @param index, the index which is used for all methods
     * @param method, requested method on which to test
     * @return time in nanoseconds
     */
    public static double timed(LinkedList list, String method, int index) {
        double start = 0;
        double finish = 0;
        start = System.nanoTime();
        switch (method) {
            case "Add":
                list.add(index, utils.Random.randomString(16));
            case "Get":
                list.get(index);
            case "Remove":
                list.remove(index);
        }
        finish = System.nanoTime();
        double timing = finish - start;
        double elapsedSeconds = (finish - start) / 1_000_000_000.0;
        System.out.println(timing+" nanoseconds, which is in seconds: "+elapsedSeconds);
        return timing;
    }

    /**
     * Class that separates the Performance testing for Add method.
     */
    public static class PerformanceAdd{
        /**
         * This is an override method, that doesn't need any input. It has it's default of 40k length list.
         * @return a table (2D list) of the results.
         * Where the first list is the output of arrayList test and the next is linkedList
         * Example: [[5270.0, 4243.0, 3883.0], [4.2849892E7, 3455374.0, 2.1715094E7]]
         */
        public static double[][] performanceAdd() {
            int length = 40_000_000;
            int iter = 3;
            return performanceAdd(length, iter);
        }

        /**
         * Runs performance tests on both types lists and returns a table of lists. Uses the methods called timed.
         * @param length the length of the lists to test it on
         * @param iter the times how many iterations it should run it
         * @return a table (2D list) of the results.
         * Where the first list is the output of arrayList test and the next is linkedList
         * Example: [[5270.0, 4243.0, 3883.0], [4.2849892E7, 3455374.0, 2.1715094E7]]
         */
        public static double[][] performanceAdd(int length, int iter) {
            double[][] result = new double[2][iter];
            for (int i = 0; i < iter; i++) {
                ArrayList arrayList = utils.Random.randomArrayList(length, 8);
                LinkedList linkedList = utils.Random.randomLinkedList(length, 8);
                result[0][i] = timed(arrayList, "Add");
                result[1][i] = timed(linkedList, "Add");
            }
            return result;
        }
    }

    /**
     * Class that separates the Performance testing for Get method.
     */
    public static class PerformanceGet{
        /**
         * This is an override method, that doesn't need any input. It has it's default of 40k length list.
         * @return a table (2D list) of the results.
         * Where the first list is the output of arrayList test and the next is linkedList
         * Example: [[5270.0, 4243.0, 3883.0], [4.2849892E7, 3455374.0, 2.1715094E7]]
         */
        public static double[][] performanceGet() {
            int length = 40_000_000;
            int iter = 3;
            return performanceGet(length, iter);
        }

        /**
         * Runs performance tests on both types lists and returns a table of lists. Uses the methods called timed.
         * @param length the length of the lists to test it on
         * @param iter the times how many iterations it should run it
         * @return a table (2D list) of the results.
         * Where the first list is the output of arrayList test and the next is linkedList
         * Example: [[5270.0, 4243.0, 3883.0], [4.2849892E7, 3455374.0, 2.1715094E7]]
         */
        public static double[][] performanceGet(int length, int iter) {
            double[][] result = new double[2][iter];
            for (int i = 0; i < iter; i++) {
                ArrayList arrayList = utils.Random.randomArrayList(length, 8);
                LinkedList linkedList = utils.Random.randomLinkedList(length, 8);
                Random random = new Random();
                int index = random.nextInt(length);
                result[0][i] = timed(arrayList, "Get", index);
                result[1][i] = timed(linkedList, "Get", index);
            }
            return result;
        }
    }

    /**
     * Class that separates the Performance testing for Remove method.
     */
    public static class PerformanceRemove{
        /**
         * This is an override method, that doesn't need any input. It has it's default of 40k length list.
         * @return a table (2D list) of the results.
         * Where the first list is the output of arrayList test and the next is linkedList
         * Example: [[5270.0, 4243.0, 3883.0], [4.2849892E7, 3455374.0, 2.1715094E7]]
         */
        public static double[][] performanceRemove() {
            int length = 40_000_000;
            int iter = 3;
            return performanceRemove(length, iter);
        }

        /**
         * Runs performance tests on both types lists and returns a table of lists. Uses the methods called timed.
         * @param length the length of the lists to test it on
         * @param iter the times how many iterations it should run it
         * @return a table (2D list) of the results.
         * Where the first list is the output of arrayList test and the next is linkedList
         * Example: [[5270.0, 4243.0, 3883.0], [4.2849892E7, 3455374.0, 2.1715094E7]]
         */
        public static double[][] performanceRemove(int length, int iter) {
            double[][] result = new double[2][iter];
            for (int i = 0; i < iter; i++) {
                ArrayList arrayList = utils.Random.randomArrayList(length, 8);
                LinkedList linkedList = utils.Random.randomLinkedList(length, 8);
                Random random = new Random();
                int index = random.nextInt(length);
                result[0][i] = timed(arrayList, "Remove", index);
                result[1][i] = timed(linkedList, "Remove", index);

            }
            return result;
        }
    }

    /**
     * Main function to run the tests, everything will be outputted to the console.
     */
    static void main() {
        double[][] result1 = PerformanceAdd.performanceAdd();
        System.out.println(Arrays.deepToString(result1));

        double[][] result2 = PerformanceMeasurement.PerformanceGet.performanceGet();
        System.out.println(Arrays.deepToString(result2));

        double[][] result = PerformanceMeasurement.PerformanceRemove.performanceRemove();
        System.out.println(Arrays.deepToString(result));
    }
}
