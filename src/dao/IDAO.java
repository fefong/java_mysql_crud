package dao;

import java.util.List;

import model.Person;

public interface IDAO {

	public Person insert(Person person);

	public Person update(int id, Person personUpdated);

	public Person delete(int id);

	public List<Person> getAll();
	
	public List<Person> list(int[] listPerson);

	public Person findById(int id);
}
