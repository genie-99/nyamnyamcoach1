package nyamnyam1;

import java.util.ArrayList;
import java.util.List;

import nyamnyam1.DMO.PostsManagerImpl;
import nyamnyam1.DTO.Comments;
import nyamnyam1.DTO.Overall;
import nyamnyam1.DTO.Posts;

public class Test {
	public static void main(String[] args) {
		PostsManagerImpl pm = PostsManagerImpl.getInstance();
		

		List<Comments> list1 = new ArrayList<>();
		Comments cmt1 = new Comments(1,"이상진","댓글내용", "댓글 날짜");
		list1.add(cmt1);
		
		Posts post1 = new Posts(1,"제목","내용","작가","날짜","카테고리",13,list1);
		
//		Map<String, List<Posts>>
		
		pm.saveData();
		pm.inputData(post1);
		System.out.println(post1);	
	}
}

