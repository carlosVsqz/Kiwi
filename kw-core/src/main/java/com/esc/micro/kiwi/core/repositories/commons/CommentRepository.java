package com.esc.micro.kiwi.core.repositories.commons;

import com.esc.micro.kiwi.core.model.common.user.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
