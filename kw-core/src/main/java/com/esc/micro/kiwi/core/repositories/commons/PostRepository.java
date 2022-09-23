package com.esc.micro.kiwi.core.repositories.commons;

import com.esc.micro.kiwi.core.model.common.service.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

  /*
  native:
select p
from posts as p
         left join post_tag pt on p.id = pt.post_id
         left join tags t on t.id = pt.tag_id
         left join users u on u.id = p.user_id
         left join category c on p.category_id = c.id
         left join comments c2 on p.id = c2.post_id
where p.status = 1;
   */
  @Query(value = "select p from Post p " +
      "left join fetch p.tags t " +
      "left join fetch p.categories c " +
      "left join fetch p.user u " +
      "where p.status = true ",
      countQuery = "select count (p) from Post p join p.user"
  )
  Page<Post> findAll(Pageable pageable);

  @Query(value = "select p from Post p " +
      "left join fetch p.tags t " +
      "left join fetch p.categories c " +
      "left join fetch p.user u " +
      "where p.status = true and p.id = :id",
      countQuery = "select count (p) from Post p join p.user"
  )
  Optional<Post> findById(@Param("id") Long id);
}
