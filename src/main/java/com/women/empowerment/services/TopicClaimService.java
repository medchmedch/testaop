package com.women.empowerment.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.women.empowerment.entites.Topic;
import com.women.empowerment.entites.TopicClaim;
import com.women.empowerment.repositories.TopicClaimRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class TopicClaimService implements ITopicClaimService {

    @Autowired
    private TopicService topicService;
    @Autowired
    private TopicClaimRepository topicClaimRepository;

    @Override
    public List<TopicClaim> getAll(Long id) {
        Topic tt = topicService.get(id);
        if(tt != null){
            return tt.getTopicClaims();
        }
        return null;
    }

    @Override
    public TopicClaim add(Long id, TopicClaim topicClaim) {
        Topic tt = topicService.get(id);
        if(tt != null){
            topicClaim.setApproved(false);
            topicClaim.setDate_created(LocalDateTime.now());
            tt.getTopicClaims().add(topicClaim);
            topicService.add(tt);
            return topicClaim;
        }
        return null;
    }

    @Override
    public TopicClaim get(Long id) {
        return topicClaimRepository.findById(id).orElse(null);
    }

    @Override
    public TopicClaim approve(Long id, boolean appr) {
        TopicClaim tt = topicClaimRepository.findById(id).orElse(null);
        if(tt != null){
            tt.setApproved(appr);
            return topicClaimRepository.save(tt);
        }
        return null;
    }
}
