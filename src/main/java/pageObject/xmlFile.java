package pageObject;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class xmlFile {
       public  List<String> getListFromXml(String listName) {
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
            e.printStackTrace();
        }
        return list;
    }

    public  String getData(String nodeName){
        DocumentBuilder dBuilder;
        Document doc=null;
        File fXmlFile=new File("./dataConfiguration.xml");
        DocumentBuilderFactory dbFactory =DocumentBuilderFactory.newDefaultInstance();
        try{
            dBuilder=dbFactory.newDocumentBuilder();
            doc=dBuilder.parse((fXmlFile));

        }
        catch (Exception e){
            System.out.println(e);

        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }
}
