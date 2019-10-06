package dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import model.Person;

public class PersonDAO extends database implements IDAO {

	static final String PROCEDURE_INSERT_PERSON = "{ call stp_insert_person (?, ? ) }";
	static final String PROCEDURE_UPDATE_PERSON = "{ call stp_update_person (?, ?, ? ) }";
	static final String PROCEDURE_DELETE_PERSON = "{ call stp_delete_person (? ) }";

	static final String VIEW_PERSON = "SELECT * FROM view_person";

	static private final String COLUMN_ID = "id_person";
	static private final String COLUMN_NAME = "name_person";
	static private final String COLUMN_DATE = "date_person";

	Logger logger = Logger.getLogger(PersonDAO.class.getName());

	@Override
	public Person insert(Person person) {
		if (conect()) {

			try {
				CallableStatement cstmt = cn.prepareCall(PROCEDURE_INSERT_PERSON);
				cstmt.setString(1, person.getName());
				cstmt.setDate(2, java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(person.getDate())));

				cstmt.execute();
				logger.info("Person inserted.");
			} catch (SQLException e) {
				logger.warning(String.format("Code: %s | Message: %s", e.getErrorCode(), e.getMessage()));
			}
		}
		return null;
	}

	@Override
	public Person update(int id, Person personUpdated) {
		if (conect()) {

			try {
				CallableStatement cstmt = cn.prepareCall(PROCEDURE_UPDATE_PERSON);
				cstmt.setInt(1, id);
				cstmt.setString(2, personUpdated.getName());
				cstmt.setDate(3,
						java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(personUpdated.getDate())));

				cstmt.execute();
				logger.info(String.format("Person {%d} updated.", id));

			} catch (SQLException e) {
				logger.warning(String.format("Code: %s | Message: %s", e.getErrorCode(), e.getMessage()));
			}

		}

		return null;
	}

	@Override
	public Person delete(int id) {

		if (conect()) {

			try {
				CallableStatement cstmt = cn.prepareCall(PROCEDURE_DELETE_PERSON);
				cstmt.setInt(1, id);

				cstmt.execute();
				logger.info(String.format("Person {%d} deleted.", id));

			} catch (SQLException e) {
				logger.warning(String.format("Code: %s | Message: %s", e.getErrorCode(), e.getMessage()));
			}

		}
		return null;
	}

	@Override
	public List<Person> list(int[] listPerson) {

		List<Person> persons = new ArrayList<Person>();

		for (int id : listPerson) {
			persons.add(findById(id));
		}

		return persons;
	}

	@Override
	public List<Person> getAll() {
		List<Person> persons = new ArrayList<Person>();

		if (conect()) {
			try {
				st = cn.createStatement();
				rs = st.executeQuery(VIEW_PERSON);

				while (rs.next()) {
					persons.add(new Person(rs.getInt(COLUMN_ID), rs.getString(COLUMN_NAME), rs.getDate(COLUMN_DATE)));
				}
			} catch (SQLException e) {
				return null;
			}
		}
		return persons;
	}

	@Override
	public Person findById(int id) {

		if (conect()) {
			try {
				PreparedStatement stmt = cn.prepareStatement(VIEW_PERSON + " WHERE " + COLUMN_ID + " = ?");
				stmt.setInt(1, id);

				rs = stmt.executeQuery();

				if (rs.next()) {
					Person person = new Person();
					person.setId(rs.getInt(COLUMN_ID));
					person.setName(rs.getString(COLUMN_NAME));
					person.setDate(rs.getDate(COLUMN_DATE));

					return person;
				} else {
					return null;
				}
			} catch (SQLException e) {
				return null;
			}
		}
		return null;
	}

}
