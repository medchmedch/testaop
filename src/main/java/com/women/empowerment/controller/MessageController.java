package com.women.empowerment.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.women.empowerment.entites.Message;
import com.women.empowerment.services.IMessageService;

import java.util.List;

@RestController
@RequestMapping("/forum/channels")
public class MessageController {

    @Autowired
    private IMessageService messageService;

    @PostMapping("/{id}/messages")
    public ResponseEntity<Message> newMessage(@RequestBody Message message, @PathVariable("id") Long channel_id){
        Message b = messageService.postNewMessage(channel_id, message);
        if(b == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    null
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                b
        );
    }
    @GetMapping("/{id}/messages")
    public ResponseEntity<List<Message>> getAllMessages(@PathVariable("id") Long channel_id){
        List<Message> b = messageService.getAllFromChannel(channel_id);
        if(b == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    null
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                b
        );
    }
    @PostMapping("/messages/{usr}/")
    public ResponseEntity<Message> postFirstMessage(@PathVariable("usr") Long usr, @RequestBody Message msg){
        Message b = messageService.postFirstMessage(usr, msg);
        if(b == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    null
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                b
        );
    }
    @DeleteMapping("/messages/q/{id_msg}/")
    public ResponseEntity<Boolean> deleteMessage(@PathVariable("id_msg") Long id_msg){
        boolean b = messageService.deleteAndBan(id_msg);
        if(!b){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    false
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                true
        );
    }
}
