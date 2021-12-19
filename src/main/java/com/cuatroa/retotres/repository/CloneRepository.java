package com.cuatroa.retotres.repository;

import com.cuatroa.retotres.model.Clone;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cuatroa.retotres.repository.crud.CloneCrudRepository;

/**
 *
 * @author desaextremo
 */
@Repository
public class CloneRepository {
    @Autowired
    private CloneCrudRepository cloneCrudRepository;

    public List<Clone> getAll() {
        return cloneCrudRepository.findAll();
    }

    public Optional<Clone> getClone(int id) {
        return cloneCrudRepository.findById(id);
    }
        
    public Clone create(Clone clone) {
        return cloneCrudRepository.save(clone);
    }

    public void update(Clone clone) {
        cloneCrudRepository.save(clone);
    }
    
    public void delete(Clone clone) {
        cloneCrudRepository.delete(clone);
    }
    
    public List<Clone> getByPrice(double Price){
        return cloneCrudRepository.findByPrice(Price);
    }
    
    public List<Clone> getByDescriptionContains(String description){
        return cloneCrudRepository.findByDescriptionContainingIgnoreCase(description);
    }
}
