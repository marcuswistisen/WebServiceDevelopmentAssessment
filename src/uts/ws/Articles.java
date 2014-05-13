package uts.ws;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

    public ArrayList<Article> findById(int id) {
    		ArrayList<Article> articles = new ArrayList<Article>();
    		for (Article article : list) {
    	            if (article.getId() == id)
    	 articles.add(article);
    	        }
    	 return articles;
    	    }
    
    public ArrayList<Article> findByTag(String tag, Date startDate, Date endDate) throws ParseException {
    	ArrayList<Article> tags = new ArrayList<Article>();
    	String noStartDateString = "11/11/1111";
    	String noEndDateString = "11/11/2999";
    	Date noStartDate = new SimpleDateFormat("MM/dd/yyyy").parse(noStartDateString);
    	Date noEndDate = new SimpleDateFormat("MM/dd/yyyy").parse(noEndDateString);
    	if(startDate == null)
    		startDate = noStartDate;
    	if(endDate == null)
    		endDate = noEndDate;
       
    	for (Article article : list) {
        	if (article.getDate().compareTo(startDate) >= 0 && startDate != noStartDate){
        		if (article.getDate().compareTo(endDate) <=0 && endDate != noEndDate){
        			if (article.getTag().equalsIgnoreCase(tag)){
        				tags.add(article);
        			}
        			if(tag == null){
        				tags.add(article);
        				
        			}
        		}
        		if(endDate == noEndDate){
        			if (article.getTag().equalsIgnoreCase(tag))
        				tags.add(article);
        			if(tag == null)
        				tags.add(article);
        		}    
        	}
        	
        	if (article.getDate().compareTo(endDate) <= 0 && endDate != noStartDate && startDate == noStartDate){
        		
        		if (article.getTag().equalsIgnoreCase(tag)){
    				tags.add(article);
    			}
    			if(tag == null){
    				tags.add(article);
    				
    			}
        	}
        }
        return tags;
    }
}
