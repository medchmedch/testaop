package com.women.empowerment.services;


import tn.dalhia.entities.enumerations.ChannelType;

import java.util.List;

import com.women.empowerment.entites.Channel;

public interface IChannelService {
    List<Channel> getChannelsByType(ChannelType channelType);
    Channel addNewChannel(ChannelType channelType,  Channel channel);
    Channel getChannel(Long id);
    boolean deleteChannel(Long id);
    Channel modChannel(Long id, Channel channel);
}
