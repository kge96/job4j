package ru.job4j.databases.optimize;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Class for getting sum of data from database.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 30.10.2017.
 */
public class Summator {
    /**
     * Return summ.
     * @return long.
     */
    public long getSumm() {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        long summ = 0;
        try {
            SAXParser saxParser = parserFactory.newSAXParser();
            Handler handler = new Handler();
            saxParser.parse("C:\\Projects\\gkuznetsov\\chapter_007\\src\\main\\java\\ru\\job4j\\databases\\optimize\\dbsource\\2.xml", handler);
            summ = handler.getSum();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return summ;
    }
}
