package com.journaldev.spring;

import com.journaldev.spring.model.City;
import com.journaldev.spring.model.Dentist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.Patient;
import com.journaldev.spring.service.CityService;
import com.journaldev.spring.service.DentistService;
import com.journaldev.spring.service.PatientService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
  @Autowired
  private DentistService dentistService;

    @Autowired(required=true)
    @Qualifier(value="dentistService")
    public void setDentistService(DentistService ds){
            this.dentistService = ds;
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
	public String listPatients(Model model, HttpSession session) {
             if (((Dentist)session.getAttribute("dentist"))!=null)
                return "redirect:/patients";
		model.addAttribute("dentist", new Dentist());
		return "login";
	}
	
	//For add and update patient both
	@RequestMapping(value= "/login/validate", method = RequestMethod.POST)
	public String addPatient(@ModelAttribute("dentist") Dentist p, HttpSession session){	
            Dentist d=this.dentistService.validateUser(p);
            if(d!=null){
                session.setAttribute("dentist", d);
                    return "redirect:/patients";
		}else{
                    return "redirect:/login";
		}
	}
        
        //For add and update patient both
	@RequestMapping(value= "/logout")
	public String addPatient(HttpSession session){	
             session.invalidate();
            return "redirect:/login";
		
	}
	
}
