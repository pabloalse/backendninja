package com.udemy.services;

import java.util.List;
import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;


// TODO: Auto-generated Javadoc
/**
 * The Interface ContactService.
 */
public interface ContactService {
	
	/**
	 * Adds the contact.
	 *
	 * @param contactModel the contact model
	 * @return the contact model
	 */
	public abstract ContactModel addContact (ContactModel contactModel);
	
	/**
	 * List all contacts.
	 *
	 * @return the list
	 */
	public abstract List<ContactModel> listAllContacts();
	
	/**
	 * Find contact by ID.
	 *
	 * @param id the id
	 * @return the contact
	 */
	public abstract Contact findContactByID (int id);
	
	/**
	 * Removes the contact.
	 *
	 * @param id the id
	 */
	public abstract void removeContact(int id);
	
	/**
	 * Find contact by ID model.
	 *
	 * @param id the id
	 * @return the contact model
	 */
	public abstract ContactModel findContactByIDModel(int id);
	
}
