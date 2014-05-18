package uts.ws.dom;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
 //CUDA commands to delete, add or modify XML
 //Used http://www.journaldev.com/901/how-to-edit-xml-file-in-java-dom-parser as source
public class CudaDOM {
 
    public static void main(String[] args) {
    	
    	new CudaDOM();
    }
    	public CudaDOM(){
        String filePath = "WebContent/WEB-INF/articles.xml";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
             
            //update attribute value
//            updateAttributeValue(doc);
             
            //update Element value
//            updateElementValue(doc);
            Scanner in = new Scanner(System.in); 
            String id = in.nextLine();
			//delete element
            deleteElement(doc, id);
             
            //add new element
//            addElement(doc);
             
            //write the updated document to file or console
            doc.getDocumentElement().normalize();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("WebContent/WEB-INF/articles.xml"));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
            System.out.println("XML file updated successfully");
             
        } catch (SAXException | ParserConfigurationException | IOException | TransformerException e1) {
            e1.printStackTrace();
        }
    }
 
//    private static void addElement(Document doc) {
//        NodeList employees = doc.getElementsByTagName("Employee");
//        Element emp = null;
//         
//        //loop for each employee
//        for(int i=0; i<employees.getLength();i++){
//            emp = (Element) employees.item(i);
//            Element salaryElement = doc.createElement("salary");
//            salaryElement.appendChild(doc.createTextNode("10000"));
//            emp.appendChild(salaryElement);
//        }
//    }
 
    public static void deleteElement(Document doc, String id) {
        NodeList articles = doc.getElementsByTagName("article");
        Element e = null;

        for(int i=0; i<articles.getLength();i++){
        	e = (Element)articles.item(i);
            if(e.getElementsByTagName("id").item(0).getTextContent().equals(id))
            	e.getParentNode().removeChild(e);
            
        }
        //Update Id Values
        updateIdValue(doc);
         
    }
 
    private static void updateIdValue(Document doc) {
    	NodeList articles = doc.getElementsByTagName("article");
        Element e = null;

        for(int i=0; i<articles.getLength();i++){
        	e = (Element)articles.item(i);
            Node ids = e.getElementsByTagName("id").item(0);
            int id = Integer.parseInt(ids.getTextContent());
            if(id != i+1)
            ids.setTextContent("" + (i+1));
        }
    }
}

