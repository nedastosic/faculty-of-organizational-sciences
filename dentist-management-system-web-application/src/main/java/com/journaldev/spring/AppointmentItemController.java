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

import com.journaldev.spring.model.AppointmentItem;
import com.journaldev.spring.model.Dentist;
import com.journaldev.spring.model.Patient;
import com.journaldev.spring.service.AppointmentItemService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppointmentItemController {

    private AppointmentItemService appointmentItemService;

    @Autowired(required = true)
    @Qualifier(value = "appointmentItemService")
    public void setAppointmentItemService(AppointmentItemService ps) {
        this.appointmentItemService = ps;
    }

    @RequestMapping("appointmentItem/remove/{id}")
    public String removeAppointmentItem(@PathVariable("id") int id, HttpSession session) {
         if (((Dentist)session.getAttribute("dentist"))==null)
                return "redirect:/login";
        int appId = this.appointmentItemService.getAppointmentItemById(id).getAppointment().getId();
        this.appointmentItemService.removeAppointmentItem(id);
        return "redirect:/appointmentDetails/"+appId;
    }
    
    	
        
        //For add and update patient both
	@RequestMapping(value= "/appointmentItem/add", method = RequestMethod.POST)
	public String addAppointmentItem(@ModelAttribute("appointmentItem") AppointmentItem p, HttpSession session){	
             if (((Dentist)session.getAttribute("dentist"))==null)
                return "redirect:/login";
		this.appointmentItemService.addAppointmentItem(p);		
		return "redirect:/appointmentDetails/"+p.getAppointment().getId();
		
	}

}
