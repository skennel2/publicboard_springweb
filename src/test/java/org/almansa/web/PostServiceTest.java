package org.almansa.web;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.almansa.app.core.board.DefaultTextBoard;
import org.almansa.app.core.post.Post;
import org.almansa.app.core.service.repository.BoardMockRepository;
import org.almansa.app.core.service.repository.BoardRepository;
import org.almansa.app.core.service.repository.MemberMockRepository;
import org.almansa.app.core.service.repository.PostMockRepository;
import org.almansa.app.service.postService.PostService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class PostServiceTest {

	@Autowired
	PostService service;
	
	@Autowired
	BoardRepository boardRepo;
	
	@Before
	public void before() {
		boardRepo.update(new DefaultTextBoard(1, "�옄�쑀寃�", new Date(), new ArrayList<String>(), 300, true));
		boardRepo.update(new DefaultTextBoard(2, "媛쒕컻寃�", new Date(), new ArrayList<String>(), 300, true));
	}
	
	@Test
	public void boardAddTest() {
		
		service.writeNewPost(1, 1, "�븞�뀞", "hihihi");
		service.writeNewPost(1, 1, "123", "1234");
		service.writeNewPost(1, 1, "1324", "12345");
		service.writeNewPost(2, 1, "媛쒕컻寃�", "12345");

		List<Post> posts = service.getWritersPosts(1);	
		
		System.out.println(posts.size());
		System.out.println(posts.toString());
	}	
}
