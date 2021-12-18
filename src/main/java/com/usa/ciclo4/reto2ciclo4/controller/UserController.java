package com.usa.ciclo4.reto2ciclo4.controller;

import java.util.List;
import java.util.Optional;
import com.usa.ciclo4.reto2ciclo4.model.User;
import com.usa.ciclo4.reto2ciclo4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
/**
 * @author Elber Fernando Fuentes Moreno
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {
    @Autowired
    /**
     * Private User
     */
    private UserService userService;
    /**
     * 
     * @return
     */
    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }
    /**
     * 
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") int id){
        return userService.getUser(id);
    }
    /**
     * 
     * @param user
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody User user){
        userService.save(user);
    }
    /**
     * 
     * @param user
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user){
        return userService.update(user);
    }
    /**
     * 
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return userService.delete(id);
    }
    /**
     * 
     * @param email
     * @param password
     * @return
     */
    @GetMapping("/{email}/{password}")
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.authenticateUser(email,password);
    }
    /**
     * 
     * @param email
     * @return
     */
    @GetMapping("/emailexist/{email}")
    public boolean emailExists (@PathVariable("email") String email){
        return userService.emailExists(email);
    }

    @GetMapping("/birthday/{month}")
    public List<User> getByMonthBirthday(@PathVariable("month") String month){
        return userService.getByMonthBirthDay(month);
    }
}
