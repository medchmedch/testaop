package com.women.empowerment.services;


import java.util.List;

import com.women.empowerment.entites.ForumAd;

public interface IForumAdService {
    List<ForumAd> getAll();
    ForumAd add(ForumAd ad);
    ForumAd modidy(ForumAd ad, Long id);
    boolean delete(Long id);
    ForumAd getOne(Long id);
    void click(Long id);
}
