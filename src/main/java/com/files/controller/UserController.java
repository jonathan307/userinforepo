package com.files.controller;

import com.files.model.RequestDates;
import com.files.model.UserInfo;
import com.files.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/customaddUser", produces = "application/json")
    ResponseEntity<String> addUser(@RequestBody UserInfo userInfo) {
        String res = "";
        res = userService.addUser(userInfo);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping(value = "/getspecificuser/{userid}", produces = "application/json")
    ResponseEntity<List<UserInfo>> getspecificUser(@PathVariable("userid") int userid) {
        List<UserInfo> resList = userService.getspecificUser(userid);
        return new ResponseEntity<>(resList, HttpStatus.OK);
    }

    @GetMapping(value = "/getspecificprofession/{profession}", produces = "application/json")
    ResponseEntity<List<UserInfo>> getspecificProfession(@PathVariable("profession") String profession) {
        List<UserInfo> resList = userService.getspecificProfession(profession);
        return new ResponseEntity<>(resList, HttpStatus.OK);
    }

    @GetMapping(value = "/getspecificdates", produces = "application/json")
    ResponseEntity<List<UserInfo>> getspecificDates(@RequestBody RequestDates rdates) {
        List<UserInfo> resList = new ArrayList<>();;
        resList = userService.getspecificDates(rdates);
        return new ResponseEntity<>(resList, HttpStatus.OK);
    }
}
