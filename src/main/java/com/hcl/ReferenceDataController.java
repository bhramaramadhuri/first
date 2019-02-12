package com.hcl;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class ReferenceDataController {
	@Autowired
	CountryDao perdao;
	@RequestMapping("/")
	public ModelAndView IndexPage()
	{
		return new ModelAndView("index");
		
	}

	@RequestMapping("empform")
	public ModelAndView EmpformPage(@ModelAttribute("person") Country person)
	{
		return new ModelAndView("empform");
		
	}
	@RequestMapping("save")
	public ModelAndView SavePage(@ModelAttribute("person") Country person)
	{
		if(person.getId()==0)
		{
		perdao.save(person);
		}
		else
		{
			perdao.save(person);
		}
		List<Country> lp=(List<Country>) perdao.findAll();
		return new ModelAndView("Success","listperson",lp);
		
	}
	@RequestMapping("editemployee")
	public ModelAndView EditPage(@ModelAttribute("person") Country person,HttpServletRequest req)
	{ int id=Integer.parseInt(req.getParameter("id"));
		System.out.println("Id"+id);
		Country pers=perdao.findById(id);
		//List<Person> lp=perdao.FetchPerson();
		return new ModelAndView("empform","person",pers);
		
	}
	@RequestMapping("deleteemployee")
	public ModelAndView DeletePage(@ModelAttribute("person") Country person,HttpServletRequest req)
	{ //int id=Integer.parseInt(req.getParameter("id"));
		perdao.delete(person);
		List<Country> lp=(List<Country>) perdao.findAll();
		return new ModelAndView("Success","listperson",lp);
		
	}
	/*@RequestMapping("viewemp")
	public ModelAndView viewPage(@ModelAttribute("person") Country person)
	{
		List<Country> lp=(List<Country>) perdao.findAll();
		return new ModelAndView("Success","listperson",lp);
		
	}*/
	@RequestMapping("viewemp")
    public ModelAndView viewPage(@PageableDefault(value=3,page=0) Pageable pageable)
    {
                    Page page=perdao.findAll(pageable);
                    List ls=page.getContent();
                    
                    return new ModelAndView("Success","listperson",ls);
                    
    }

}