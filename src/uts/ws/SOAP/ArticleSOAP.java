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
	
	private ArticleApplication getArticleApp() throws JAXBException, IOException {
		ServletContext application = (ServletContext)context.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
		synchronized (application) {
			ArticleApplication articleApp = (ArticleApplication)application.getAttribute("articleApp");
	    if (articleApp == null) {
	    	articleApp = new ArticleApplication();
	    	articleApp.setFilePath(application.getRealPath("WEB-INF/articles.xml"));
	    	application.setAttribute("articleApp", articleApp);
	   }
	   return articleApp;
		}
	}
	
	public Articles fetchArticles() throws JAXBException, IOException{
		return getArticleApp().getArticles();
	}
	
	public void removeArticle(int id) throws JAXBException, IOException{
		Article article = getArticleApp().getArticles().findById(id);
		getArticleApp().getArticles().removeArticle(article);
		String filePath = getArticleApp().getFilePath();
		getArticleApp().saveData(filePath);
	}

}