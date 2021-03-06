package com.journaldev.spring.model;
// Generated Jul 2, 2019 11:14:47 AM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




/**
 * AppointmentItem generated by hbm2java
 */

@Entity
@Table(name="APPOINTMENT_ITEM")
public class AppointmentItem  implements java.io.Serializable {


      @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
     private Integer id;
      
      
    @ManyToOne
    @JoinColumn(name="appointment", nullable=false)
     private Appointment appointment;
    
    
    @ManyToOne
    @JoinColumn(name="service", nullable=false)
     private Service service;
    
     private Integer quantity;

    public AppointmentItem() {
    }

	
    public AppointmentItem(Appointment appointment) {
        this.appointment = appointment;
    }
    public AppointmentItem(Appointment appointment, Service service, Integer quantity) {
       this.appointment = appointment;
       this.service = service;
       this.quantity = quantity;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
   
    public Appointment getAppointment() {
        return this.appointment;
    }
    
    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
    public Service getService() {
        return this.service;
    }
    
    public void setService(Service service) {
        this.service = service;
    }
    public Integer getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }




}


