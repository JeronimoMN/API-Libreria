package com.api.apilLibreria.service;

import com.api.apilLibreria.model.ClientModel;
import com.api.apilLibreria.model.DTO.FormCreateUser;
import com.api.apilLibreria.model.UserModel;
import com.api.apilLibreria.repository.IClientRepository;
import com.api.apilLibreria.repository.IUserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IClientRepository clientRepository;

    @PersistenceContext
    private EntityManager em;


    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public void saveUser(FormCreateUser rq) {
        ClientModel client = new ClientModel();
        client.setName_client(rq.getName_client());
        client.setLast_name_client(rq.getLast_name_client());
        client.setBirthday_client(rq.getBirthday_client());
        this.clientRepository.save(client);

        UserModel user = new UserModel();
        user.setUsername(rq.getUsername());
        user.setPassword(rq.getPassword());
        user.setEmail(rq.getEmail());
        user.setFk_id_client(client.getId_client());
        user.setAccount_creation_date(rq.getAccount_creation_date());
        user.setState_account(rq.getState_account());

        this.userRepository.save(user);
    }

    public boolean validate_user_pass(String username, String password){
        Query query = em.createNativeQuery("SELECT validateUserCredentials(:username, :password)", Boolean.class);
        query.setParameter("username", username);
        query.setParameter("password", password);

        return (Boolean) query.getSingleResult();
    }
}