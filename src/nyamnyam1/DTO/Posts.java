package nyamnyam1.DTO;

import java.util.List;

public class Posts {
	private int id;
	private String title;
	private String content;
	private String author;
	private String date;
	private String category;
	private int likes;
	List<Comments> comments;
	
	public Posts(int id, String title, String content, String author, String date, String category, int likes,
			List<Comments> comments) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.date = date;
		this.category = category;
		this.likes = likes;
		this.comments = comments;
	}
	
	
	@Override
	public String toString() {
		return "Posts [id=" + id + ", title=" + title + ", content=" + content + ", author=" + author + ", date=" + date
				+ ", category=" + category + ", likes=" + likes + ", comments=" + comments + "]";
	}


	public List<Comments> getComments() {
		return comments;
	}
	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	

}
