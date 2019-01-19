/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com._4g_capital.inuka.repositories;

import com._4g_capital.inuka.models.InukaPayments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author okoth.omondi
 */
@Repository
public interface InukaPaymentsRepository  extends JpaRepository<InukaPayments, Integer> {
    
}
