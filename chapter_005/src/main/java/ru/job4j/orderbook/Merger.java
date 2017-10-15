package ru.job4j.orderbook;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class for getting final result.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 15.10.2017.
 */
public class Merger {

    /**
     * Result program work.
     */
    private Map<Long, Order> resultOrderBook = new TreeMap<>();

    /**
     * Match orders.
     * @param buyOrderBook - buy order book.
     * @param sellOrderBook - sell order book.
     */
    public void doMerge(Map<String, Map<Double, Order>> buyOrderBook, Map<String, Map<Double, Order>> sellOrderBook) {
        for (Map.Entry<String, Map<Double, Order>> buyPair : buyOrderBook.entrySet()) {
            Map<Double, Order> buyBooks = buyPair.getValue();
            Map<Double, Order> sellBooks = null;

            for (Map.Entry<String, Map<Double, Order>> sellPair : sellOrderBook.entrySet()) {
                if (buyPair.getKey().equals(sellPair.getKey())) {
                    sellBooks = sellPair.getValue();
                }
            }
            combineOrders(buyBooks, sellBooks);

        }
        clearNullItems(buyOrderBook);
        clearNullItems(sellOrderBook);
        mergeToResult(buyOrderBook);
        mergeToResult(sellOrderBook);
    }

    /**
     * Much orders.
     * @param buyBooks - collections with buy operation order books.
     * @param sellBooks - collections with sell operation order books.
     */
    private void combineOrders(Map<Double, Order> buyBooks, Map<Double, Order> sellBooks) {
        for (Map.Entry<Double, Order> buePair : buyBooks.entrySet()) {
            for (Map.Entry<Double, Order> sellPair : sellBooks.entrySet()) {
                if (sellPair.getValue() != null && buePair.getKey() >= sellPair.getKey()) {

                    int buyVolume = buePair.getValue().getVolume();
                    int sellVolume = sellPair.getValue().getVolume();
                    int result = (buyVolume - sellVolume);

                    if (result == 0) {
                        buePair.getValue().setVolume(0);
                        sellPair.getValue().setVolume(0);
                    }
                    if (result > 0) {
                        buePair.getValue().setVolume(result);
                        sellPair.getValue().setVolume(0);
                    }
                    if (result < 0) {
                        result *= -1;
                        sellPair.getValue().setVolume(result);
                        buePair.getValue().setVolume(0);
                    }
                } else {
                    continue;
                }
                if (sellPair.getValue().getVolume() == 0) {
                    sellPair.setValue(null);
                }
                if (buePair.getValue().getVolume() == 0) {
                    buePair.setValue(null);
                    break;
                }
            }
        }
    }

    /**
     * Clear all element where value in collection is null.
     * @param orderBook - order book.
     */
    private void clearNullItems(Map<String, Map<Double, Order>> orderBook) {
        for (Map.Entry<String, Map<Double, Order>> pair : orderBook.entrySet()) {
            Iterator it = pair.getValue().values().iterator();
            while (it.hasNext()) {
                Order nexElement = (Order) it.next();
                if (nexElement == null) {
                    it.remove();
                }
            }
        }
    }

    /**
     * Create result collection.
     * @param orderBook - source order book.
     */
    private void mergeToResult(Map<String, Map<Double, Order>> orderBook) {
        for (Map<Double, Order> value : orderBook.values()) {
            for (Order order: value.values()) {
                resultOrderBook.put(order.getOrderId(), order);
//                System.out.println(String.format("Id - %s %s %s %s %s", order.getOrderId(), order.getBook(), order.getOperation(), order.getVolume(), order.getPrice()));
            }
        }
    }

    /**
     * Return maching result.
     * @param buyOrderBook - buy order book.
     * @param sellOrderBook - sell order book.
     * @return Map.
     */
    public Map<Long, Order> getResult(Map<String, Map<Double, Order>> buyOrderBook, Map<String, Map<Double, Order>> sellOrderBook) {
        doMerge(buyOrderBook, sellOrderBook);
        return this.resultOrderBook;
    }

}
