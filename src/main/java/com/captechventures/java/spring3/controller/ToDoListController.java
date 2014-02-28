package com.captechventures.java.spring3.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletSession;
import javax.portlet.ResourceResponse;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.captechventures.java.spring3.model.ToDo;

@Controller
@RequestMapping("VIEW")
public class ToDoListController {

	@RenderMapping
	public String view() {
		return "list";
	}
	
	@ActionMapping
	public void save(@Valid ToDo toDo, BindingResult result, @CookieValue("JSESSIONID") String jsessionid, 
			PortletSession session, ModelMap modelMap) {
		if (!result.hasErrors()) {
			// could use entityManager to persist; put in session for this example
			List<ToDo> toDos = (List<ToDo>) session.getAttribute("toDos");
			if (toDos == null) {
				toDos = new ArrayList<ToDo>();
			}
			toDos.add(toDo);
			session.setAttribute("toDos", toDos);

			modelMap.put("msg", String.format("You added a TODO: %s", toDo.getTitle()));
		}
	}

	@ResourceMapping
	public String viewAsText(ResourceResponse response) {
		response.setContentType("text/plain");
		return "results";
	}

	@ModelAttribute
	private ToDo loadModel() {
		return new ToDo();
	}
}
