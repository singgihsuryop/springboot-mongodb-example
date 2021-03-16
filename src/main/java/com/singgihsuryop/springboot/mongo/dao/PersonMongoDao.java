package com.singgihsuryop.springboot.mongo.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.singgihsuryop.springboot.mongo.config.MongoConfig;
import com.singgihsuryop.springboot.mongo.entity.Person;

@Repository
public class PersonMongoDao {

	@Autowired
	private MongoConfig mongoConfig;

	private final static Logger LOG = LoggerFactory.getLogger(PersonMongoDao.class);

	public void insertNewPerson(Person person){
		try {
			mongoConfig.mongoTemplate().insert(person);
			LOG.info("Person added to mongo.. " + person);
		}
		catch (Exception e) {
			LOG.error("Failed to add person to mongo " + e.getMessage());
		}
	}


	public void updatePersonsAge(String name, int age){
		Query query = new Query();
		Person existingPerson = null;
		try {
			existingPerson = mongoConfig.mongoTemplate().findOne(query.addCriteria(Criteria.where("name").
					is(name)), 
					Person.class);
		}
		catch (Exception e) {
			LOG.error("Failed to get person's age " + e.getMessage());
		}

		try {
			existingPerson.setAge(age);
			mongoConfig.mongoTemplate().save(existingPerson);
		}
		catch (Exception e) {
			LOG.error("Failed to update person's age " + e.getMessage());
		}
	}

	public List<Person> findPersonByAge(int age){
		Query query = new Query();
		query.addCriteria(Criteria.where("age").is(age));

		List<Person> persons = null;
		try {
			persons = mongoConfig.mongoTemplate().find(query, Person.class);
		}
		catch (Exception e) {
			LOG.error("Failed to find all person's " + e.getMessage());
		}
		return persons;
	}

}
