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
        if (qName.equals("AddOrder")) {
            data.put(Integer.parseInt(attr.getValue(4)),
                    new Order(attr.getValue(0),
                    attr.getValue(1),
                    Integer.parseInt(attr.getValue(4)),
                    Integer.parseInt(attr.getValue(3)),
                    Double.parseDouble(attr.getValue(2))));
        } else if (qName.equals("DeleteOrder")) {
            int id = Integer.parseInt(attr.getValue(1));
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
