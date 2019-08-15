package com.journaldev.spring.model;
// Generated Jul 2, 2019 11:14:47 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Patient generated by hbm2java
 */
@Entity
@Table(name="PATIENT")
public class Patient  implements java.io.Serializable {


    
    @Id
    @Column(name="jmbg")
     private String jmbg;
    @ManyToOne
    @JoinColumn(name="city", nullable=false)
     private City city;
    @ManyToOne
    @JoinColumn(name="createdDentist", nullable=false)
     private Dentist dentist;
     private String name;
     private String surname;
     private Date dateOfBirth;
     private String email;
     private String phone;
     private String address;
     //private Set appointments = new HashSet(0);

    public Patient() {
    }

	
    public Patient(String jmbg, String name, String surname, Date dateOfBirth, String phone, String address) {
        this.jmbg = jmbg;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.address = address;
    }
    public Patient(String jmbg, City city, Dentist dentist, String name, String surname, Date dateOfBirth, String email, String phone, String address, Set appointments) {
       this.jmbg = jmbg;
       this.city = city;
       this.dentist = dentist;
       this.name = name;
       this.surname = surname;
       this.dateOfBirth = dateOfBirth;
       this.email = email;
       this.phone = phone;
       this.address = address;
       //this.appointments = appointments;
    }
   
    public String getJmbg() {
        return this.jmbg;
    }
    
    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }
    public City getCity() {
        return this.city;
    }
    
    public void setCity(City city) {
        this.city = city;
    }
    public Dentist getDentist() {
        return this.dentist;
    }
    
    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return this.surname;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }
    
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    /*public Set getAppointments() {
        return this.appointments;
    }
    
    public void setAppointments(Set appointments) {
        this.appointments = appointments;
    }*/




}


