package ru.job4j.orderbook;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Class for creating parser.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 11.10.2017.
 */
public class Handler extends DefaultHandler {
    /**
     * Xml tag for addition order.
     */
    private final String addOrder = "AddOrder";
    /**
     * Xml tag for removing order.
     */
    private final String deleteOrder = "DeleteOrder";
    /**
     * Tag attribute.
     */
    private final String book = "book";
    /**
     * Tag attribute.
     */
    private final String operation = "operation";
    /**
     * Tag attribute.
     */
    private final String price = "price";
    /**
     * Tag attribute.
     */
    private final String volume = "volume";
    /**
     * Tag attribute.
     */
    private final String orderId = "orderId";
    /**
     * Total parsing time.
     */
    private long total;
    /**
     * Parsing time.
     */
    private Map<Integer, Order> data = new LinkedHashMap<>();


    /***
     * Action when parsing starting.
     * @throws SAXException - saxe exception.
     */
    @Override
    public void startDocument() throws SAXException {
        total = System.currentTimeMillis();
    }

    /**
     * Actions when parsing finished.
     * @throws SAXException - saxe exception.
     */
    @Override
    public void endDocument() throws SAXException {
        total = System.currentTimeMillis() - total;
        System.out.println("Parsing time is - " + total + " ms");
        System.out.println("Collection size is - " + data.size() + " elements");
    }

    /**
     * Action when parser find tag.
     * @param uri - uri.
     * @param localName - local name.
     * @param qName - tag name.
     * @param attr - tag attributes.
     * @throws SAXException - sax exception.
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attr) throws SAXException {
        if (addOrder.equals(qName)) {
            data.put(Integer.parseInt(attr.getValue(orderId)),
                    new Order(attr.getValue(book),
                    attr.getValue(operation),
                    Integer.parseInt(attr.getValue(orderId)),
                    Integer.parseInt(attr.getValue(volume)),
                    Double.parseDouble(attr.getValue(price))));
        } else if (deleteOrder.equals(qName)) {
            int id = Integer.parseInt(attr.getValue(orderId));
            data.remove(id);
        }
    }
    /**
     * Return parsing result.
     * @return Map.
     */
    public Map<Integer, Order> getParsingResult() {
        return data;
    }
}
