package com.women.empowerment.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.women.empowerment.entites.Channel;
import com.women.empowerment.repositories.ChannelRepository;

import tn.dalhia.entities.enumerations.ChannelType;

import tn.dalhia.utils.EnumUtils;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ChannelService implements IChannelService {

    @Autowired
    private ChannelRepository channelRepository;

    @Override
    public List<Channel> getChannelsByType(ChannelType channelType) {
        if(EnumUtils.isInEnum(channelType.toString(), ChannelType.class)){
            List<Channel> li = new ArrayList<>();
            for(Channel c : channelRepository.findAll()){
                if(c.getChannelType() == channelType){
                    li.add(c);
                }
            }
            return li;
        }
        return null;
    }

    @Override
    public Channel addNewChannel(ChannelType channelType, Channel channel) {
        if(EnumUtils.isInEnum(channelType.toString(), ChannelType.class)){
            channel.setChannelType(channelType);
            channel.setDateCreated(LocalDateTime.now());
            return channelRepository.save(channel);
        }
        return null;
    }

    @Override
    public Channel getChannel(Long id) {
        Channel c = channelRepository.findById(id).orElse(null);
        if(c != null){
            return c;
        }
        return null;
    }

    @Override
    public boolean deleteChannel(Long id) {
        Channel c = channelRepository.findById(id).orElse(null);
        if(c != null){
            channelRepository.delete(c);
            return true;
        }
        return false;
    }

    @Override
    public Channel modChannel(Long id, Channel channel) {
        Channel c = channelRepository.findById(id).orElse(null);
        if(c != null){
            c.setName(channel.getName());
            c.setAccess(channel.getAccess());
            return channelRepository.save(c);
        }
        return null;
    }
}
