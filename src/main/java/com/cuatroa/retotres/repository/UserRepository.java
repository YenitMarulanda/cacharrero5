package com.cuatroa.retotres.repository;

import com.cuatroa.retotres.model.User;
import com.cuatroa.retotres.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author yenit
 */
@Repository
public class UserRepository {
    /**
     * 
     */
    @Autowired
    private UserCrudRepository userCrudRepository;
    /**
     * Lista de Usuarios
     * @return 
     */
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }
    /**
     * Obtener un usuario
     * @param id
     * @return 
     */
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }
    /**
     * Crear un usuario
     * @param user
     * @return 
     */
    public User create(User user) {
        return userCrudRepository.save(user);
    }
    /**
     * Actualiza el usuario
     * @param user 
     */
    public void update(User user) {
        userCrudRepository.save(user);
    }
    /**
     * Borrar un usuario
     * @param user 
     */
    public void delete(User user) {
        userCrudRepository.delete(user);
    }
    /**
     * Validar si exite un email
     * @param email
     * @return 
     */
    public boolean emailExists(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);
        
        return !usuario.isEmpty();
    }
    /**
     * Authenticacion
     * @param email
     * @param password
     * @return 
     */
    public Optional<User> authenticateUser(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
    /**
     * El ultimo usuario
     * @return 
     */
    public Optional<User> lastUserId(){
        return userCrudRepository.findTopByOrderByIdDesc();
    }
    /**
     * Lista de usuarios de un mes determinado
     * @param month
     * @return 
     */
    public List<User> getByMonthBirthtDay(String month){
        return userCrudRepository.findByMonthBirthtDay(month);
    }
}
