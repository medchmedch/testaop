package com.women.empowerment.services;


import tn.dalhia.entities.enumerations.VoteType;

import java.util.List;

import com.women.empowerment.entites.Topic;
import com.women.empowerment.entites.TopicRate;

public interface ITopicService {
    List<Topic> getAll();
    Topic add(Topic topic);
    Topic modify(Topic topic, Long id);
    Topic get(Long id);
    boolean delete(Long id);
    boolean bans(Long id, boolean ban);
    TopicRate addRate(VoteType voteType, Long id);
    boolean RemoveRate(Long id);
    List<TopicRate> getRate(Long id);
}
