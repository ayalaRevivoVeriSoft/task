package co.verisoft.FileOperationFunctions;

import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Slf4j
/**
 * This class provides methods to read data from an XML file.
 */
public class xmlFile {
    /**
     * Parses an XML file located at "./dataConfiguration.xml" and extracts a list of strings
     * from the first element with the specified name.
     *
     * @param listName the name of the XML element to extract data from
     * @return a List of strings containing the data from the specified XML element
     * @throws IOException if there is an error reading the XML file
     */

    public static List<String> getListFromXml(String listName) {
        List<String> dataList = new ArrayList<String>();
        try {
            File xmlFile = new File("./dataConfiguration.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName(listName);
            Element element = (Element) nodeList.item(0);
            NodeList childNodes = element.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                if (childNodes.item(i).getNodeType() == Element.ELEMENT_NODE) {
                    String data = childNodes.item(i).getTextContent().trim();
                    dataList.add(data);
                }
            }
        } catch (Exception e) {
            log.info("Unable to read from the XML");
        }
        return dataList;
    }

    /**
     * Gets the value of the specified node in the XML file.
     *
     * @param nodeName The name of the node to get the value of.
     * @return The value of the specified node in the XML file.
     * Returns an empty string if the node is not found.
     */
    public static String getStringFromXml(String nodeName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./dataConfiguration.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newDefaultInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse((fXmlFile));
        } catch (Exception e) {
            log.info("Unable to read from the XML");
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }
}
