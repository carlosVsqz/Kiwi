package core.esc.micro.kiwi.core.test;

import com.esc.micro.kiwi.core.KiwiCore;
import com.esc.micro.kiwi.core.model.common.service.Category;
import com.esc.micro.kiwi.core.model.common.service.Post;
import com.esc.micro.kiwi.core.model.common.service.Tag;
import com.esc.micro.kiwi.core.model.common.user.User;
import com.esc.micro.kiwi.core.repositories.commons.CategoryRepository;
import com.esc.micro.kiwi.core.repositories.commons.CommentRepository;
import com.esc.micro.kiwi.core.repositories.commons.PostRepository;
import com.esc.micro.kiwi.core.repositories.commons.TagRepository;
import com.esc.micro.kiwi.core.repositories.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;

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

    tagRepository.saveAllAndFlush(tags);

    post.setTags(Set.copyOf(tags));

//    post.setTags(tagRepository.saveAllAndFlush((Iterable<Tag>) tags));

    Optional<User> user = userRepository.findByEmail("carlos.vasquez@escod.com");

    if (user.isPresent()) {
      post.setUser(user.get());
    }

    post.setType("typeX");
    post.setTitle("titulo");

    post.setContent("Más vale tarde, porque por la mañana duermo");
    post.setDescription("Esta ingeniosa frase bromea con el popular refrán “más vale tarde que nunca”, y le da un giro cómico.");
    post.setURLStorage("https://www.pinterest.com/EuOvalles/");
    post.setStatus(true);
    post.setPublicDate(new Date());
    postRepository.save(post);

    List<Category> categories = new ArrayList<>();
    categories.add(new Category("categoria 1"));
    categories.add(new Category("categoria 2"));
    categories.add(new Category("categoria 3"));
    categories.add(new Category("categoria 4"));

    categoryRepository.saveAll(categories);

    post.setCategories(Set.copyOf(categories));

    postRepository.saveAndFlush(post);
  }

  @Test
  void createPostUsingData(){
    Post post = new Post();

    //set user
    Optional<User> user = userRepository.findByEmail("carlos.vasquez@escod.com");
    if (user.isPresent()) {
      post.setUser(user.get());
    }

    //common data
    post.setType("tipo b");
    post.setTitle("Las pasas dulces de la calle");
    post.setName("post 1");
    post.setImage("https://imgblur.com/qwerty");

    post.setContent("Más vale tarde, porque por la mañana duermo");
    post.setDescription("Esta ingeniosa frase bromea con el popular refrán “más vale tarde que nunca”, y le da un giro cómico.");
    post.setURLStorage("https://www.pinterest.com/EuOvalles/");
    post.setStatus(true);
    post.setPublicDate(new Date());

    //set tags
    post.setTags(Set.copyOf(tagRepository.findAll()));

    //set Category 1
    Long id [] = {1L};

    List<Category> categories = categoryRepository.findAllById(Arrays.asList(id));

    post.setCategories(Set.copyOf(categories));

    postRepository.save(post);

  }
}
