package com.women.empowerment.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.women.empowerment.entites.Topic;
import com.women.empowerment.entites.TopicRate;
import com.women.empowerment.repositories.TopicRateRepository;
import com.women.empowerment.repositories.TopicRepository;

import tn.dalhia.entities.enumerations.VoteType;


import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TopicService implements ITopicService {

    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private TopicRateRepository topicRateRepository;

    @Override
    public List<Topic> getAll() {
        return topicRepository.findAll();
    }

    @Override
    public Topic add(Topic topic) {
        topic.setBanned(false);
        topic.setDateRemoved(null);
        topic.setScore(0);
        topic.setDatePublished(LocalDateTime.now());
        return topicRepository.save(topic);
    }

    @Override
    public Topic modify(Topic topic, Long id) {
        Topic t1 = this.get(id);
        if(t1 == null){
            return null;
        }
        t1.setTitle(topic.getTitle());
        t1.setText(topic.getText());
        t1.setTag(topic.getTag());
        return topicRepository.save(topic);
    }

    @Override
    public Topic get(Long id) {
        return topicRepository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(Long id) {
        Topic tt = topicRepository.findById(id).orElse(null);
        if(tt != null){
            tt.setDateRemoved(LocalDateTime.now());
            topicRepository.save(tt);
            return true;
        }
        return false;
    }

    @Override
    public boolean bans(Long id, boolean ban) {
        Topic tt = topicRepository.findById(id).orElse(null);
        if(tt != null){
            if(ban){
                tt.setDateRemoved(LocalDateTime.now());
            }
            tt.setBanned(ban);
            topicRepository.save(tt);
            return true;
        }
        return false;
    }

    @Override
    public TopicRate addRate(VoteType voteType, Long id) {
        Topic tt = topicRepository.findById(id).orElse(null);
        if(tt != null){
            TopicRate tr = new TopicRate();
            tr.setDate(LocalDateTime.now());
            tr.setVoteType(voteType);
            tt.getTopicRateList().add(tr);
            topicRepository.save(tt);
            return tr;
        }
        return null;
    }

    @Override
    public boolean RemoveRate(Long id) {
        Topic tt = topicRepository.findById(id).orElse(null);
        if(tt != null){
            //topicRateRepository.deleteById();
            return true;
        }
        return false;
    }

    @Override
    public List<TopicRate> getRate(Long id) {
        Topic tt = topicRepository.findById(id).orElse(null);
        if(tt != null){
            return tt.getTopicRateList();
        }
        return null;
    }

}
