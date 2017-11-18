package com.udemy.services;

import java.util.List;
import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;


public interface ContactService {
	
	public abstract ContactModel addContact (ContactModel contactModel);
	public abstract List<ContactModel> listAllContacts();
	public abstract Contact findContactByID (int id);
	public abstract void removeContact(int id);
	public abstract ContactModel findContactByIDModel(int id);
	
}
