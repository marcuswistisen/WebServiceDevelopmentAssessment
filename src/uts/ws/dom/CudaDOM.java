package uts.ws.dom;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import uts.ws.ArticleApplication;
import uts.ws.*;
import uts.ws.SOAP.client.Article;
 //CUDA commands to delete, modify and add to XML
 //Used some code from http://www.journaldev.com/901/how-to-edit-xml-file-in-java-dom-parser
public class CudaDOM {
    	//XML writer
    	private static void write(Document doc, String filePath) throws TransformerException{
    		doc.getDocumentElement().normalize();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
    	}
    	
    public static void addArticle(String newFilePath, String author, String tag, String title, String text) throws ParserConfigurationException, SAXException, IOException, TransformerException {
    	//Add article
    	String filePath = newFilePath;
        File xmlFile = new File(filePath);
        //System.out.println(xmlFile.getPath());
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();
        
        Element root = doc.getDocumentElement();
        root.appendChild(getArticle(doc, author, tag, title, text)); //create root child
        write(doc, filePath);
    
    }
    //Create elements
    private static Node getArticle(Document doc, String author, String tag, String title, String text){
    	Element article = doc.createElement("article");
    	NodeList articles = doc.getElementsByTagName("article");
        Element e = null;
        String id = "";
        for(int i=0; i<articles.getLength();i++){ //get correct ID value
        	e = (Element)articles.item(i);
            Node ids = e.getElementsByTagName("id").item(0);
            int id1 = Integer.parseInt(ids.getTextContent());
            id1 += 1;
            id = Integer.toString(id1);
            }
        String previews;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String todaysDate = dateFormat.format(date).toString(); //use todays date
        if (text.length() > 320)
        	previews = text.substring(0,320);
        else
        	previews = text;
    	//create id element
    	
    	 article.appendChild(getArticleElements(doc, article, "id", id));
 
        //create author element
        article.appendChild(getArticleElements(doc, article, "author", author));
 
        //create tag element
        article.appendChild(getArticleElements(doc, article, "tag", tag));
        
      //create date element
        article.appendChild(getArticleElements(doc, article, "date", todaysDate));
      
        //create title element
        article.appendChild(getArticleElements(doc, article, "title", title));
        
        //create previews element
        article.appendChild(getArticleElements(doc, article, "previews", previews));
 
        //create gender element
        article.appendChild(getArticleElements(doc, article, "text", text));
 
        return article;
    }
    
  //utility method to create text node
    private static Node getArticleElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
    //Delete Element or nod
    public static void deleteArticle(String idIn, String fpath) throws TransformerException, ParserConfigurationException, SAXException, IOException {
    	String filePath = fpath;
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();
        String id = idIn;
        NodeList articles = doc.getElementsByTagName("article");
        Element e = null;

        for(int i=0; i<articles.getLength();i++){
        	e = (Element)articles.item(i);
            if(e.getElementsByTagName("id").item(0).getTextContent().equals(id))
            	e.getParentNode().removeChild(e);
            
        }
        updateIdValue(doc); //update id
        write(doc, filePath);
         
    }
    //Modify id value to be correct after delete
    private static void updateIdValue(Document doc) {
    	NodeList articles = doc.getElementsByTagName("article");
        Element e = null;

        for(int i=0; i<articles.getLength();i++){
        	e = (Element)articles.item(i);
            Node ids = e.getElementsByTagName("id").item(0);
            int id = Integer.parseInt(ids.getTextContent());
            if(id != i+1) //id should always be equal to i + 1
            ids.setTextContent("" + (i+1));
        }
    }
}

