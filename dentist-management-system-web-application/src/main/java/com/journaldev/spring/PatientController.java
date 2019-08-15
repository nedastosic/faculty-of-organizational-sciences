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
import com.journaldev.spring.service.PatientService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PatientController {
	
	private PatientService patientService;
	private CityService cityService;
	
	@Autowired(required=true)
	@Qualifier(value="patientService")
	public void setPatientService(PatientService ps){
		this.patientService = ps;
	}
        
        @Autowired(required=true)
	@Qualifier(value="cityService")
	public void setCityService(CityService cs){
		this.cityService = cs;
	}

	
	@RequestMapping(value = "/patients", method = RequestMethod.GET)
	public String listPatients(Model model, HttpSession session) {
            if (((Dentist)session.getAttribute("dentist"))==null)
                return "redirect:/login";
		model.addAttribute("listPatients", this.patientService.listPatients());
		return "patient";
	}
        
        @RequestMapping(value = "/patient/search", method = RequestMethod.GET)
	public String listPatientsSearch(Model model, HttpSession session, @RequestParam("search") String search) {
             if (((Dentist)session.getAttribute("dentist"))==null)
                return "redirect:/login";
		model.addAttribute("listPatients", this.patientService.listPatients(search));
		return "patient";
	}
        
        
         @RequestMapping(value = "/patient/new", method = RequestMethod.GET)
	public String newPatient(Model model, HttpSession session) {
             if (((Dentist)session.getAttribute("dentist"))==null)
                return "redirect:/login";
		model.addAttribute("dentist",((Dentist)session.getAttribute("dentist")));
		model.addAttribute("patient", new Patient());
		model.addAttribute("cities", this.cityService.listCities());
		return "newpatient";
	}
               
	
	@RequestMapping(value= "/patient/add", method = RequestMethod.POST)
	public String addPatient(@ModelAttribute("patient") Patient p,HttpSession session){		
 if (((Dentist)session.getAttribute("dentist"))==null)
                return "redirect:/login";
            if(this.patientService.getPatientById(p.getJmbg())==null){
                    this.patientService.addPatient(p);
		}else{
                    this.patientService.updatePatient(p);
		}		
		return "redirect:/patients";
		
	}
	
	@RequestMapping("/remove/{jmbg}")
        public String removePatient(@PathVariable("jmbg") String jmbg, HttpSession session){
             if (((Dentist)session.getAttribute("dentist"))==null)
                return "redirect:/login";
            this.patientService.removePatient(jmbg);
            return "redirect:/patients";
        }

        @RequestMapping("/edit/{jmbg}")
        public String editPatient(@PathVariable("jmbg") String jmbg, Model model, HttpSession session){
             if (((Dentist)session.getAttribute("dentist"))==null)
                return "redirect:/login";
            model.addAttribute("dentist",((Dentist)session.getAttribute("dentist")));
            model.addAttribute("patient", this.patientService.getPatientById(jmbg));
            model.addAttribute("cities", this.cityService.listCities());
            return "newpatient";
        }
	
}
