package ru.job4j.array;

import java.util.Arrays;

/**
 * Class for searching substring at string.
 * @author gkuznetsov.
 * @since 17.09.17.
 * @version 0.1.
 */

public class WordSearcher {
    /**
     * Search substring at string.
     * @param origin - string
     * @param sub - substring
     * @return boolean.
     */
    public boolean contains(String origin, String sub) {
//        String[] array = origin.split(" ");
//        Pattern p = Pattern.compile("(" + sub.toLowerCase() + ")");
//        Matcher mt;
//        for (String s : array) {
//
//            mt = p.matcher(s.toLowerCase());
//            if (mt.find()) {
//                return true;
//            }
//        }
//        return false;
        return Arrays.stream(origin.split(" "))
                .map(String::toLowerCase)
                .anyMatch(s -> s.contains(sub.toLowerCase()));
    }
}
