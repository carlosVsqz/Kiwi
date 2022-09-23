package com.esc.micro.kiwi.core.repositories.commons;

import com.esc.micro.kiwi.core.model.common.service.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

  @Query(value = "select count(category.id) " +
      "from category " +
      "left join post_category pc on category.id = pc.category_id " +
      "left join posts p on pc.post_id = p.id " +
      "where category.id = :id",
      nativeQuery = true)
  int countPostsByCategoryId(@Param("id") Long id);
}
