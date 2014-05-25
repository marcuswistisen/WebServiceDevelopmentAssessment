package uts.ws.SOAP.client;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Scanner;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.rpc.ServiceException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import uts.ws.ArticleApplication;
import uts.ws.Articles;
import uts.ws.dom.CudaDOM;
public class ArticleClient {
	 public static void main(String[] args) throws ServiceException, TransformerException, ParserConfigurationException, SAXException, IOException, JAXBException {

		  ArticleSOAPServiceLocator locator = new ArticleSOAPServiceLocator();
		  ArticleSOAP articleSOAP = locator.getArticleSOAPPort();
		  Scanner in = new Scanner(System.in);
		  //Application
		  System.out.print("Enter 'a' to fetch all articles, their authors and ID" +"\n" + "Press 'd' to delete an article by ID" + "\n" + "Press 'x' to exit" + "\n" + "Choice: ");
		  while(in.hasNextLine()){
			  try{
			  char input = in.nextLine().charAt(0);
			  if (input == 'a'){ //Fetch articles and list them ad ID Title and Author
				  
				  Article[] article = articleSOAP.fetchArticles();
				  System.out.println("\n" + "ID" + "	" + "TITLE" + "	  " + "AUTHOR" + "\n");
				  for(int i = 0; i < article.length; i++){
				  System.out.println(article[i].getId() + "	" + article[i].getTitle() + "	By " + article[i].getAuthor() + "\n");
				  }
				  System.out.print("Choice: ");
			  }
			  
			  if (input == 'd'){ //Delete an article by inputing Article ID
				  String idIn = "";
				  System.out.print("ID: ");
				  idIn = in.nextLine();
				  int id = Integer.parseInt(idIn); // String to int to use with articleSOAP
				  CudaDOM.deleteArticle(idIn, "WebContent/WEB-INF/articles.xml"); //Delete article from local .xml
				  articleSOAP.removeArticle(id); //remove article from server .xml
				  System.out.print("Article Deleted" + "\n" + "Choice: ");
			  }
			  //if not one of the command chars
			  if (input != 'a' && input != 'd' && input != 'x'){
				  System.out.print("Enter 'a' to fetch all articles, their authors and ID" +"\n" + "Press 'd' to delete an article by ID" + "\n" + "Press 'x' to exit" + "\n" + "Choice: ");
			  }
			  
			  if (input == 'x'){ //Exit application
				  System.exit(0);
			  }
		  }
			  //catch any null exception
			  catch(Exception ex){
				  System.out.print("Enter 'a' to fetch all articles, their authors and ID" +"\n" + "Press 'd' to delete an article by ID" + "\n" + "Press 'x' to exit" + "\n" + "Choice: ");
				  
			  }
		 }
		  
	 }
	 
}

