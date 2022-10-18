package com.mintic.usa.AlquilerBarcos.Service;


import com.mintic.usa.AlquilerBarcos.Repositoy.ClientRepository;
import com.mintic.usa.AlquilerBarcos.modelo.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }
    public Client save(Client client){
        if(client.getIdClient() == null){
            return clientRepository.save(client);
        }else{
            Optional<Client> aux = clientRepository.getClient(client.getIdClient());
            if(aux.isPresent()){
                return client;
            }else{
                return clientRepository.save(client);
            }
        }
    }
    public Client update(Client client){
        if(client.getIdClient() != null){
            Optional<Client> c = clientRepository.getClient(client.getIdClient());
            if (c.isPresent()){
                if(client.getName() != null){
                    c.get().setName(client.getName());
                }
                if (client.getEmail() !=null){
                    c.get().setEmail(client.getEmail());
                }
                if(client.getAge() !=null){
                    c.get().setAge(client.getAge());
                }if(client.getMessages() !=null){
                    c.get().setMessages(client.getMessages());
                }
                if(client.getPassword() !=null){
                    c.get().setPassword(client.getPassword());
                }
                if(client.getReservations() !=null){
                    c.get().setReservations(client.getReservations());
                }
                clientRepository.save(c.get());
                return c.get();
            }else {
                return client;
            }
        }else{
            return client;
        }
    }
    public boolean delete(int id){
        boolean flag = false;
        Optional<Client> c = clientRepository.getClient(id);
        if (c.isPresent()){
            clientRepository.delete(c.get());
        }
        return flag;
    }
}
