package ru.job4j.reference;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Class for testing ReferenceUnits.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 07.10.2017.
 */
public class ReferenceUnits {
    /**
     * Array list for creating new collections of units.
     */
    private List<String> list = new ArrayList<>();
    /**
     * Specified array of units.
     */
    private String[] units;

    /**
     * Constructor.
     * @param units - specified array of units.
     */
    public ReferenceUnits(String[] units) {
        this.units = units;
        fillUnits();
    }

    /**
     * Fill new dynamic collection elements from specified array.
     */
   public void fillUnits() {
       for (String string : units) {
           StringBuilder sb = new StringBuilder();
           String[] str = string.split("\\\\");
           int count = 0;

          for (String s : str) {
              sb.append(s);
              if (!list.contains(sb.toString())) {
                  list.add(sb.toString());
              }
              if (count < str.length - 1) {
                  sb.append("\\");
                  count++;
              }
          }
       }
   }

    /**
     * Sorted collection from smallest element to biggest.
     * @return String[] - sorted array.
     */
    public String[] sortFromSmallest() {
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                String[] string = str1.split("\\\\");
                if (str1.length() > str2.length() && !str1.startsWith(str2) && str2.startsWith(string[0])) {
                    return -1;
                } else {
                    return str1.compareTo(str2);
                }
            }
        });
        this.units = list.toArray(new String[list.size()]);
        return this.units;
    }

    /**
     * Sort collection from biggest element to smaller.
     * @return String[] - sorted array.
     */
    public String[] sortFromBiggest() {
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                if (str2.length() < str1.length() && str1.startsWith(str2)) {
                    return 1;
                }
                return str2.compareTo(str1);
            }
        });
        this.units = list.toArray(new String[list.size()]);
        return this.units;
    }

}
