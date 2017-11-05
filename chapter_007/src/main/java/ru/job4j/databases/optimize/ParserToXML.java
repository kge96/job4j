package ru.job4j.databases.optimize;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Class for parsing data from database to xml.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 28.10.2017.
 */
public class ParserToXML {
    /**
     * Numbers array.
     */
    private int[] numbers = null;

    /**
     * Constructor.
     * @param numbers - numbers array.
     */
    public ParserToXML(int[] numbers) {
        this.numbers = numbers;
    }

    /**
     * Start parsing.
     * @throws ParserConfigurationException - exception.
     * @throws TransformerException - exception.
     */
    public void startParsing() throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        Document doc = factory.newDocumentBuilder().newDocument();

        Element entries = doc.createElement("entries");
        doc.appendChild(entries);

        for (int i = 0; i < numbers.length; i++) {
            String value = String.valueOf(numbers[i]);
            entries.appendChild(getEntry(doc, "field", value));
        }
        File xmlFile = new File("src\\main\\java\\\\ru\\job4j\\databases\\optimize\\dbsource\\1.xml");
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(doc), new StreamResult(xmlFile));
    }

    /**
     * Create element.
     * @param doc - document.
     * @param name - element name.
     * @param value - element value.
     * @return Node.
     */
    private Node getElement(Document doc, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

    /**
     * Return entry node.
     * @param doc - document.
     * @param name - entry name.
     * @param value - entry value.
     * @return Node.
     */
    private Node getEntry(Document doc, String name, String value) {
        Element entry = doc.createElement("entry");
        entry.appendChild(getElement(doc, name, value));
        return entry;
    }
}
