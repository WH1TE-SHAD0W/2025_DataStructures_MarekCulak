package performance;

import datastructures.ArrayList;
import datastructures.LinkedList;

import java.util.Random;

public class PerformanceMeasurement {
    /**
     * A specific class of methods for performance test for Add method
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
     * A specific class of methods for performance test for Add method
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

    public static class PerformanceAdd{
        public static double[][] performanceAdd() {
            int length = 40_000_000;
            return performanceAdd(length);
        }

        public static double[][] performanceAdd(int length) {
            int measurement = 3;
            double[][] result = new double[2][measurement];
            for (int i = 0; i < measurement; i++) {
                ArrayList arrayList = utils.Random.randomArrayList(length, 8);
                LinkedList linkedList = utils.Random.randomLinkedList(length, 8);
                Random random = new Random();
                int index = random.nextInt(length);
                result[0][i] = timed(arrayList, "Add");
                result[1][i] = timed(linkedList, "Add");

            }
            return result;
        }
    }

    public static class PerformanceGet{
        public static double[][] performanceGet() {
            int length = 40_000_000;
            return performanceGet(length);
        }

        public static double[][] performanceGet(int length) {
            int measurement = 3;
            double[][] result = new double[2][measurement];
            for (int i = 0; i < measurement; i++) {
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

    public static class PerformanceRemove{
        public static double timedRemove(ArrayList list, int index) {
            double start = System.nanoTime();
            list.remove(index);
            double finish = System.nanoTime();
            double timing = finish - start;
            double elapsedSeconds = (finish - start) / 1_000_000_000.0;
            System.out.println(timing+" nanoseconds, which is in seconds: "+elapsedSeconds);
            return timing;
        }

        public static double timedRemove(LinkedList list, int index) {
            double start = System.nanoTime();
            list.remove(index);
            double finish = System.nanoTime();
            double timing = finish - start;
            double elapsedSeconds = (finish - start) / 1_000_000_000.0;
            System.out.println(timing+" nanoseconds, which is in seconds: "+elapsedSeconds);
            return timing;
        }

        public static double[][] performanceRemove() {
            int length = 40_000_000;
            return performanceRemove(length);
        }

        public static double[][] performanceRemove(int length) {
            int measurement = 3;
            double[][] result = new double[2][measurement];
            for (int i = 0; i < measurement; i++) {
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
}
