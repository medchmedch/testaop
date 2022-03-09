package com.women.empowerment.services;



import java.util.List;

import com.women.empowerment.entites.TopicClaim;

public interface ITopicClaimService {
    List<TopicClaim> getAll(Long id);
    TopicClaim add(Long id, TopicClaim topicClaim);
    TopicClaim get(Long id);
    TopicClaim approve(Long id, boolean appr);
}
