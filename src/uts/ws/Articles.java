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

    public Article findById(int id) {
    		for (Article article : list) {
    	            if (article.getId() == id)
    	 return article;
    	        }
			return null;
    	    }
    
    //Searching by tag, Start Date and End Date
    public ArrayList<Article> findByTag(String tag, String startDate, String endDate) throws ParseException {
    	ArrayList<Article> tags = new ArrayList<Article>();
    	String noStartDateStr = "01/01/1999";
    	String noEndDateStr = "11/11/2099";
    	Date noStartDate = new SimpleDateFormat("dd/MM/yyyy").parse(noStartDateStr);
    	Date noEndDate = new SimpleDateFormat("dd/MM/yyyy").parse(noEndDateStr);
    	Date startDate1 = noStartDate;
    	Date endDate1 = noEndDate;
    	if (startDate.length() > 4)
    	startDate1 = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
    	if (endDate.length() > 4)
    	endDate1 = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
    	for (Article article : list) {
        	if ((article.getDate().after(startDate1) || article.getDate().equals(startDate1)) && !startDate1.equals(noStartDate)){
        		if ((article.getDate().before(endDate1) || article.getDate().equals(endDate1)) && !endDate1.equals(noEndDate)){
        			if (article.getTag().equalsIgnoreCase(tag)){
        				tags.add(article);
        			}
        			if(!article.getTag().equalsIgnoreCase(tag) && tag.equalsIgnoreCase("all")){
        				tags.add(article);
        				
        			}
        		}
        		if(endDate1.equals(noEndDate)){
        			if (article.getTag().equalsIgnoreCase(tag))
        				tags.add(article);
        			if(!article.getTag().equalsIgnoreCase(tag) && tag.equalsIgnoreCase("all"))
        				tags.add(article);
        		}
        		
        	}
        	
        	if ((article.getDate().before(endDate1) || article.getDate().equals(endDate1)) && !endDate1.equals(noEndDate) && startDate1.equals(noStartDate)){

        		if (article.getTag().equalsIgnoreCase(tag)){
    				tags.add(article);
    			}
    			if(!article.getTag().equalsIgnoreCase(tag) && tag.equalsIgnoreCase("all")){
    				tags.add(article);
    				
    			}

        	}
        	
        	if(startDate1.equals(noStartDate) && endDate1.equals(noEndDate) && article.getTag().equalsIgnoreCase(tag)){
        		tags.add(article);
        	}
        	
        	
        }
        return tags;
    }
}
