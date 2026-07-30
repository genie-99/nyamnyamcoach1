package exception;

public class PostsNotFoundException extends Exception{
	private String title;
	
	public PostsNotFoundException(String title) {
		super(title + ": ㅋ 없어^^");
	}
	
}
