package com.mintic.usa.AlquilerBarcos.Service;


import com.mintic.usa.AlquilerBarcos.Repositoy.MessageRepository;
import com.mintic.usa.AlquilerBarcos.modelo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }
    public Message save(Message message){
        if(message.getIdMessage() == null){
            return messageRepository.save(message);
        }else{
            Optional<Message> aux = messageRepository.getMessage(message.getIdMessage());
            if(aux.isPresent()){
                return message;
            }else{
                return messageRepository.save(message);
            }
        }
    }
    public Message update(Message message){
        if( message.getIdMessage() != null){
            Optional<Message> c = messageRepository.getMessage(message.getIdMessage());
            if (c.isPresent()){
                if(message.getClient() != null){
                    c.get().setClient(message.getClient());
                }
                if (message.getMessageText() !=null){
                    c.get().setMessageText(message.getMessageText());
                }
                if(message.getBoat() !=null){
                    c.get().setBoat(message.getBoat());
                }
                messageRepository.save(c.get());
                return c.get();
            }else {
                return message;
            }
        }else{
            return message;
        }
    }
    public boolean delete(int id){
        boolean flag = false;
        Optional<Message> c = messageRepository.getMessage(id);
        if (c.isPresent()){
            messageRepository.delete(c.get());
        }
        return flag;
    }
}
