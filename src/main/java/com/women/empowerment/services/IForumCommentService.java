package com.women.empowerment.services;



import java.util.List;

import com.women.empowerment.entites.CommentReaction;
import com.women.empowerment.entites.ForumComment;

public interface IForumCommentService {
    ForumComment add(ForumComment comment, Long id);
    List<ForumComment> getAll(Long id);
    ForumComment modify(ForumComment comment, Long id);
    boolean delete(Long id);
    ForumComment get(Long id);
    ForumComment bans(Long id, boolean action);
    List<ForumComment> getReplies(Long id);
    ForumComment reply(ForumComment comment, Long id);
    ForumComment getReply(Long rep_id);
    ForumComment modifyReply(ForumComment comment, Long rep_id);
    ForumComment deleteReply(Long rep_id);
    CommentReaction react(CommentReaction reaction, Long id);
    List<CommentReaction> getAllReactions(Long id);
    boolean deleteReaction(Long id);
}
