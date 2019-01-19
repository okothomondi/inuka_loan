/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com._4g_capital.inuka.services;

import com._4g_capital.inuka.models.InukaUsers;
import com._4g_capital.inuka.repositories.InukaUsersRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author okoth.omondi
 */
@Transactional
@Service("databaseService")
public class DatabaseServiceImpl implements DatabaseService {
    
    @Autowired
    InukaUsersRepository inukaUsersRepository;

    @Override
    public List<InukaUsers> listUsers() {
        return inukaUsersRepository.findAll();
    }

    @Override
    public InukaUsers createUser(InukaUsers inukaUsers) {
        return inukaUsersRepository.save(inukaUsers);
    }
    
}
