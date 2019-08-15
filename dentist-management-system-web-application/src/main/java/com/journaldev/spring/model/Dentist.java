package com.journaldev.spring.model;
// Generated Jul 2, 2019 11:14:47 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Dentist generated by hbm2java
 */

@Entity
@Table(name="DENTIST")
public class Dentist  implements java.io.Serializable {


    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
     private Integer id;
     private String name;
     private String surname;
     private String username;
     private String password;
   //  private Set appointments = new HashSet(0);
    // @OneToMany(mappedBy="FK_dentist", cascade={CascadeType.ALL})
    // private List<Patient> patients= new LinkedList<Patient>();

    public Dentist() {
    }

	
    public Dentist(String name, String surname, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }
    public Dentist(String name, String surname, String username, String password, Set appointments, Set patients) {
       this.name = name;
       this.surname = surname;
       this.username = username;
       this.password = password;
      // this.appointments = appointments;
      // this.patients = patients;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
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
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
//    public Set getAppointments() {
//        return this.appointments;
//    }
//    
//    public void setAppointments(Set appointments) {
//        this.appointments = appointments;
//    }
//    public List<Patient> getPatients() {
//        return this.patients;
//    }
//    
//    public void setPatients(List<Patient> patients) {
//        this.patients = patients;
//    }




}


