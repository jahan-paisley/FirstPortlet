package com.meera.liferay.spring.service;
import java.util.List;
import com.meera.liferay.spring.domain.Contact;;
public interface ContactService {
	public void addContact(Contact contact);
	public List<Contact> listContact();
	public void removeContact(Integer id);
}
