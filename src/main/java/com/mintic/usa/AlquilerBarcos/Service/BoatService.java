package com.mintic.usa.AlquilerBarcos.Service;

import com.mintic.usa.AlquilerBarcos.Repositoy.BoatRepository;
import com.mintic.usa.AlquilerBarcos.modelo.Boat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BoatService {
    @Autowired
    private BoatRepository boatRepository;

    public List<Boat> getAll(){
        return boatRepository.getAll();
    }
    public Optional<Boat> getBoat(int id){
        return boatRepository.getBoat(id);
    }
    public Boat save(Boat boat){
        if(boat.getId() == null){
            return boatRepository.save(boat);
        }else{
            Optional<Boat> aux = boatRepository.getBoat(boat.getId());
            if(aux.isPresent()){
                return boat;
            }else{
                return boatRepository.save(boat);
            }
        }
    }
    public Boat update(Boat boat){
        if(boat.getId() != null){
            Optional<Boat> c = boatRepository.getBoat(boat.getId());
            if (c.isPresent()){
                if(boat.getName() != null){
                    c.get().setName(boat.getName());
                }
                if (boat.getDescription() !=null){
                    c.get().setDescription(boat.getDescription());
                }
                if(boat.getCategory() !=null){
                    c.get().setCategory(boat.getCategory());
                }
                boatRepository.save(c.get());
                return c.get();
            }else {
                return boat;
            }
        }else{
            return boat;
        }
    }
    public boolean delete(int id){
        boolean flag = false;
        Optional<Boat> c = boatRepository.getBoat(id);
        if (c.isPresent()){
            boatRepository.delete(c.get());
        }
        return flag;
    }
}

