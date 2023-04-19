// Package
package com.drivex.springdrivexproject.service;

// Imports
    // Spring.stereotype
import com.drivex.springdrivexproject.model.Message;
import com.drivex.springdrivexproject.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Annotations

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    // Methods

    // All Message
    public List<Message> getAll() {return messageRepository.findAll();}

    // Search a Message


    // Save a Message
    public Message save(Message message) {return messageRepository.save(message);}
}
