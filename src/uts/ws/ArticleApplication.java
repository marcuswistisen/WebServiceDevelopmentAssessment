package uts.ws;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class ArticleApplication {
	private String filePath;
	private Articles articles;

	public ArticleApplication() {
		super();
	}

	public ArticleApplication(String filePath, Articles articles) {
		super();
		this.filePath = filePath;
		this.articles = articles;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) throws JAXBException, IOException {
		this.filePath = filePath;
		JAXBContext jc = JAXBContext.newInstance(Articles.class);
		Unmarshaller u = jc.createUnmarshaller();
		FileInputStream fin = new FileInputStream(filePath);
		articles = (Articles)u.unmarshal(fin);
		fin.close();
	}

	public void saveData(String filePath)throws JAXBException, IOException{
		this.filePath = filePath;
		JAXBContext jc = JAXBContext.newInstance(Articles.class);
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		FileOutputStream fout = new FileOutputStream(filePath);
		m.marshal(this.articles, fout); 
		fout.close();
	}

	public Articles getArticles() {
		return articles;
	}
	
	public ArrayList<Article> getArticleList() {
		return articles.getList();
	}

	public void setArticles(Articles articles) {
		this.articles = articles;
	}
}