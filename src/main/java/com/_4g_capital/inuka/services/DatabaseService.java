/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com._4g_capital.inuka.services;

import com._4g_capital.inuka.models.InukaUsers;
import java.util.List;

/**
 *
 * @author okoth.omondi
 */
public interface DatabaseService {

    List<InukaUsers> listUsers();

    InukaUsers createUser(InukaUsers inukaUsers);
}
