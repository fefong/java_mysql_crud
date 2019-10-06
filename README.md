Java CRUD with MySQL
======================

Example Java using MySQL

* **CRUD**
  *  **C** - _CREATE_
  *  **R** - _READ_
  *  **U** - _UPDATE_
  *  **D** - _DELETE_


# Model

_Model:_ [Person](src/model/Person.java);

```java
public class Person {

private int id;
private String name;
private Date date;
    
//Getters and Setters
}
```
* See [Getters and Setters](https://github.com/fefong/java_GettersAndSetters);

# MySQL


* **MySQL**
  * Database;
  * Tables;
  * Procedures;
  * Views;
* _mysql-script:_ [script.sql](scripts/SCRIPT.sql)


### Driver JDBC

**Driver MySQL**: [mysql-connector 5.1.15](https://github.com/fefong/java_mysql_crud/raw/master/libs/mysql-connector-java-5.1.15-bin.jar)


# DAO

## Imports

```java
 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.Statement;
```

## Variables

```java
Connection cn;
private final String driver = "com.mysql.jdbc.Driver";
final String userDB = "root";
final String passwordDB = "";
final String databaseDB = "database_test";

private static final String ip = "localhost";
private static final String port = "3307";
private final String url = "jdbc:mysql://" + ip + ":" + port + "/";

ResultSet rs = null;
Statement st = null;
PreparedStatement ps = null;
CallableStatement stmt = null;
```

## Constants

```java
	static final String PROCEDURE_INSERT_PERSON = "{ call stp_insert_person (?, ? ) }";
	static final String PROCEDURE_UPDATE_PERSON = "{ call stp_update_person (?, ?, ? ) }";
	static final String PROCEDURE_DELETE_PERSON = "{ call stp_delete_person (? ) }";

	static final String VIEW_PERSON = "SELECT * FROM view_person";

	static private final String COLUMN_ID = "id_person";
	static private final String COLUMN_NAME = "name_person";
	static private final String COLUMN_DATE = "date_person";
```
* See [MySQL](#MySQL)

## Methods

:warning: _Need add **throws declaration** or **surround with try/catch**;_

### Method - Connect database

```java
Class.forName(driver);

cn = DriverManager.getConnection(String url,String user, String password);
```
* See [Variables](#Variables)

### Method - Disconnect database

```java
cn.close();
```

## Procedure

How to call procedure.

_Procedure:_ [Person](src/dao/PersonDAO.java);

```java
CallableStatement cstmt = cn.prepareCall("{ call stp_name (? ) }");
cstmt.setInt(1, id);

cstmt.execute();
```
* See [Variables](#Variables)
* See [Constants](#Constants)

## View

How to select VIEW.

_View:_ [Person](src/dao/PersonDAO.java);

```java
st = cn.createStatement();
rs = st.executeQuery("select * from view_name");

while (rs.next()) {
persons.add(
    new Person(
        rs.getInt(COLUMN_ID),
        rs.getString(COLUMN_NAME), 
        rs.getDate(COLUMN_DATE)
        )
    );
}
```
* See [Variables](#Variables)
* See [Constants](#Constants)

## Throws

* _SQLException;_
* _ClassNotFoundException;_


## Project

_Download:_ [Java MySQL - CRUD](https://github.com/fefong/java_mysql_crud)

## Some links for more in depth learning

* [JAVA](https://github.com/search?q=fefong%2Fjava)
* [JAVA PRINT](https://github.com/fefong/java_print);
* [JAVA SWITCH CASE](https://github.com/fefong/java_switch);
* [JAVA IF/ELSE](https://github.com/fefong/java_ifElse);
* [JAVA ARITHMETIC](https://github.com/fefong/java_calculator);

