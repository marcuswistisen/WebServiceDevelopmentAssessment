package uts.ws;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class UserApplication {
	private String filePath;
	private Users users;
	
	
	/**
	 * 
	 */
	public UserApplication() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param filePath
	 * @param users
	 */
	public UserApplication(String filePath, Users users) {
		super();
		this.filePath = filePath;
		this.users = users;
	}
	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}
	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) throws JAXBException, IOException {
		this.filePath = filePath;
		JAXBContext jc = JAXBContext.newInstance(Users.class);
		Unmarshaller u = jc.createUnmarshaller();
		//u.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		FileInputStream fin = new FileInputStream(filePath);
		users = (Users)u.unmarshal(fin);
		fin.close();
	}
	
	public void saveData(String filePath)throws JAXBException, IOException{
		this.filePath = filePath;
		JAXBContext jc = JAXBContext.newInstance(Users.class);
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		FileOutputStream fout = new FileOutputStream(filePath);
		m.marshal(this.users, fout); 
		fout.close();
	}
		
	/**
	 * @return the users
	 */
	public Users getUsers() {
		return users;
	}
	/**
	 * @param users the users to set
	 */
	public void setUsers(Users users) {
		this.users = users;
	}
	
	


}