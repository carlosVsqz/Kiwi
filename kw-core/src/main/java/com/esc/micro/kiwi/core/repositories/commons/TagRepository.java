package com.esc.micro.kiwi.core.repositories.commons;

import com.esc.micro.kiwi.core.model.common.service.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}
