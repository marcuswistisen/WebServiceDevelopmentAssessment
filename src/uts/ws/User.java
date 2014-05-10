package uts.ws;

import java.io.*;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)

public class User implements Serializable{
	
	@XmlElement(name="email")
	private String email;
	@XmlElement(name="name")
	private String name;
	@XmlElement(name="password")
	private String password;
	
	public User(){}
	
	public User(String email,String name,String password) {
		// TODO Auto-generated constructor stub
		super();
		this.email = email;
		this.name = name;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}