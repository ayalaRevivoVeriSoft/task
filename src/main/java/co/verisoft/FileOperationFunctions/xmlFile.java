package co.verisoft.FileOperationFunctions;

import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
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
public class xmlFile{
    /**
     * Gets a list of values from the specified list node in the XML file.
     * @param listName The name of the list node to get values from.
     * @return A list of values from the specified list node in the XML file.
     *         Returns an empty list if the list node is not found or if there are no values in the list.
     */
    public static List<String> getListFromXml(String listName) {
        List<String> list = new ArrayList<>();
        try {
            File file = new File("./dataConfiguration.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName(listName);
            Node node = nodeList.item(0);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                NodeList childNodes = element.getChildNodes();
                for (int i = 0; i < childNodes.getLength(); i++) {
                    Node childNode = childNodes.item(i);
                    if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element childElement = (Element) childNode;
                        String value = childElement.getTextContent();
                        list.add(value);
                    }
                }
            }
        } catch (Exception e) {
            log.info("Unable to read from the XML");
        }
        return list;
    }

    /**
     * Gets the value of the specified node in the XML file.
     * @param nodeName The name of the node to get the value of.
     * @return The value of the specified node in the XML file.
     *         Returns an empty string if the node is not found.
     */
    public static String getData(String nodeName) {
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
