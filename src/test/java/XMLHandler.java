import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLHandler {
public static String getData (String keyName) throws SAXException, IOException, ParserConfigurationException{
    File xmlFile =  new File("c:\\QA course\\project2\\projectxml.xml");
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = null;

    dBuilder = dbFactory.newDocumentBuilder();

    Document doc = null;
    assert dBuilder != null;
    doc = dBuilder.parse(xmlFile);

    if (doc != null){
        doc.getDocumentElement().normalize();
    }
    assert doc != null;
    return doc.getElementsByTagName(keyName).item(0).getTextContent();
}
}
