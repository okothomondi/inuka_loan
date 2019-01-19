/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com._4g_capital.inuka.controllers;

import com._4g_capital.inuka.models.InukaUsers;
import com._4g_capital.inuka.services.DatabaseService;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author admin
 */
@RestController
@RequestMapping("/users")
public class UsersController {

//    private final DatabaseService databaseService;
//    private final PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public UsersController(DatabaseService databaseService, PasswordEncoder passwordEncoder) {
//        this.databaseService = databaseService;
//        this.passwordEncoder = passwordEncoder;
//    }
    
    @Autowired
    DatabaseService databaseService;

    @RequestMapping(value = "/listusers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InukaUsers>> listAllUsers() {
        try {
            List<InukaUsers> userlist = databaseService.listUsers();
            if (userlist.isEmpty()) {
                return new ResponseEntity<>(userlist, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            System.err.println("ERROR >> " + e.toString() + " [ Message >>> " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/createuser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InukaUsers> createUser(@RequestBody InukaUsers userobj, UriComponentsBuilder ucBuilder) {
        Calendar currenttime = Calendar.getInstance();
        userobj.setPassword("");//passwordEncoder.encode(userobj.getEmail())
        userobj.setCreatedOn(new Date((currenttime.getTime()).getTime()));
        InukaUsers response = databaseService.createUser(userobj);
        if (null != response) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
}
