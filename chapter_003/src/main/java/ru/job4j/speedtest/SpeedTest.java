package ru.job4j.speedtest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.Set;
import java.util.Collection;



/**
 * Class for comparison speed.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 25.09.2017.
 */
public class SpeedTest {
    /**
     * Main method.
     * @param args - args.
     */
    public static void main(String[] args) {
        List<String> linkedList = new LinkedList<>();
        List<String> arrayList = new ArrayList<>();
        Set<String> treeSet = new TreeSet<>();

        SpeedTest sp = new SpeedTest();

        System.out.println(String.format("Linked list addition - %s ms", sp.add(linkedList, 200_000)));
        System.out.println(String.format("Array list addition - %s ms", sp.add(arrayList, 2_000_000)));
        System.out.println(String.format("Tree set addition - %s ms\n", sp.add(treeSet, 2_000_000)));

        System.out.println(String.format("Array list deleting - %s ms", sp.delete(arrayList, 9_000)));
        System.out.println(String.format("Linked list deleting - %s ms", sp.delete(linkedList, 9_000)));
        System.out.println(String.format("Tree set deleting - %s ms", sp.delete(treeSet, 9_000)));
    }

    /**
     * Add random string in collection.
     * @param collection - collection.
     * @param amount - number of operation.
     * @return long - execution time.
     */
    public long add(Collection<String> collection, int amount) {
        List<String> testData = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            long data = System.currentTimeMillis() + (int) Math.random() * 100 + i;
            String str = String.valueOf(data);
            testData.add(str);
        }

        long start = System.currentTimeMillis();

        for (int i = 0; i < amount; i++) {
            collection.add(testData.get(i));
        }

        long finish = System.currentTimeMillis();
        System.out.println(String.format("Collection after adding - %s", collection.size()));
        return finish - start;
    }

    /**
     * Delete string from collection.
     * @param collection - collection.
     * @param amount - number of operation.
     * @return long - execution time.
     */
    public long delete(Collection<String> collection, int amount) {
        List<String> str = new ArrayList<>();
        str.addAll(collection);
        long start = System.currentTimeMillis();

        for (int i = 0; i < amount; i++) {
            collection.remove(str.get(i));
        }

        long finish = System.currentTimeMillis();
        System.out.println(String.format("Collection after deleting - %s", collection.size()));
        return finish - start;
    }
}
