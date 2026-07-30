package nyamnyam1.DTO;

import java.util.List;

public class Overall {
	public List<Posts> posts;
	
	public static Overall getInstance () {
		return Instance;
	}
	private static Overall Instance = new Overall();
	
	public List<Posts> getPosts() {
		return posts;
	}

	public void setPosts(List<Posts> posts) {
		this.posts = posts;
	}
	
	
}
