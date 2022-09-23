package com.esc.micro.kiwi.core.repositories.commons;

import com.esc.micro.kiwi.core.model.common.service.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

  @Query(value = "select count (c.id) from Category as c where c.id = :id")
  int countPostsByCategoryId(@Param("id") Long id);
}
