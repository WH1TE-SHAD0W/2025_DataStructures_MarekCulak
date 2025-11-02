package performance;

import datastructures.ArrayList;
import datastructures.LinkedList;

import java.util.Random;

public class PerformanceMeasurement {

    public static class PerformanceAdd{
        public static double timedAdd(ArrayList list, int index) {
            double start = System.nanoTime();
            list.add(utils.Random.randomString(16), index);
            double finish = System.nanoTime();
            double timing = finish - start;
            double elapsedSeconds = (finish - start) / 1_000_000_000.0;
            System.out.println(timing+" nanoseconds, which is in seconds: "+elapsedSeconds);
            return timing;
        }

        public static double timedAdd(LinkedList list, int index) {
            double start = System.nanoTime();
            list.add(index, utils.Random.randomString(16));
            double finish = System.nanoTime();
            double timing = finish - start;
            double elapsedSeconds = (finish - start) / 1_000_000_000.0;
            System.out.println(timing+" nanoseconds, which is in seconds: "+elapsedSeconds);
            return timing;
        }

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
                result[0][i] = timedAdd(arrayList, index);
                result[1][i] = timedAdd(linkedList, index);

            }
            return result;
        }
    }

    public static class PerformanceGet{
        public static double timedGet(ArrayList list, int index) {
            double start = System.nanoTime();
            list.get(index);
            double finish = System.nanoTime();
            double timing = finish - start;
            double elapsedSeconds = (finish - start) / 1_000_000_000.0;
            System.out.println(timing+" nanoseconds, which is in seconds: "+elapsedSeconds);
            return timing;
        }

        public static double timedGet(LinkedList list, int index) {
            double start = System.nanoTime();
            list.get(index);
            double finish = System.nanoTime();
            double timing = finish - start;
            double elapsedSeconds = (finish - start) / 1_000_000_000.0;
            System.out.println(timing+" nanoseconds, which is in seconds: "+elapsedSeconds);
            return timing;
        }

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
                result[0][i] = timedGet(arrayList, index);
                result[1][i] = timedGet(linkedList, index);
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
                result[0][i] = timedRemove(arrayList, index);
                result[1][i] = timedRemove(linkedList, index);

            }
            return result;
        }
    }
}
