package com.women.empowerment.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.women.empowerment.entites.ForumAd;
import com.women.empowerment.services.IForumAdService;

import tn.dalhia.entities.enumerations.ChannelType;


import java.util.List;

@RestController
@RequestMapping("/forum/ads")
public class ForumAdController {

    @Autowired
    private IForumAdService service;

    @PostMapping()
    public ResponseEntity<ForumAd> add(@RequestBody ForumAd ad){
        ForumAd b = service.add(ad);
        if(b == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    null
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                b
        );
    }
    @GetMapping()
    public ResponseEntity<List<ForumAd>> getall(){
        List<ForumAd> b = service.getAll();
        if(b == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    null
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                b
        );
    }
    @PutMapping("/{id}")
    public ResponseEntity<ForumAd> mod(@RequestBody ForumAd ad, @PathVariable("id") Long id){
        ForumAd b = service.modidy(ad, id);
        if(b == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    null
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                b
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<ForumAd> getone(@PathVariable("id") Long id){
        ForumAd b = service.getOne(id);
        if(b == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    null
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                b
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id){
        boolean b = service.delete(id);
        if(!b){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    false
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                true
        );
    }
    @PostMapping("/{id}/clicks")
    public void clk(@PathVariable("id") Long id){
        service.click(id);
    }
}
