package uts.ws;

import java.io.*;

import javax.xml.bind.*;

public class UserApplication {
	private String filePath;
	private Users users;

	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
		// Create the unmarshaller
		JAXBContext jc = null;
		try {
			jc = JAXBContext.newInstance(Users.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Unmarshaller u = null;
		try {
			u = jc.createUnmarshaller();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Now unmarshal the object from the file
		FileInputStream fin = null;
		try {
			fin = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.users = (Users)u.unmarshal(fin);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			fin.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveData(String filePath)throws JAXBException, IOException{
		this.filePath = filePath;
		JAXBContext jc = JAXBContext.newInstance(Articles.class);
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		FileOutputStream fout = new FileOutputStream(filePath);
		m.marshal(this.users, fout); 
		fout.close();
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
}