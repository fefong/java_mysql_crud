package model;

import java.util.Date;

public class Person {

	private int id;
	private String name;
	private Date date;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Person(int id, String name, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
	}

	public Person() {
	}

	@Override
	public String toString() {
		return String.format("\nPerson:\n\t-id:%s\n\t-name:%s\n\t-date:%s\n", id, name, date);
	}


}
