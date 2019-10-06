import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.PersonDAO;
import model.Person;

public class Main {

	static PersonDAO personDAO;
	static Scanner in;

	private static String getMenu() {
		StringBuilder sbMenu = new StringBuilder();

		sbMenu.append("*---------------- MENU ----------------*\n");
		sbMenu.append("|    1 - List                          |\n");
		sbMenu.append("|      1.0 - (Get All)                 |\n");
		sbMenu.append("|      1.1 - (Get List)                |\n");
		sbMenu.append("|      1.2 - (FindByID)                |\n");
		sbMenu.append("|    2 - Insert                        |\n");
		sbMenu.append("|    3 - Update                        |\n");
		sbMenu.append("|    4 - Delete                        |\n");
		sbMenu.append("*--------------------------------------*\n");
		sbMenu.append("Enter [1-4]: ");

		return sbMenu.toString();
	}

	public static void main(String[] args) {

		in = new Scanner(System.in);

		double choice = -1;
		while (choice < 1 || choice > 4) {

			System.out.print(getMenu());
			choice = Double.parseDouble(in.next());
			if (choice < 1 || choice > 4) {
				System.out.println("\n> Invalid choice. <");
			}

		

		if (choice == 1.0) {
			System.out.println("------- List [Get All] -------");
			listAll();

		} else if (choice == 1.1) {
			System.out.println("------- List [Get List] -------");
			listPerson();

		} else if (choice == 1.2) {
			System.out.println("------- List [FindByID] -------");
			listById();

		} else if (choice == 2) {
			System.out.println("------- Insert -------");
			insertPerson();

		} else if (choice == 3) {
			System.out.println("------- Update -------");
			updatePerson();

		} else if (choice == 4) {
			System.out.println("------- Delete -------");
			deletePerson();

		}
		choice = -1;
		System.out.println("\n");
		}

	}

	private static void deletePerson() {
		System.out.println("Enter ID: ");
		int id = in.nextInt();

		personDAO = new PersonDAO();
		personDAO.delete(id);

	}

	private static void updatePerson() {

		Person person = new Person();

		System.out.print("Enter ID registered: ");
		int id = in.nextInt();
		System.out.print("Enter [Update] Person Name: ");
		person.setName(in.next());

		System.out.print("Enter [Update] Person Date[yyyy-mm-dd]: ");
		try {
			person.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(in.next()));

		} catch (ParseException e) {
			System.out.println("Invalid date");
		}

		personDAO = new PersonDAO();
		personDAO.update(id, person);

	}

	private static void insertPerson() {

		Person person = new Person();

		System.out.print("Person Name: ");
		person.setName(in.next());

		System.out.print("Person Date [yyyy-mm-dd]: ");
		try {
			person.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(in.next()));

		} catch (ParseException e) {
			System.out.println("Invalid date");
		}

		personDAO = new PersonDAO();
		personDAO.insert(person);
	}

	private static void listPerson() {

		System.out.print("Enter list size: ");
		int size = in.nextInt();

		int[] listIds = new int[size];

		for (int i = 0; i < size; i++) {
			System.out.print(String.format("Enter ID[%d]: ", i));
			listIds[i] = in.nextInt();
		}
		System.out.println("IDs: " + Arrays.toString(listIds));

		personDAO = new PersonDAO();
		List<Person> persons = personDAO.list(listIds);

		System.out.println(persons);
	}

	private static void listById() {
		System.out.print("Find by ID: ");
		int id = in.nextInt();

		personDAO = new PersonDAO();
		Person person = personDAO.findById(id);
		if (person != null) {
			System.out.println(person);
		} else {
			System.out.println(String.format("No person found with id[%s].", id));
		}

	}

	private static void listAll() {
		personDAO = new PersonDAO();
		List<Person> persons = personDAO.getAll();

		System.out.println(persons);
	}

}
