package verisoft.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Utility class for handling XML data reading and parsing.
 */
public class XmlHandling {
    /**
     * Reads and parses XML data from the specified XML file.
     *
     * @param xmlPath     The path to the XML file.
     * @param methodType  The type of method to determine data length.
     * @return A 2-dimensional array containing the parsed XML data.
     * @throws Exception If an error occurs during XML parsing.
     */
    public static String[][] readXmlData(String xmlPath, String methodType) throws Exception {
        File xmlFile = new File(xmlPath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        NodeList entryList = doc.getElementsByTagName("entry");
        int numRows = entryList.getLength();
        int dataLength = 4;
        if(methodType.equals("Verify"))
            dataLength=5;
        String[][] data = new String[numRows][dataLength];

        for (int i = 0; i < numRows; i++) {
            Node entryNode = entryList.item(i);
            if (entryNode.getNodeType() == Node.ELEMENT_NODE) {
                Element entryElement = (Element) entryNode;
                data[i][0] = entryElement.getElementsByTagName("searchColumn").item(0).getTextContent();
                data[i][1] = entryElement.getElementsByTagName("searchText").item(0).getTextContent();
                data[i][2] = entryElement.getElementsByTagName("returnColumnText").item(0).getTextContent();
                data[i][3] = entryElement.getElementsByTagName("expectedText").item(0).getTextContent();
                if(methodType.equals("Verify"))
                    data[i][4] = entryElement.getElementsByTagName("expectedResult").item(0).getTextContent();
            }
        }
        return data;
    }
}