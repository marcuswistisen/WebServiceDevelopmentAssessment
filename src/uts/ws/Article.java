package uts.ws;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.sun.xml.internal.txw2.annotation.XmlAttribute;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "article")
public class Article implements Serializable{

	public int id;

	public String author;

	public String tag;

	public String date;

	public String title;
	
	public String previews;

	public String text;

	public Article(){
		super();
	}
//Create Article
	public Article(int id, String author, String tag, String date, String title, String previews, String text) {
		super();
		this.id = 1;
		this.author = author;
		this.tag = tag;
		this.date = date;
		this.title = title;
		this.previews = previews;
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
//Create date
	public Date getDate() throws ParseException {
		Date datep = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		return datep;
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
	
	public String getPreview() {
		return previews;
	}
	
	public void setPreview(String previews) {
		this.previews = previews;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	//Update an article
	public void update(int id, String author, String tag, String date, String title, String previews, String text) {
		setId(id);
		setAuthor(author);
		setTag(tag);
		setDate(date);
		setTitle(title);
		setPreview(previews);
		setText(text);

	}
}