package com.meera.liferay.spring.dao;

import java.util.List;
import com.meera.liferay.spring.domain.Contact;
public interface ContactDAO {
	
	public void addContact(Contact contact);
	public List<Contact> listContact();
	public void removeContact(Integer id);
}
