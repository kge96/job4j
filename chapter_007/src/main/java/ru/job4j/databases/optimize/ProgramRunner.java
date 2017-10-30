package ru.job4j.databases.optimize;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

/**
 * Class for starting program.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 28.10.2017.
 */
public class ProgramRunner {
    /**
     * Start program.
     * @param countOfNumbers - count of numbers.
     * @throws TransformerException - exception.
     * @throws ParserConfigurationException - exception.
     */
    public void startProgram(int countOfNumbers) throws TransformerException, ParserConfigurationException {
        DBConnector connector = new DBConnector();
        XMLConverter converter = new XMLConverter();
        Summator summator = new Summator();

        connector.setURL("jdbc:sqlite:C:\\Projects\\gkuznetsov\\chapter_007\\src\\main\\java\\ru\\job4j\\databases\\optimize\\dbsource\\numbers.db");
        connector.openConnections();
        connector.initTable();
        connector.setN(countOfNumbers);
        connector.addNumbers();


        int[] numbers = connector.getNumbers();
        ParserToXML parser = new ParserToXML(numbers);
        parser.startParsing();
        converter.convertXML();
        System.out.println(summator.getSumm());
        connector.closeConnections();
    }
}
