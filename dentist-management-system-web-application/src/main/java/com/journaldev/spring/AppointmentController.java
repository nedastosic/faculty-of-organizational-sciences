package com.journaldev.spring;

import com.journaldev.spring.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.Appointment;
import com.journaldev.spring.model.AppointmentItem;
import com.journaldev.spring.model.Dentist;
import com.journaldev.spring.model.Patient;
import com.journaldev.spring.model.Service;
import com.journaldev.spring.service.AppointmentItemService;
import com.journaldev.spring.service.AppointmentService;
import com.journaldev.spring.service.CityService;
import com.journaldev.spring.service.PatientService;
import com.journaldev.spring.service.ServiceService;
import java.util.List;
import javax.servlet.http.HttpSession;

@Controller
public class AppointmentController {
	
	private AppointmentService appointmentService;
        private ServiceService serviceService;
	private PatientService patientService;
	
	@Autowired(required=true)
	@Qualifier(value="patientService")
	public void setPatientService(PatientService ps){
		this.patientService = ps;
	}
	
        @Autowired(required=true)
	@Qualifier(value="serviceService")
	public void setServiceService(ServiceService ss){
		this.serviceService = ss;
	}
	
	@Autowired(required=true)
	@Qualifier(value="appointmentService")
	public void setAppointmentService(AppointmentService ps){
		this.appointmentService = ps;
	}
        
        private AppointmentItemService appointmentItemService;
	
	@Autowired(required=true)
	@Qualifier(value="appointmentItemService")
	public void setAppointmentItemService(AppointmentItemService ps){
		this.appointmentItemService = ps;
	}

	
	@RequestMapping(value = "/appointments", method = RequestMethod.GET)
	public String listPatients(Model model, HttpSession session) {
             if (((Dentist)session.getAttribute("dentist"))==null)
                return "redirect:/login";
		model.addAttribute("listAppointments", this.appointmentService.listAppointments());                
		return "appointment";
	}
        
        
         @RequestMapping(value = "/appointment/new", method = RequestMethod.GET)
	public String newPatient(Model model, HttpSession session) {
             if (((Dentist)session.getAttribute("dentist"))==null)
                return "redirect:/login";
		model.addAttribute("dentist",((Dentist)session.getAttribute("dentist")));
		model.addAttribute("appointment", new Appointment());
		model.addAttribute("patients", this.patientService.listPatients());
		return "newappointment";
	}
        
            
        //For add and update patient both
	@RequestMapping(value= "/appointment/add", method = RequestMethod.POST)
	public String addAppointmentItem(@ModelAttribute("appointment") Appointment p, HttpSession session){	
             if (((Dentist)session.getAttribute("dentist"))==null)
                return "redirect:/login";
          if(this.appointmentService.getAppointmentById(p.getId())==null){
		this.appointmentService.addAppointment(p);
		}else{
		this.appointmentService.updateAppointment(p);
		}		
					
		return "redirect:/appointments";
	}
        
         @RequestMapping("/appointment/edit/{id}")
        public String editAppointment(@PathVariable("id") Integer id, Model model, HttpSession session){
             if (((Dentist)session.getAttribute("dentist"))==null)
                return "redirect:/login";
           model.addAttribute("dentist",((Dentist)session.getAttribute("dentist")));
		model.addAttribute("appointment", this.appointmentService.getAppointmentById(id));
		model.addAttribute("patients", this.patientService.listPatients());
            return "newappointment";
        }
        
        @RequestMapping("/appointment/remove/{id}")
        public String removeAppointment(@PathVariable("id") Integer id, HttpSession session){
             if (((Dentist)session.getAttribute("dentist"))==null)
                return "redirect:/login";

            this.appointmentService.removeAppointment(id);
            return "redirect:/appointments";
        }
        
        @RequestMapping(value = "/appointmentDetails/{id}", method = RequestMethod.GET)
	public String appointmentDetails(Model model, @PathVariable("id") int id, HttpSession session) {  
             if (((Dentist)session.getAttribute("dentist"))==null)
                return "redirect:/login";
            
		model.addAttribute("appointmentItem", new AppointmentItem());
		model.addAttribute("services", this.serviceService.listServices());
		model.addAttribute("appointment", this.appointmentService.getAppointmentById(id));     
                model.addAttribute("listAppointmentItems", this.appointmentItemService.listAppointmentItems(id));
                
		return "appointmentDetails";
	}
	
}
