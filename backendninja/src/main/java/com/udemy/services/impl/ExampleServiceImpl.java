package com.udemy.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import com.udemy.model.Person;
import com.udemy.services.ExampleService;


@Service("exampleService")
public class ExampleServiceImpl implements ExampleService{

	private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);
	
	@Override
	public List<Person> getListPeople() {
		
		List<Person> people = new ArrayList<>();
		people.add(new Person("pablo", 40));
		people.add(new Person("Juan", 42));
		people.add(new Person("Miki", 34));
		people.add(new Person("Alvaro", 44));
		LOG.info("HELLO FROM SERVICE");
		return people;
	
		
	}

}
