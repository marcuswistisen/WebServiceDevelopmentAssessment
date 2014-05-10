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
<<<<<<< HEAD

=======
	 
>>>>>>> 3bc29b96ed8d363daeeb40dcfcdecf4a245670d5
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

	 @Path("user")
	 @GET
	 @Produces(MediaType.APPLICATION_XML) 
	 @XmlElementRef
	 public User getUsers(@QueryParam("email") String email) throws JAXBException, IOException{
		  return getUserApp().getUsers().findByEmail(email);
	 }
<<<<<<< HEAD

=======
	 
>>>>>>> 3bc29b96ed8d363daeeb40dcfcdecf4a245670d5
}