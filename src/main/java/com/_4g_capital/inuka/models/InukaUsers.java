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
@Table(name = "inuka_users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InukaUsers.findAll", query = "SELECT i FROM InukaUsers i")
    , @NamedQuery(name = "InukaUsers.findById", query = "SELECT i FROM InukaUsers i WHERE i.id = :id")
    , @NamedQuery(name = "InukaUsers.findByFirstName", query = "SELECT i FROM InukaUsers i WHERE i.firstName = :firstName")
    , @NamedQuery(name = "InukaUsers.findBySecondName", query = "SELECT i FROM InukaUsers i WHERE i.secondName = :secondName")
    , @NamedQuery(name = "InukaUsers.findByIdNo", query = "SELECT i FROM InukaUsers i WHERE i.idNo = :idNo")
    , @NamedQuery(name = "InukaUsers.findByPassword", query = "SELECT i FROM InukaUsers i WHERE i.password = :password")
    , @NamedQuery(name = "InukaUsers.findByMsisdn", query = "SELECT i FROM InukaUsers i WHERE i.msisdn = :msisdn")
    , @NamedQuery(name = "InukaUsers.findByCreatedOn", query = "SELECT i FROM InukaUsers i WHERE i.createdOn = :createdOn")})
public class InukaUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "id_no")
    private Integer idNo;
    @Column(name = "password")
    private String password;
    @Column(name = "msisdn")
    private String msisdn;
    @Column(name = "created_on")
    @Temporal(TemporalType.DATE)
    private Date createdOn;
    @Column(name = "email")
    private String email;

//    @OneToMany(mappedBy = "msisdn")
    @Transient
    private List<InukaLoans> inukaLoansList;

    public InukaUsers() {
    }

    public InukaUsers(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Integer getIdNo() {
        return idNo;
    }

    public void setIdNo(Integer idNo) {
        this.idNo = idNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public List<InukaLoans> getInukaLoansList() {
        return inukaLoansList;
    }

    public void setInukaLoansList(List<InukaLoans> inukaLoansList) {
        this.inukaLoansList = inukaLoansList;
    }

    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        if (!(object instanceof InukaUsers)) {
            return false;
        }
        InukaUsers other = (InukaUsers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbgenman.inuka.InukaUsers[ id=" + id + " ]";
    }

}
