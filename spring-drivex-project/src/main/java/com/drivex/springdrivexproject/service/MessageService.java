// Package
package com.drivex.springdrivexproject.service;

// Imports
    // Spring.stereotype
import com.drivex.springdrivexproject.dbo.GamaDbo;
import com.drivex.springdrivexproject.dbo.MessageDbo;
import com.drivex.springdrivexproject.model.Car;
import com.drivex.springdrivexproject.model.Gama;
import com.drivex.springdrivexproject.model.Message;
import com.drivex.springdrivexproject.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

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

    // Update Message
    public boolean patchMessage(MessageDbo message) {
        Optional<Message> optionalMessage = messageRepository.findById(message.getIdMessage());
        if(optionalMessage.isPresent()){
            Message messageProvider = optionalMessage.get();
            if(message.getMessageText() != null){
                messageProvider.setMessageText(message.getMessageText());
            }
            if(message.getCar() != null){
                messageProvider.setCar(message.getCar());
            }
            if(message.getClient() != null){
                messageProvider.setClient(message.getClient());
            }
            messageRepository.save(messageProvider);
            return true;
        } else {
            throw new EntityNotFoundException("No se puede actualizar el objeto Example porque no existe en la base de datos.");
        }
    }

        // Delete a Message
    public boolean deleteMessage(Integer idMessage) {
        Optional<Message> optionalMessage = messageRepository.findById(idMessage);

        if (optionalMessage.isPresent())
        {
            Message message = optionalMessage.get();
            messageRepository.deleteById(message.getIdMessage());
            return true;
        }else {
            return false;
        }
    }
}
