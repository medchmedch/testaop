package com.women.empowerment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.women.empowerment.entites.ForumComment;


@Repository
public interface ForumCommentRepository extends JpaRepository<ForumComment, Long> {
}
