package com.mintic.usa.AlquilerBarcos.Service;


import com.mintic.usa.AlquilerBarcos.Repositoy.ScoreRepository;
import com.mintic.usa.AlquilerBarcos.modelo.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();
    }
    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }
    public Score save(Score score){
        if(score.getIdScore() == null){
            return scoreRepository.save(score);
        }else{
            Optional<Score> aux = scoreRepository.getScore(score.getIdScore());
            if(aux.isPresent()){
                return score;
            }else{
                return scoreRepository.save(score);
            }
        }
    }
    public Score update(Score score){
        if(score.getIdScore() != null){
            Optional<Score> c = scoreRepository.getScore(score.getIdScore());
            if (c.isPresent()){
                if(score.getMessageText() != null){
                    c.get().setMessageText(score.getMessageText());
                }
                if (score.getReservation() !=null){
                    c.get().setReservation(score.getReservation());
                }
                if(score.getStarts() !=null){
                    c.get().setStarts(score.getStarts());
                }
                scoreRepository.save(c.get());
                return c.get();
            }else {
                return score;
            }
        }else{
            return score;
        }
    }
    public boolean delete(int id){
        boolean flag = false;
        Optional<Score> c = scoreRepository.getScore(id);
        if (c.isPresent()){
            scoreRepository.delete(c.get());
        }
        return flag;
    }
}
