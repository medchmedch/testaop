package com.women.empowerment.services;


import java.util.List;

import com.women.empowerment.entites.Message;

public interface IMessageService {
    List<Message> getAllFromChannel(Long id_channel);
    Message postNewMessage(Long id_channel, Message msg);
    Message postFirstMessage(Long usr, Message msg);
    boolean deleteAndBan(Long msg_id);
}
