package ru.job4j.databases.optimize;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Class for getting sum.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 30.10.2017.
 */
public class Handler extends DefaultHandler {
    /**
     * Tag name.
     */
    private final String entry = "entry";
    /**
     * Total sum.
     */
    private long sum = 0;

    /**
     * Do this when start handle element.
     * @param uri - uri.
     * @param localName - localName.
     * @param qName - qName.
     * @param attributes - attributes.
     * @throws SAXException - exception.
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (entry.equals(qName)) {
            sum += Integer.parseInt(attributes.getValue("field"));
        }
    }

    /**
     * Return sum.
     * @return long.
     */
    public long getSum() {
        return sum;
    }
}
