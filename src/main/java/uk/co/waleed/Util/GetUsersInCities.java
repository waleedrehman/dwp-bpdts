package uk.co.waleed.Util;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class GetUsersInCities {

    private ArrayList result;

    public GetUsersInCities (String xmlData) {
        result = new ArrayList();
        String temp = "";
        Document doc = convertStringToXMLDocument(xmlData);
        doc.getDocumentElement().normalize();
        Element root = doc.getDocumentElement();
        System.out.println(root.getNodeName());
        NodeList nList = doc.getElementsByTagName("city");

        RestTemplate restTemplate = new RestTemplate();

        final String uri = "http://bpdts-test-app.herokuapp.com/city/%city/users";

        //final String uri = "https://nominatim.openstreetmap.org/search?q="
        //        + city + "&format=jsonv2&addressdetails=1";


        //this.result = restTemplate.getForObject(uri, String.class);

        JsonParser springParser = JsonParserFactory.getJsonParser();

        for (int i = 0; i < nList.getLength(); i++)
        {
            Node node = nList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                System.out.println("City name : "    + eElement.getAttribute("name"));
                temp += restTemplate.getForObject("http://bpdts-test-app.herokuapp.com/city/"
                        + eElement.getAttribute("name") + "/users",String.class);

            }
        }
        temp = temp.replace("\n","").replace("[]","").replace("null","");
        result.add(Arrays.asList(temp));
        System.out.println(result);
    }

    public ArrayList getData(){
        return this.result;
    }

    private static Document convertStringToXMLDocument(String xmlString)
    {
        //Parser that produces DOM object trees from XML content
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        //API to obtain DOM Document instance
        DocumentBuilder builder = null;
        try
        {
            //Create DocumentBuilder with default configuration
            builder = factory.newDocumentBuilder();

            //Parse the content to Document object
            Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
            return doc;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
