package ru.job4j.orderbook;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.HashMap;
import java.util.Map;


/**
 * Class for handle orders.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 11.10.2017.
 */
public class OrderHandler {
    /**
     * Order operation.
     */
    private final String buy = "buy";

    /**
     * Order operation.
     */
    private final String sell = "sell";

    /**
     * Order book with buy operation.
     */
    private Map<String, Map<Double, Order>> buyOrderBook = new HashMap<>();

    /**
     * Order book with sell operation.
     */
    private Map<String, Map<Double, Order>> sellOrderBook = new HashMap<>();

    /**
     * Sorter.
     */
    private Sorter sorter;

    /**
     * Merger.
     */
    private Merger merger = new Merger();

    /**
     * Return final order book.
     * @return Map.
     */
    public Map<Long, Order> getFinalOrderBook() {
        Map<Integer, Order> orderBook = generateOrderBook();
        this.sorter = new Sorter(orderBook);
        buyOrderBook = this.sorter.getSortedMap(buy);
        sellOrderBook = this.sorter.getSortedMap(sell);
        return merger.getResult(buyOrderBook, sellOrderBook);
    }

    /**
     * Handle data.
     * @return Map.
     */
    public Map<Integer, Order> generateOrderBook() {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        Map<Integer, Order> orderBook = null;
        try {
            SAXParser saxParser = parserFactory.newSAXParser();
            Handler handler = new Handler();
            saxParser.parse("src/main/java/ru/job4j/orderbook/source/orders.xml", handler);
            orderBook = handler.getParsingResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderBook;
    }
}
