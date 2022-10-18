package com.mintic.usa.AlquilerBarcos.Repositoy;


import com.mintic.usa.AlquilerBarcos.Repositoy.Crud.ScoreCrudRepository;
import com.mintic.usa.AlquilerBarcos.modelo.Score;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {

    private ScoreCrudRepository scoreCrudRepository;

    public List<Score> getAll(){
        return (List<Score>) scoreCrudRepository.findAll();
    }
    public Optional<Score> getScore(int id){
        return scoreCrudRepository.findById(id);
    }
    public Score save(Score score){
        return scoreCrudRepository.save(score);
    }
    public void delete(Score score){
        scoreCrudRepository.delete(score);
    }


}
