package com.ciclo4.reto5.repository;

import com.ciclo4.reto5.model.User;
import com.ciclo4.reto5.repository.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author angie
 */
@Repository
public class UserRepository {
    
    @Autowired
    /**
     * Trae el crud de usuarios
     */
    private UserCrudRepository userCrudRepository;
    
    /**
     * Hace una lista con todos los usuarios
     * @return 
     */
    public List<User> getAll(){
        return userCrudRepository.findAll();
    }
    /**
     * Obtiene los usuarios por id
     * @param id
     * @return 
     */
    public Optional<User> getUsuario(int id){
        return userCrudRepository.findById(id);
    }
    
    /**
     * Crea un usuario
     * @param usuario
     * @return 
     */
    public User create(User usuario){
        return userCrudRepository.save(usuario);
    }
    
    /**
     * Trade del crud la informacion para actualizar la informacion de un usuario
     * @param usuario
     * @return 
     */
    public User update(User usuario){
        return userCrudRepository.save(usuario);
    }
    
    /**
     * informacion del crud para borrar usuario
     * @param usuario 
     */
    public void delete(User usuario){
        userCrudRepository.delete(usuario);
    } 
    
    /**
     * Informacionm del crud desde un mail 
     * @param email
     * @return 
     */
    public Optional<User> getByEmail(String email){
        return userCrudRepository.findByEmail(email);
    }
    
    /**
     * Informacion del crud para obtejer ese usuario desde su contraseña y email
     * @param email
     * @param password
     * @return 
     */
    public Optional<User> getByEmalAndPassword(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
    
    /**
     * Informacion del crud para saber cual es el id maximo
     * @return 
     */
    public Optional<User> getIdMaximo(){
        return userCrudRepository.findTopByOrderByIdDesc();
    }
    
    /**
     * Crud para conocer el mes de cumpleaños de la fuerza comercial dato que usaremos en el front
     * @param mesCumpleaños
     * @return 
     */
    public List<User> getMothBirthday(String mesCumpleaños){
        return userCrudRepository.findByMonthBirthtDay(mesCumpleaños);
    }
}