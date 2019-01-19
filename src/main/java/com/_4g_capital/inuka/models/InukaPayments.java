/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com._4g_capital.inuka.models;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author okoth.omondi
 */
@Entity
@Table(name = "inuka_payments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InukaPayments.findAll", query = "SELECT i FROM InukaPayments i")
    , @NamedQuery(name = "InukaPayments.findById", query = "SELECT i FROM InukaPayments i WHERE i.id = :id")
    , @NamedQuery(name = "InukaPayments.findByTransactionCode", query = "SELECT i FROM InukaPayments i WHERE i.transactionCode = :transactionCode")
    , @NamedQuery(name = "InukaPayments.findByAmount", query = "SELECT i FROM InukaPayments i WHERE i.amount = :amount")
    , @NamedQuery(name = "InukaPayments.findByDescription", query = "SELECT i FROM InukaPayments i WHERE i.description = :description")
    , @NamedQuery(name = "InukaPayments.findByPaymentDate", query = "SELECT i FROM InukaPayments i WHERE i.paymentDate = :paymentDate")})
public class InukaPayments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "transaction_code")
    private String transactionCode;
    @Column(name = "amount")
    private BigInteger amount;
    @Column(name = "description")
    private String description;
    @Column(name = "payment_date")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;
    @JoinColumn(name = "loan_code", referencedColumnName = "loan_code")
    @ManyToOne
    private InukaLoans loanCode;

    public InukaPayments() {
    }

    public InukaPayments(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public InukaLoans getLoanCode() {
        return loanCode;
    }

    public void setLoanCode(InukaLoans loanCode) {
        this.loanCode = loanCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InukaPayments)) {
            return false;
        }
        InukaPayments other = (InukaPayments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbgenman.inuka.InukaPayments[ id=" + id + " ]";
    }
    
}
