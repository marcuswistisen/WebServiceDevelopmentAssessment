package uts.ws.SOAP;
import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.ws.handler.MessageContext;
import javax.servlet.ServletContext;
import javax.xml.ws.WebServiceContext;

import uts.ws.ArticleApplication;
import uts.ws.Articles;
import uts.ws.dom.CudaDOM;

import org.xml.sax.SAXException;

import uts.ws.*;


@WebService
public class ArticleSOAP {
	@Resource
	private WebServiceContext context;
	//Create get article application to use in a servlet context
	private ArticleApplication getArticleApp() throws JAXBException, IOException {
		ServletContext application = (ServletContext)context.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
		synchronized (application) {
			ArticleApplication articleApp = (ArticleApplication)application.getAttribute("articleApp");
	    if (articleApp == null) {
	    	articleApp = new ArticleApplication();
	    	articleApp.setFilePath(application.getRealPath("WEB-INF/articles.xml")); // Server path
	    	application.setAttribute("articleApp", articleApp);
	   }
	   return articleApp;
		}
	}
	//Fetch Articles
	public Articles fetchArticles() throws JAXBException, IOException{
		return getArticleApp().getArticles();
	}
	//Remove articles by ID
	public void removeArticle(int id) throws JAXBException, IOException{
		Article article = getArticleApp().getArticles().findById(id); //Find article by ID
		getArticleApp().getArticles().removeArticle(article); // remove  article
		String filePath = getArticleApp().getFilePath(); //Get File path
		getArticleApp().saveData(filePath); //Save
	}

}