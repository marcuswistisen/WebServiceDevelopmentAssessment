package uts.ws;

import java.util.*;
import java.io.Serializable;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "users")
public class Users implements Serializable {
	@XmlElement(name = "user")
    private ArrayList<User> list = new ArrayList<User>();
    public ArrayList<User> getList() {
        return list;
    }
    public void addUser(User user) throws JAXBException {
        list.add(user);
        
    }
    
    public void removeUser(User user) {
        list.remove(user);
    }
    public User login(String email, String password) {
        // For each user in the list...
        for (User user : list) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password))
            	return user; // Login correct. Return this user.
        }
        return null; // Login incorrect. Return null.
    }
   
    public User findByEmail(String email) {
    	
<<<<<<< HEAD
    	// For each user in the list...
        for (User user : list) {
            if (user.getEmail().equalsIgnoreCase(email))
            	return user; // Email has not been used. Return the user.
        }
        	return null; // Email has been used. Return a null user.
    } 
    	
}

