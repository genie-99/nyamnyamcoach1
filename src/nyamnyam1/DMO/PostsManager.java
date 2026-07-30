package nyamnyam1.DMO;

import java.util.List;

import exception.PostsNotFoundException;
import nyamnyam1.DTO.Posts;

public interface PostsManager {
	
	
	//CRUD 구현부는 ;으로 대체
		//등록
		public abstract boolean add(Posts posts);
		//조회(전체, 상세, 검색, ...)
		public abstract List<Posts> getAll();
		public abstract Posts getPosts(int PostsId);
		//검색 -> 이름 검색으로 한정
		public abstract Posts[] searchTitle(String title); 
		//수정
		public abstract void update(Posts posts) throws PostsNotFoundException;
		//삭제
		public abstract boolean delete(int PostsId);
		//저장
		public abstract void saveData();
		//불어오기
		public abstract void loadData();
		
}
