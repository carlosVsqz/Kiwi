package core.esc.micro.kiwi.core.test;

import com.esc.micro.kiwi.core.KiwiCore;
import com.esc.micro.kiwi.core.model.common.service.Category;
import com.esc.micro.kiwi.core.model.common.service.Post;
import com.esc.micro.kiwi.core.model.common.service.Tag;
import com.esc.micro.kiwi.core.model.common.user.Comment;
import com.esc.micro.kiwi.core.model.common.user.User;
import com.esc.micro.kiwi.core.repositories.commons.CategoryRepository;
import com.esc.micro.kiwi.core.repositories.commons.CommentRepository;
import com.esc.micro.kiwi.core.repositories.commons.PostRepository;
import com.esc.micro.kiwi.core.repositories.commons.TagRepository;
import com.esc.micro.kiwi.core.repositories.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = KiwiCore.class)
public class PostTest {

  @Resource
  private PostRepository postRepository;

  @Resource
  private UserRepository userRepository;

  @Resource
  private TagRepository tagRepository;

  @Resource
  private CategoryRepository categoryRepository;

  @Resource
  private CommentRepository commentRepository;

  @Test
  public void saveNewPost() {
    Post post = new Post();

    post.setName("post 1");
    post.setImage("https://imgblur.com/qwerty");

    List<Tag> tags = new ArrayList<>();

    tags.add(new Tag("tag1"));
    tags.add(new Tag("tag2"));
    tags.add(new Tag("tag3"));

    post.setTags(tagRepository.saveAllAndFlush(tags));

    Optional<User> user = userRepository.findByEmail("carlos.vasquez@escod.com");

    if (user.isPresent()) {
      post.setUser(user.get());
    }

    post.setType("typeX");
    post.setTitle("titulo");
    post.setCategory(categoryRepository.saveAndFlush(new Category("random")));

//    List<Comment> comments = new ArrayList<>();
//
//    comments.add(new Comment("aaaa"));
//    comments.add(new Comment("aaaa1"));
//    comments.add(new Comment("aaaa2"));
//    comments.add(new Comment("aaaa3"));
//    post.setComments(commentRepository.saveAllAndFlush(comments));
    post.setContent("Más vale tarde, porque por la mañana duermo");
    post.setDescription("Esta ingeniosa frase bromea con el popular refrán “más vale tarde que nunca”, y le da un giro cómico.");
    post.setURLStorage("https://www.pinterest.com/EuOvalles/");
    post.setStatus(true);

    postRepository.save(post);
  }
}
