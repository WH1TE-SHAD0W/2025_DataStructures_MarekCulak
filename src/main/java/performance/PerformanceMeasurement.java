package performance;

import datastructures.ArrayList;
import datastructures.LinkedList;

import java.util.Random;

public class PerformanceMeasurement {
    public static String randomString(int length) {
        Random random = new Random();
        char[] word = new char[length];
        for(int i = 0; i < length; i++)
        {
            word[i] = (char)('a' + random.nextInt(26));
        }
        return new String(word);
    }
    public static String[] randomStringArray(int length) {
        Random random = new Random();
        String[] randomStringArray = new String[length];

        for (int i = 0; i < length; i++) {
            randomStringArray[i] = randomString(random.nextInt(18));
        }
        return randomStringArray;
    }
    public static String[] randomStringArray(int length, int maxStringLength) {
        Random random = new Random();
        String[] randomStringArray = new String[length];

        for (int i = 0; i < length; i++) {
            randomStringArray[i] = randomString(random.nextInt(1, maxStringLength));
        }
        return randomStringArray;
    }
    public static LinkedList randomLinkedList(int length, int maxStringLength) {
        Random random = new Random();
        LinkedList randomLinkedList = new LinkedList();

        for (int i = 0; i < length; i++) {
            randomLinkedList.add(randomString(random.nextInt(1, maxStringLength)));
        }
        return randomLinkedList;
    }

    public static ArrayList randomArrayList(int length, int maxStringLength) {
        Random random = new Random();
        ArrayList randomArrayList = new ArrayList();

        for (int i = 0; i < length; i++) {
            randomArrayList.add(randomString(random.nextInt(1, maxStringLength)));
        }
        return randomArrayList;
    }

    public static double performanceAdd(int array_length) {
        double start = System.nanoTime();
        ArrayList list = PerformanceMeasurement.randomArrayList(array_length, 8);
        double finish = System.nanoTime();
        double timing = finish - start;
        double elapsedSeconds = (finish - start) / 1_000_000_000.0;
        System.out.println(timing+" nanoseconds, which is in seconds: "+elapsedSeconds);

        double start2 = System.nanoTime();
        LinkedList list2 = PerformanceMeasurement.randomLinkedList(array_length, 8);
        double finish2 = System.nanoTime();
        double timing2 = finish2 - start2;
        double elapsedSeconds2 = (finish2 - start2) / 1_000_000_000.0;
        System.out.println(timing2+" nanoseconds, which is in seconds: "+elapsedSeconds2);
        return timing;
    }

    public static double performanceGet(int array_length) {
        Random random = new Random();
        ArrayList list = PerformanceMeasurement.randomArrayList(array_length, 8);
        LinkedList list2 = PerformanceMeasurement.randomLinkedList(array_length, 8);

        int random_index = random.nextInt(list.size());
        double start = System.nanoTime();
        list.get(random_index);
        double finish = System.nanoTime();
        double timing = finish - start;
        double elapsedSeconds = (finish - start) / 1_000_000_000.0;
        System.out.println(timing+" nanoseconds, which is in seconds: "+elapsedSeconds);

        double start2 = System.nanoTime();
        list2.get(random_index);
        double finish2 = System.nanoTime();
        double timing2 = finish2 - start2;
        double elapsedSeconds2 = (finish2 - start2) / 1_000_000_000.0;
        System.out.println(timing2+" nanoseconds, which is in seconds: "+elapsedSeconds2);
        return timing;
    }

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
            ArrayList arrayList = PerformanceMeasurement.randomArrayList(length, 8);
            LinkedList linkedList = PerformanceMeasurement.randomLinkedList(length, 8);
            Random random = new Random();
            int index = random.nextInt(length);
            result[0][i] = PerformanceMeasurement.timedRemove(arrayList, index);
            result[1][i] = PerformanceMeasurement.timedRemove(linkedList, index);

        }
        return result;
    }
}
