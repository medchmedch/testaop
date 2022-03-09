package com.women.empowerment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.women.empowerment.entites.CommentReaction;
import com.women.empowerment.entites.ForumComment;
import com.women.empowerment.entites.Topic;
import com.women.empowerment.repositories.CommentReactionRepository;
import com.women.empowerment.repositories.ForumCommentRepository;
import com.women.empowerment.repositories.TopicRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class ForumCommentService implements IForumCommentService {

    @Autowired
    private ForumCommentRepository repository;
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private CommentReactionRepository commentReactionRepository;


    @Override
    public ForumComment add(ForumComment comment, Long id) {
        Topic c = topicRepository.findById(id).orElse(null);
        if(c == null){
            return null;
        }
        comment.setBanned(false);
        comment.setDatePublished(LocalDateTime.now());
        c.getForumComments().add(comment);
        topicRepository.save(c);
        return comment;
    }

    @Override
    public List<ForumComment> getAll(Long id) {
        Topic c = topicRepository.findById(id).orElse(null);
        if(c == null){
            return null;
        }
        return c.getForumComments();
    }

    @Override
    public ForumComment modify(ForumComment comment, Long id) {
        ForumComment c = repository.findById(id).orElse(null);
        if(c == null){
            return null;
        }
        c.setText(comment.getText());
        return repository.save(c);
    }

    @Override
    public boolean delete(Long id) {
        ForumComment c = repository.findById(id).orElse(null);
        if(c != null){
            c.setDateRemoved(LocalDateTime.now());
            repository.save(c);
            return true;
        }
        return false;
    }

    @Override
    public ForumComment get(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public ForumComment bans(Long id, boolean action) {
        ForumComment c = repository.findById(id).orElse(null);
        if(c != null){
            if(action) {
                c.setDateRemoved(LocalDateTime.now());
            }
            c.setBanned(action);
            return repository.save(c);
        }
        return null;
    }

    @Override
    public List<ForumComment> getReplies(Long id) {
        ForumComment c = repository.findById(id).orElse(null);
        if(c != null){
            return c.getReplies();
        }
        return null;
    }

    @Override
    public ForumComment reply(ForumComment comment, Long id) {
        ForumComment c = repository.findById(id).orElse(null);
        if(c != null){
            comment.setDatePublished(LocalDateTime.now());
            c.getReplies().add(comment);
            return repository.save(c);
        }
        return null;
    }

    @Override
    public ForumComment getReply(Long rep_id) {
        return repository.findById(rep_id).orElse(null);
    }

    @Override
    public ForumComment modifyReply(ForumComment comment, Long rep_id) {
        ForumComment c = repository.findById(rep_id).orElse(null);
        if(c != null){
            c.setText(comment.getText());
            return repository.save(c);
        }
        return null;
    }

    @Override
    public ForumComment deleteReply(Long rep_id) {
        ForumComment c = repository.findById(rep_id).orElse(null);
        if(c != null){
            c.setDateRemoved(LocalDateTime.now());
            return repository.save(c);
        }
        return null;
    }

    @Override
    public CommentReaction react(CommentReaction reaction, Long id) {
        ForumComment fc = repository.findById(id).orElse(null);
        if(fc != null){
            reaction.setDate(LocalDateTime.now());
            fc.getCommentReactionList().add(reaction);
            repository.save(fc);
            return reaction;
        }
        return null;
    }

    @Override
    public List<CommentReaction> getAllReactions(Long id) {
        ForumComment fc = repository.findById(id).orElse(null);
        if(fc != null){
            return fc.getCommentReactionList();
        }
        return null;
    }

    @Override
    public boolean deleteReaction(Long id) {
        ForumComment fc = repository.findById(id).orElse(null);
        if(fc != null){
            //TODO CHECK IF A USER HAS ALREADY A REACTION THEN REMOVE IT\
            return true;
        }
        return false;
    }
}
