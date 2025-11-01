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


}
