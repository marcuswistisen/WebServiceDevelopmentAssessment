package uts.ws.rest;
 import javax.servlet.ServletContext;
 import javax.ws.rs.*;
 import javax.ws.rs.core.*;
 import javax.xml.bind.JAXBException;
 import javax.xml.bind.annotation.XmlElementRef;
 import javax.xml.bind.annotation.XmlSeeAlso;
 
 import uts.ws.*;
 
 import java.io.*;
  
 @Path("/users")
 public class UserService {
 	@Context
 	 private ServletContext application;
 	 
 	 private UserApplication getUserApp() throws JAXBException, IOException {
 	  synchronized (application) {
 	   UserApplication userApp = (UserApplication)application.getAttribute("userApp");
 	   if (userApp == null) {
 	    userApp = new UserApplication();
 	    userApp.setFilePath(application.getRealPath("WEB-INF/users.xml"));
 	    application.setAttribute("userApp", userApp);
 	   }
 	   return userApp;
 	  }
 	 }
 	 //Get user by Email
 	 @Path("user")
 	 @GET
 	 @Produces(MediaType.APPLICATION_XML) 
 	 @XmlElementRef
 	 public User getUsers(@QueryParam("email") String email) throws JAXBException, IOException{
 		  return getUserApp().getUsers().findByEmail(email);
 	 }
 	 //Get author linking articles.xml to users.xml, i.e. articles.name = users.name
	 @Path("author")
 	 @GET
 	 @Produces(MediaType.APPLICATION_XML) 
 	 @XmlElementRef
 	 public User getAuthor(@QueryParam("name") String name) throws JAXBException, IOException{
 		  return getUserApp().getUsers().findByName(name);
 	 }
 	 
 	 
 }