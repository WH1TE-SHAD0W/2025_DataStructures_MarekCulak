package utils;

import datastructures.ArrayList;
import datastructures.LinkedList;

public class Random {
    public static String randomString(int length) {
        java.util.Random random = new java.util.Random();
        char[] word = new char[length];
        for(int i = 0; i < length; i++)
        {
            word[i] = (char)('a' + random.nextInt(26));
        }
        return new String(word);
    }

    public static LinkedList randomLinkedList(int length, int maxStringLength) {
        java.util.Random random = new java.util.Random();
        LinkedList randomLinkedList = new LinkedList();

        for (int i = 0; i < length; i++) {
            randomLinkedList.add(randomString(random.nextInt(1, maxStringLength)));
        }
        return randomLinkedList;
    }

    public static ArrayList randomArrayList(int length, int maxStringLength) {
        java.util.Random random = new java.util.Random();
        ArrayList randomArrayList = new ArrayList();

        for (int i = 0; i < length; i++) {
            randomArrayList.add(randomString(random.nextInt(1, maxStringLength)));
        }
        return randomArrayList;
    }
}
