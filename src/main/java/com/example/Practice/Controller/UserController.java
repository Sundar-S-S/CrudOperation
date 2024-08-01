package com.example.Practice.Controller;

import com.example.Practice.Entity.UserDetails;
import com.example.Practice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/addUsers")
    public String addUsers(@RequestBody List<UserDetails> userDetails){
        userService.addUsers(userDetails);
        return "Users Added";
    }
    @GetMapping("/getUsers")
    public List<UserDetails> getUsers(){
        return userService.getUsers();
    }
    @GetMapping("/getUser/{id}")
    public Optional<UserDetails> getUserById(@PathVariable("id")String id){
        return userService.getUser(id);
    }
    @PutMapping("/updateUserDetail/{id}")
    public String updateUserDetail(@PathVariable("id")String id,@RequestBody UserDetails userDetails){
        userService.updateUser(userDetails);
        return "User Updated";
    }

    @PatchMapping("/updateFname/{id}")
    public String updateFname(@PathVariable("id")String id,@RequestBody Map<String,String> param){
        return userService.updateFname(id,param);

    }
    @PatchMapping("/updateLname/{id}")
    public String updateLname(@PathVariable("id")String id,@RequestBody Map<String,String> param){
        return userService.updateLname(id,param);

    }
    @PatchMapping("/updateAge/{id}")
    public String updateAge(@PathVariable("id")String id,@RequestBody Map<String,Integer> param){
        return userService.updateAge(id,param);

    }
    @PatchMapping("/updateAddress/{id}")
    public String updateAddress(@PathVariable("id")String id,@RequestBody Map<String,String> param){
        return userService.updateAddress(id,param);

    }
    @DeleteMapping("/deleteAllUser")
    public String deleteAllUser(){
        userService.deleteAllUser();
        return "Users Deleted";
    }
    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable ("id")String id){
        userService.deleteUser(id);
        return "User deleted";
    }

}
