package com.udemy.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.component.ContactConverter;
import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;
import com.udemy.repository.ContactRepository;
import com.udemy.services.ContactService;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactServiceImpl.
 */
@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService{

	/** The contact repository. */
	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;
	
	/** The contact converter. */
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;
		
	/* (non-Javadoc)
	 * @see com.udemy.services.ContactService#addContact(com.udemy.model.ContactModel)
	 */
	@Override
	public ContactModel addContact(ContactModel contactModel) {
		Contact contact = contactRepository.save(contactConverter.convertContactModel2Contact(contactModel));
		return  contactConverter.convertContact2ContractModel(contact);
	}

	/* (non-Javadoc)
	 * @see com.udemy.services.ContactService#listAllContacts()
	 */
	@Override
	public List<ContactModel> listAllContacts() {
		List<Contact> contacts = contactRepository.findAll();
		List<ContactModel> contactsModel = new ArrayList<ContactModel>();
		for(Contact contact: contacts){
			contactsModel.add(contactConverter.convertContact2ContractModel(contact));
		}
		return contactsModel;
	}

	/* (non-Javadoc)
	 * @see com.udemy.services.ContactService#findContactByID(int)
	 */
	@Override
	public Contact findContactByID(int id) {
		return contactRepository.findByid(id);
	}

	/* (non-Javadoc)
	 * @see com.udemy.services.ContactService#findContactByIDModel(int)
	 */
	public ContactModel findContactByIDModel(int id) {
		return contactConverter.convertContact2ContractModel(findContactByID(id));
	}
	
	
	/* (non-Javadoc)
	 * @see com.udemy.services.ContactService#removeContact(int)
	 */
	@Override
	public void removeContact(int id) {
		Contact contact = findContactByID(id);
		if (contact != null){
			contactRepository.delete(contact);
		}
	}

}
