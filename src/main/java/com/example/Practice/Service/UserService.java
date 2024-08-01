package com.example.Practice.Service;

import com.example.Practice.Entity.UserDetails;
import com.example.Practice.Repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
public class UserService {
    @Autowired
    UserDetailsRepository userDetailsRepository;

    public void addUsers(List<UserDetails> userDetails){
        userDetailsRepository.saveAll(userDetails);
    }
    public List<UserDetails> getUsers(){
        return userDetailsRepository.findAll();
    }
    public Optional<UserDetails>getUser(String id){
        return userDetailsRepository.findById(id);
    }
    public void updateUser(UserDetails details){
       userDetailsRepository.save(details);

    }
    public String updateFname(String id, Map<String,String>param){
        Optional<UserDetails> user = userDetailsRepository.findById(id);
        for (Map.Entry<String,String> detail: param.entrySet()){
            user.get().setfName(detail.getValue());
        }
        userDetailsRepository.save(user.get());
        return "FirstName Updated";
    }
    public String updateLname(String id, Map<String,String>param){
        Optional<UserDetails>user=userDetailsRepository.findById(id);
        for (Map.Entry<String,String> detail:param.entrySet()){
            user.get().setlName(detail.getValue());
        }
        userDetailsRepository.save(user.get());
        return " LastName Updated";
    }

    public String updateAge(String id, Map<String,Integer>param){
        Optional<UserDetails>user=userDetailsRepository.findById(id);
        for (Map.Entry<String,Integer> detail:param.entrySet()){
            user.get().setAge(detail.getValue());
        }
        userDetailsRepository.save(user.get());
        return "Age Updated";
    }
    public String updateAddress(String id, Map<String,String>param){
        Optional<UserDetails>user=userDetailsRepository.findById(id);
        System.out.println(user);
        for (Map.Entry<String,String> detail:param.entrySet()){
            user.get().setAddress(detail.getValue());
        }
        userDetailsRepository.save(user.get());
        return "Address Updated";
    }
    public void deleteAllUser(){
        userDetailsRepository.deleteAll();
    }
    public void deleteUser(String id){
        userDetailsRepository.deleteById(id);
    }
}
