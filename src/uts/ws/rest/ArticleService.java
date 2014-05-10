package uts.ws.rest;
import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.sun.jersey.api.provider.jaxb.XmlHeader;

import uts.ws.*;

import java.io.*;
import java.util.ArrayList;
 
@Path("/articles")
public class ArticleService {
	@Context
	 private ServletContext application;
	 
	 private ArticleApplication getArticleApp() throws JAXBException, IOException {
	  synchronized (application) {
	   ArticleApplication articleApp = (ArticleApplication)application.getAttribute("articleApp");
	   if (articleApp == null) {
	    articleApp = new ArticleApplication();
	    articleApp.setFilePath(application.getRealPath("/WEB-INF/articles.xml"));
	    application.setAttribute("articleApp", articleApp);
	   }
	   return articleApp;
	  }
	 }

	 @Path("article")
	 @GET
	 @Produces(MediaType.APPLICATION_XML)
	 @XmlElementRef
	 public Article getArticles(@QueryParam("id") int id) throws JAXBException, IOException{
		  return getArticleApp().getArticles().findById(id);
	 }
	 
	 @Path("tag")
	 @GET
	 @Produces(MediaType.APPLICATION_XML)
	 @XmlHeader("<?xml-stylesheet type=\"text/xsl\" href=\"articles.xsl\"?>")
	 @XmlElementRef
	 public ArrayList<Article> getArticles(@QueryParam("id") String tag) throws JAXBException, IOException{ 
		 return getArticleApp().getArticles().findByTag(tag);
	 }
	 
}
