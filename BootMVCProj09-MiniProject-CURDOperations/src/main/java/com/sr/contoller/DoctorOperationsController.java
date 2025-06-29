package com.sr.contoller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sr.VO.DoctorVO;
import com.sr.service.IDoctorMangService;

@Controller
public class DoctorOperationsController 
{
	@Autowired
    private IDoctorMangService docservice;
	@GetMapping("/")
	public String ShowHome()
	{
		return "welcome";
	}
	@GetMapping("/report")
	public String ShowReport(Map<String,Object>map)
	{
		List<DoctorVO>listVO=docservice.FindAllDoctors();
		map.put("doctorlist", listVO);
		return "show_report";
	}
	@GetMapping("/register")
	public String RegisterPage(@ModelAttribute("docVo")DoctorVO vo)
	{
		return "show_doctor_report";
	}
	
	 /* @PostMapping("/register") public String
	  DoctorsPage(@ModelAttribute("docvo") DoctorVO vo,Map<String,Object>map) 
	  {
		  List<DoctorVO>list=docservice.FindAllDoctors();
	    String msg=docservice.registerDoctor(vo);
	    map.put("resultmsg", msg);
	    map.put("doctorlist",list);
	    return "show_report";
	  }*/
	
	@PostMapping("/register")
	public String DoctorsPage(@ModelAttribute("docvo") DoctorVO vo,RedirectAttributes attrs) 
	  {
		  List<DoctorVO>list=docservice.FindAllDoctors();
	    String msg=docservice.registerDoctor(vo);
	   attrs.addFlashAttribute("resultmsg",msg);
	    return "redirect:report";
	  }
	
	@GetMapping("/edit") 
	public String EditDoctors(@RequestParam("no")int no,@ModelAttribute("docVo") DoctorVO vo)
	{
	    DoctorVO vos=docservice.showDoctorById(no);
	    BeanUtils.copyProperties(vos, vo);
	    return "edit_doctor_report";
	}
		
	@PostMapping("/edit") 
	public String EditDoctors(@ModelAttribute("docVo") DoctorVO vo,RedirectAttributes attrs)
	{
		String msg=docservice.editDoctor(vo);
		attrs.addFlashAttribute("resultmsg",msg);
		return "redirect:report";
				
	}
	
	@GetMapping("/delete") 
	public String deleteDoctors(@RequestParam("no")int id,RedirectAttributes attrs)
	{
		String msg=docservice.deleteDoctorById(id);
		attrs.addFlashAttribute("resultmsg",msg);
		return "redirect:report";
				
	}
	
}
