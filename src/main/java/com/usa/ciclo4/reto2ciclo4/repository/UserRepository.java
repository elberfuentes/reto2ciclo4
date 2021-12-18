package com.usa.ciclo4.reto2ciclo4.repository;

import java.util.List;
import java.util.Optional;
import com.usa.ciclo4.reto2ciclo4.model.User;
import com.usa.ciclo4.reto2ciclo4.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 * @author Elber Fernando Fuentes Moreno
 */
@Repository
public class UserRepository {
    @Autowired
    /**
     * 
     */
    private UserCrudRepository userCrudRepository;
    /**
     * consulta
     * @return
     */
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }
    /**
     * consulta
     * @param id
     * @return
     */
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }
    /**
     * graba
     * @param user
     * @return
     */
    public User save(User user) {
        return userCrudRepository.save(user);
    }
    /**
     * actualiza
     * @param user
     */
    public void update(User user){
        userCrudRepository.save(user);
    }
    /**
     * elimina
     * @param user
     */
    public void delete(User user){
        userCrudRepository.delete(user);
    }
    /**
     * valida
     * @param email
     * @return
     */
    public boolean emailExists(String email) {
        Optional<User> user = userCrudRepository.findByEmail(email);
        return user.isPresent();
    }
    /**
     * valida
     * @param email
     * @param password
     * @return
     */
    public Optional<User> authenticateUser(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
    /**
     * regresa consulta
     * @param month
     * @return
     */
    public List<User> getByMonthBirthtDay(String month){
        return userCrudRepository.findByMonthBirthtDay(month);
    }
}
