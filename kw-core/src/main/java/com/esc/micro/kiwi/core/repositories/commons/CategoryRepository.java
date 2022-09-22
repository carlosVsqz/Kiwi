package com.esc.micro.kiwi.core.repositories.commons;

import com.esc.micro.kiwi.core.model.common.service.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
