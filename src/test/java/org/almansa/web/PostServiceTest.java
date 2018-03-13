package org.almansa.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.almansa.app.core.board.DefaultTextBoard;
import org.almansa.app.core.post.Post;
import org.almansa.app.core.repository.board.BoardRepository;
import org.almansa.app.core.service.post.PostService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/root-context.xml",
        "classpath*:spring/appServlet/servlet-context.xml" })
public class PostServiceTest {

    @Autowired
    PostService service;

    @Autowired
    BoardRepository boardRepo;

    @Before
    public void before() {
        boardRepo.update(new DefaultTextBoard((long) 1, "�옄�쑀寃�", new Date(), new ArrayList<String>(), 300, true));
        boardRepo.update(new DefaultTextBoard((long) 2, "媛쒕컻寃�", new Date(), new ArrayList<String>(), 300, true));
    }

    @Test
    public void boardAddTest() {

        service.writeNewPost(new Long(1), new Long(1), "�븞�뀞", "hihihi");
        service.writeNewPost(new Long(1), new Long(1), "123", "1234");
        service.writeNewPost(new Long(1), new Long(1), "1324", "12345");
        service.writeNewPost(new Long(2), new Long(1), "媛쒕컻寃�", "12345");

        List<Post> posts = service.getWritersPosts(new Long(1));

        System.out.println(posts.size());
        System.out.println(posts.toString());
    }
}


