package pl.sleipnjs.ankietaobywatelska.model;

import javax.persistence.*;

@Entity
@Table(name = "form")
public class Form {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "image_link")
	private String imageLink;

	@Column(name = "response_counter")
	private int responseCounter;

	@Column(name = "category")
	private String category;

	@Column(name = "author")
	private String author;

	@Column(name = "createdAt")
	private String createdAt;


	public Form() {

	}

	public Form(long id, String title, String description, String imageLink, int responseCounter, String category, String author, String createdAt) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.imageLink = imageLink;
		this.responseCounter = responseCounter;
		this.category = category;
		this.author = author;
		this.createdAt = createdAt;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public String getImageLink() {
		return imageLink;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getCategory() {
		return category;
	}

	public int getResponseCounter() {
		return responseCounter;
	}

	public void setResponseCounter(int responseCounter) {
		this.responseCounter = responseCounter;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}
}
