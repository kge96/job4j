package ru.job4j.databases.optimize;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * Class for converting xml file.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 28.10.2017.
 */
public class XMLConverter {
    /**
     * Convert xml file.
     */
    public void convertXML() {
        try {
            TransformerFactory ttf = TransformerFactory.newInstance();
            Transformer tf = ttf.newTransformer(new StreamSource(new File("C:\\Projects\\gkuznetsov\\chapter_007\\src\\main\\java\\ru\\job4j\\databases\\optimize\\dbsource\\converter.xsl")));
            StreamSource ss = new StreamSource(new File("C:\\Projects\\gkuznetsov\\chapter_007\\src\\main\\java\\ru\\job4j\\databases\\optimize\\dbsource\\1.xml"));
            StreamResult sr = new StreamResult(new File("C:\\Projects\\gkuznetsov\\chapter_007\\src\\main\\java\\ru\\job4j\\databases\\optimize\\dbsource\\2.xml"));
            tf.transform(ss, sr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
