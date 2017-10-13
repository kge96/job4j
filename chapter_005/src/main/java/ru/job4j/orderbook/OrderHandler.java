package ru.job4j.orderbook;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;


/**
 * Class for handle orders.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 11.10.2017.
 */
public class OrderHandler {
    /**
     * Order book with buy operation.
     */
    private Map<String, Map<Double, Order>> buyOrderBook = new HashMap<>();
    /**
     * Order book with sell operation.
     */
    private Map<String, Map<Double, Order>> sellOrderBook = new HashMap<>();
    /**
     * Result program work.
     */
    private Map<Long, Order> resultOrderBook = new TreeMap<>();

    /**
     * Handle data.
     * @return Map.
     */
    public Map<Integer, Order> doHandle() {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        Map<Integer, Order> orderBook = null;
        try {
            SAXParser saxParser = parserFactory.newSAXParser();
            Handler handler = new Handler();
            saxParser.parse("src/main/java/ru/job4j/orderbook/source/orders.xml", handler);
            orderBook = handler.getParsingResult();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orderBook;
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
        String collectionName = "";

        if (operation.equals("buy")) {
            result = buyOrderBook;
            collectionName = "buy";
        }
        if (operation.equals("sell")) {
            result = sellOrderBook;
            collectionName = "sell";
        }

        if (result.containsKey(book) && result.get(book).containsKey(price)) {
            Order currentOrder = result.get(book).get(price);
            int containsVolume = currentOrder.getVolume();
            currentOrder.setVolume(containsVolume + order.getVolume());
            result.get(book).get(price).setVolume(containsVolume + order.getVolume());
        } else if (result.containsKey(book) && !result.get(book).containsKey(price)) {
            result.get(book).put(price, order);
        } else {
            Map<Double, Order> map = null;

            if (collectionName.equals("buy")) {
                map = new TreeMap<>(new Comparator<Double>() {
                    @Override
                    public int compare(Double o1, Double o2) {
                        return o2.compareTo(o1);
                    }
                });
            }

            if (collectionName.equals("sell")) {
                map = new TreeMap<>(new Comparator<Double>() {
                    @Override
                    public int compare(Double o1, Double o2) {
                        return o1.compareTo(o2);
                    }
                });
            }

            map.put(order.getPrice(), order);
            result.put(book, map);
        }
    }

    /**
     * Match orders.
     */
    public void doMuch() {
        for (Map.Entry<String, Map<Double, Order>> buyPair : buyOrderBook.entrySet()) {
            Map<Double, Order> buyBooks = buyPair.getValue();
            Map<Double, Order> sellBooks = null;

            for (Map.Entry<String, Map<Double, Order>> sellPair : sellOrderBook.entrySet()) {
                if (buyPair.getKey().equals(sellPair.getKey())) {
                    sellBooks = sellPair.getValue();
                }
            }
            muchOrders(buyBooks, sellBooks);

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
    private void muchOrders(Map<Double, Order> buyBooks, Map<Double, Order> sellBooks) {
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
     * @return Map.
     */
    public Map<Long, Order> result() {
        return this.resultOrderBook;
    }
}
