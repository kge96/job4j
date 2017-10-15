package ru.job4j.orderbook;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class for sorting parsing result.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 15.10.2017.
 */
public class Sorter {
    /**
     * Order operation.
     */
    private final String buy = "buy";

    /**
     * Order operation.
     */
    private final String sell = "sell";

    /**
     * Input order book.
     */
    private Map<Integer, Order> orderBook;

    /**
     * Order book with buy operation.
     */
    private Map<String, Map<Double, Order>> buyOrderBook = new HashMap<>();

    /**
     * Order book with sell operation.
     */
    private Map<String, Map<Double, Order>> sellOrderBook = new HashMap<>();

    /**
     * Sorter constructor.
     * @param orderBook - order book.
     */
    public Sorter(Map<Integer, Order> orderBook) {
        this.orderBook = orderBook;
        distributeOrderBook(orderBook);
    }

    /**
     * Distribute parsing result.
     * @param orderBook - parsing result.
     */
    public void distributeOrderBook(Map<Integer, Order> orderBook) {
        long start = System.currentTimeMillis();
        for (Order value : orderBook.values()) {
            separateByOperation(value);
        }
        long total = System.currentTimeMillis() - start;
        System.out.println("Separate time is - " + total + " ms");
    }

    /**
     * Separate order book by operation.
     * @param order - oreder.
     */
    public void separateByOperation(Order order) {
        Map<String, Map<Double, Order>> result = null;
        String operation = order.getOperation().toLowerCase();
        String book = order.getBook();
        double price = order.getPrice();

        String operationType = "";

        if (buy.equals(operation)) {
            result = buyOrderBook;
            operationType = buy;
        }
        if (sell.equals(operation)) {
            result = sellOrderBook;
            operationType = sell;
        }

        if (result.containsKey(book) && result.get(book).containsKey(price)) {
            Order currentOrder = result.get(book).get(price);
            int containsVolume = currentOrder.getVolume();
            currentOrder.setVolume(containsVolume + order.getVolume());
            result.get(book).get(price).setVolume(containsVolume + order.getVolume());
        } else if (result.containsKey(book) && !result.get(book).containsKey(price)) {
            result.get(book).put(price, order);
        } else {
            Map<Double, Order> map = getMapWithComparator(operationType);
            map.put(order.getPrice(), order);
            result.put(book, map);
        }
    }

    /**
     * Return TreeMap with comparator for specified operation.
     * @param operationType - operation type.
     * @return TreeMap.
     */
    private TreeMap getMapWithComparator(String operationType) {
        return buy.equals(operationType)
                ?
                new TreeMap<>(new Comparator<Double>() {
                    @Override
                    public int compare(Double o1, Double o2) {
                        return o2.compareTo(o1);
                    }
                })
                :
                new TreeMap<>(new Comparator<Double>() {
                    @Override
                    public int compare(Double o1, Double o2) {
                        return o1.compareTo(o2);
                    }
                });
    }

    /**
     * Return sorted order book.
     * @param orderOperation - specified order operation.
     * @return Map.
     */
    public Map<String, Map<Double, Order>> getSortedMap(String orderOperation) {
        return buy.equals(orderOperation) ? buyOrderBook : sell.equals(orderOperation) ? sellOrderBook : null;
    }
}
