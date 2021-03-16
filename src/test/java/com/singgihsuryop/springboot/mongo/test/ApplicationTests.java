package com.singgihsuryop.springboot.mongo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.singgihsuryop.springboot.mongo.dao.PersonMongoDao;
import com.singgihsuryop.springboot.mongo.entity.Person;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	PersonMongoDao personDao;

	@Test
	public void contextLoad(){
		Person person = new Person();
		person.setId("1");
		person.setName("Singgih");
		person.setAge(20);
		
		personDao.insertNewPerson(person);
		
		personDao.findPersonByAge(20);
		
		personDao.updatePersonsAge("Singgih", 25);
		
		personDao.findPersonByAge(25);
	}

}
