package com.cuatroa.retotres.repository.crud;

import com.cuatroa.retotres.model.Clone;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author desaextremo
 */
public interface CloneCrudRepository extends MongoRepository<Clone, Integer> {
    public List<Clone> findByPrice(double price);  
    /**
     * permite hacer la busqueda con mayusculas o minusculas
     * @param description
     * @return 
     */
    public List<Clone> findByDescriptionContainingIgnoreCase(String description);
}
