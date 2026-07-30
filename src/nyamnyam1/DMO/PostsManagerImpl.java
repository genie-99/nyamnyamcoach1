package nyamnyam1.DMO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import exception.PostsNotFoundException;
import nyamnyam1.DTO.Overall;
import nyamnyam1.DTO.Posts;

public class PostsManagerImpl implements PostsManager {

	private static List<Posts> postsList = new ArrayList<>();
	private static Gson gson = new Gson();
	Overall overall = Overall.getInstance();

	private PostsManagerImpl() {
		loadData();
	}
	
	private static PostsManagerImpl Instance = new PostsManagerImpl();
	
	public static PostsManagerImpl getInstance() {
		return Instance;
	}


	// 이제 일단 불러서 저장해놓자
	public void loadData() { 
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("community.json")))) {
			String line;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			// sb -> JSON 파일을 문자열로
			//Type PostsListType = new TypeToken<ArrayList<Posts>>() {}.getType();
//			System.out.println("111");
			Overall o = gson.fromJson(sb.toString(), Overall.class);

			postsList = o.getPosts();
			
//			System.out.println("222");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public boolean add(Posts posts) {
		if (postsList.size() <= 10000) {
			postsList.add(posts);
		} else {
			System.out.println("즉당히 쓰자");
			return false;
		}
		return true;
	}

	@Override
	public List<Posts> getAll() {
		return postsList;
	}

	@Override
	public Posts getPosts(int PostsId) {
		for (int i = 0; i < postsList.size(); i++) {
			if (postsList.get(i).getId() == PostsId) {
				return postsList.get(i);
			}
		}
		return null;
	}

	@Override
	public Posts[] searchTitle(String title) {
		int count = 0;
		for (int i = 0; i < postsList.size(); i++) {
			if (postsList.get(i).getTitle().equals(title)) {
				count++;
			}
		}
		Posts[] arr = new Posts[count];
		int index = 0;
		for (int i = 0; i < postsList.size(); i++) {
			if (postsList.get(i).getTitle().equals(title)) {
				arr[index++] = postsList.get(i);
			}
		}
		return arr;
	}

	@Override
	public void update(Posts posts) throws PostsNotFoundException {
		
			for(int i =0; i<postsList.size();i++) {
				if(postsList.get(i).getId() == posts.getId()) {
					postsList.set(i,posts);
				}
			}
		

	}

	@Override
	public boolean delete(int PostsId) {
		for(int i =0; i<postsList.size();i++) {
			if(postsList.get(i).getId() == PostsId) {
				for(int j = i; j<postsList.size(); j++) {
					postsList.set(j, postsList.get(j+1));
				}
				postsList.set(postsList.size()+1, null);
			}
		}
		return false;
	}
	
	
	public void inputData(Posts posts) {

		postsList.add(posts);
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("community.json")))) {
			bw.write(gson.toJson(overall));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("저장하는데 오류가 생긴것 같은데 너가 해결 해줭~ ㅋ");
		}
	}
	
	
	
	@Override
	public void saveData() {
		System.out.println(postsList);
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("community.json")))) {
			bw.write(gson.toJson(overall));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("저장하는데 오류가 생긴것 같은데 너가 해결 해줭~ ㅋ");
		}
	}

//	@Override
//	public void loadData() {
//		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/community.json")))) {
//			String line;
//			StringBuilder sb = new StringBuilder();
//			while ((line = br.readLine()) != null) {
//				sb.append(line);
//			}
//			// sb -> JSON 파일을 문자열로
//			Type PostsListType = new TypeToken<ArrayList<Posts>>() {
//			}.getType();
//			List<Posts> PostsList = gson.fromJson(sb.toString(), PostsListType);
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			System.out.println("나머지는 난 잘 모르겠다");
//		}

	}


