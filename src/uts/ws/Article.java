package uts.ws;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "article")
public class Article implements Serializable{

	public int id;
	
	public String author;
	
	public String tag;
	
	public String date;
	 
	public String title;
	
	public String text;
	
	public Article(){
		super();
	}
	
	public Article(int id, String author, String tag, String date, String title, String text) {
		super();
		this.id = id;
		this.author = author;
		this.tag = tag;
		this.date = date;
		this.title = title;
		this.text = text;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getTag() {
		return tag;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public void update(int id, String author, String tag, String date, String title, String text) {
		setId(id);
		setAuthor(author);
		setTag(tag);
		setDate(date);
		setTitle(title);
		setText(text);
		
	}
}
