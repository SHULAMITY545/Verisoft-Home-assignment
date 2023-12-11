package verisoft.utils;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Utility class for handling XML configuration files.
 */
public class XmlConfig {
    private Document doc;

    /**
     * Initializes the XMLConfig instance by reading the specified XML file.
     *
     * @param xmlPath The path to the XML configuration file.
     */
    public XmlConfig(String xmlPath) {
        readXmlFile(xmlPath);
    }

    /**
     * Reads and parses the XML file.
     *
     * @param xmlPath The path to the XML configuration file.
     */
    private void readXmlFile(String xmlPath) {
        DocumentBuilder dBuilder;
        File fXmlFile = new File(xmlPath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        } catch (Exception e) {
            System.out.println("Exception in reading XML file path{" + xmlPath + "}: " + e);
        }
        doc.getDocumentElement().normalize();
    }

    /**
     * Retrieves the value associated with the specified XML element.
     *
     * @param value The XML element for which to retrieve the value.
     * @return The value of the specified XML element.
     */
    public String get(String value) {
        return doc.getElementsByTagName(value).item(0).getTextContent();
    }
}
