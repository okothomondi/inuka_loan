/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com._4g_capital.inuka.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author okoth.omondi
 */
@Entity
@Table(name = "inuka_loans")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InukaLoans.findAll", query = "SELECT i FROM InukaLoans i")
    , @NamedQuery(name = "InukaLoans.findById", query = "SELECT i FROM InukaLoans i WHERE i.id = :id")
    , @NamedQuery(name = "InukaLoans.findByLoanCode", query = "SELECT i FROM InukaLoans i WHERE i.loanCode = :loanCode")
    , @NamedQuery(name = "InukaLoans.findByLoanName", query = "SELECT i FROM InukaLoans i WHERE i.loanName = :loanName")
    , @NamedQuery(name = "InukaLoans.findByLoanAmount", query = "SELECT i FROM InukaLoans i WHERE i.loanAmount = :loanAmount")
    , @NamedQuery(name = "InukaLoans.findByLoanInterest", query = "SELECT i FROM InukaLoans i WHERE i.loanInterest = :loanInterest")
    , @NamedQuery(name = "InukaLoans.findByLoanDate", query = "SELECT i FROM InukaLoans i WHERE i.loanDate = :loanDate")
    , @NamedQuery(name = "InukaLoans.findByLoanDueDate", query = "SELECT i FROM InukaLoans i WHERE i.loanDueDate = :loanDueDate")
    , @NamedQuery(name = "InukaLoans.findByTransactionId", query = "SELECT i FROM InukaLoans i WHERE i.transactionId = :transactionId")})
public class InukaLoans implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "loan_code")
    private String loanCode;
    @Column(name = "loan_name")
    private String loanName;
    @Column(name = "loan_amount")
    private String loanAmount;
    @Column(name = "loan_interest")
    private String loanInterest;
    @Column(name = "loan_date")
    @Temporal(TemporalType.DATE)
    private Date loanDate;
    @Column(name = "loan_due_date")
    @Temporal(TemporalType.DATE)
    private Date loanDueDate;
    @Column(name = "transaction_id")
    private Integer transactionId;
    
//    @ManyToOne
//    @JoinColumn(name = "msisdn", referencedColumnName = "msisdn")
//    @Transient
    private InukaUsers msisdn;
    
//    @OneToMany(mappedBy = "loanCode")
    @Transient
    private List<InukaPayments> inukaPaymentsList;

    public InukaLoans() {
    }

    public InukaLoans(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoanCode() {
        return loanCode;
    }

    public void setLoanCode(String loanCode) {
        this.loanCode = loanCode;
    }

    public String getLoanName() {
        return loanName;
    }

    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getLoanInterest() {
        return loanInterest;
    }

    public void setLoanInterest(String loanInterest) {
        this.loanInterest = loanInterest;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getLoanDueDate() {
        return loanDueDate;
    }

    public void setLoanDueDate(Date loanDueDate) {
        this.loanDueDate = loanDueDate;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public InukaUsers getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(InukaUsers msisdn) {
        this.msisdn = msisdn;
    }

//    @XmlTransient
  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InukaLoans)) {
            return false;
        }
        InukaLoans other = (InukaLoans) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbgenman.inuka.InukaLoans[ id=" + id + " ]";
    }
    
}
