package nyamnyam1.DTO;

public class Comments {
	private long id;
	private String author;
	private String content;
	private String date;
	
	public Comments() {}
	
	public Comments(long id, String author, String content, String date) {
		super();
		this.id = id;
		this.author = author;
		this.content = content;
		this.date = date;
	}


	@Override
	public String toString() {
		return "Comments [id=" + id + ", author=" + author + ", content=" + content + ", date=" + date + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
