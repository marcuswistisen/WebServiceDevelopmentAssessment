package uts.ws;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "articles")
public class Articles implements Serializable {
	@XmlElement(name = "article")
	private ArrayList<Article> list = new ArrayList<Article>();

	public ArrayList<Article> getList() {
        return list;
    }

	public void addArticle(Article article)throws JAXBException {
        list.add(article);  
    }

	public void removeArticle(Article article) {
        list.remove(article);
    }

    public Article findById(int id) {
    	        for (Article article : list) {
    	            if (article.getId() == id)
    	 return article;
    	        }
    	 return null;
    	    }
    
    public ArrayList<Article> findByTag(String tag) {
    	ArrayList<Article> tags = new ArrayList<Article>();
        for (Article article : list) {
            if (article.getTag().equalsIgnoreCase(tag)){
            	tags.add(article);
            }
        }
        return tags;
    }

}
