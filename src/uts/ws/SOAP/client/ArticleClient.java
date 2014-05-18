package uts.ws.SOAP.client;
import java.rmi.RemoteException;
import java.util.Scanner;

import javax.xml.rpc.ServiceException;

import uts.ws.ArticleApplication;
import uts.ws.dom.CudaDOM;
public class ArticleClient {
	 public static void main(String[] args) throws ServiceException, RemoteException {

		  ArticleSOAPServiceLocator locator = new ArticleSOAPServiceLocator();
		  ArticleSOAP articleSOAP = locator.getArticleSOAPPort();
		  Scanner in = new Scanner(System.in);
		  System.out.print("Enter 'a' to fetch all articles, their authors and ID" +"\n" + "Press 'd' to delete an article by ID" + "\n" + "Press 'x' to exit" + "\n" + "Choice: ");
		  while(in.hasNextLine()){
			  char input = in.nextLine().charAt(0);
			  if (input == 'a'){
				  
				  Article[] article = articleSOAP.fetchArticles();
				  for(int i = 0; i < article.length; i++){
				  System.out.println(article[i].getId() + "	" + article[i].getTitle() + "	By " + article[i].getAuthor() + "\n");
				  }
				  System.out.print("Choice: ");
			  }
			  
			  if (input == 'd'){
				  System.out.print("ID: ");
				  new CudaDOM();
				  System.out.print("Article Deleted" + "\n" + "Choice: ");
			  }
			  
			  if (input == 'x'){
				  System.exit(0);
			  }
		  }
		  
	 }
}

