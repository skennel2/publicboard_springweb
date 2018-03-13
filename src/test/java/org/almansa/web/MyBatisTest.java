package org.almansa.web;

import org.almansa.app.core.repository.post.PostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/root-context.xml",
"classpath*:spring/appServlet/servlet-context.xml" })
public class MyBatisTest {

    @Autowired
    PostRepository repo; 
    
    @Test
    public void test() {
        repo.getAll();
    }
}
