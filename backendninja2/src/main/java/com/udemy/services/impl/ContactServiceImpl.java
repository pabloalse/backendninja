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

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService{

	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;
	
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;
		
	@Override
	public ContactModel addContact(ContactModel contactModel) {
		Contact contact = contactRepository.save(contactConverter.convertContactModel2Contact(contactModel));
		return  contactConverter.convertContact2ContractModel(contact);
	}

	@Override
	public List<ContactModel> listAllContacts() {
		List<Contact> contacts = contactRepository.findAll();
		List<ContactModel> contactsModel = new ArrayList<ContactModel>();
		for(Contact contact: contacts){
			contactsModel.add(contactConverter.convertContact2ContractModel(contact));
		}
		return contactsModel;
	}

	@Override
	public Contact findContactByID(int id) {
		return contactRepository.findByid(id);
	}

	public ContactModel findContactByIDModel(int id) {
		return contactConverter.convertContact2ContractModel(findContactByID(id));
	}
	
	
	@Override
	public void removeContact(int id) {
		Contact contact = findContactByID(id);
		if (contact != null){
			contactRepository.delete(contact);
		}
	}

	

}
