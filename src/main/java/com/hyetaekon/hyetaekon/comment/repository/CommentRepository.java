package com.hyetaekon.hyetaekon.comment.repository;

import com.hyetaekon.hyetaekon.comment.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Page<Comment> findByPostId(Long postId, Pageable pageable);
    Page<Comment> findByPostIdAndParentId(Long postId, Long parentId, Pageable pageable);
}
