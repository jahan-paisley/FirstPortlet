package com.meera.liferay.spring.controller;

import java.io.IOException;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.kernel.util.ParamUtil;
import com.meera.liferay.spring.domain.Contact;
import com.meera.liferay.spring.service.ContactService;

@Controller("contactController")
@RequestMapping("VIEW")
public class ContactController    {

	@Autowired
	private ContactService contactService;
	
	@RenderMapping
	public String listContacts(Map<String, Object> map) {
		map.put("contact", new Contact());
		map.put("contactList", contactService.listContact());
		return "contact";
	}
	
	@ActionMapping(params = "action=add")
	public void addContact(ActionRequest actionRequest,ActionResponse actionResponse, Model model,@ModelAttribute("contact") Contact contact, BindingResult result) throws IOException,
			PortletException {
		System.out.println("result"+ParamUtil.getString(actionRequest,"firstname"));
		System.out.println("contact"+contact.getFirstname());
		contactService.addContact(contact);
		//return "contact";
		
	}
	
	@ActionMapping(params = "action=delete")
	public void deleteContact(@RequestParam("contactId") Integer contactId,ActionRequest actionRequest,ActionResponse actionResponse, Model model) throws IOException,
			PortletException {
		System.out.println("resul344444444444444t");
		contactService.removeContact(contactId);
		//return "contact";
		
	}

}
