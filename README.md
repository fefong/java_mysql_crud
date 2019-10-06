Java CRUD with MySQL
======================

Example Java using MySQL

* **CRUD**
  *  **C** - _CREATE_
  *  **R** - _READ_
  *  **U** - _UPDATE_
  *  **D** - _DELETE_


## MySQL

Download XAMP: 

* **MySQL**
  * Database;
  * Tables;
  * Procedures;
  * Views;
* _mysql-script:_ [script.sql](scripts/script.sql)


## Model

_Model:_ [Person](src/model/Person.java);

```java
public class Person {

	private int id;
	private String name;
    private Date date;

    //Getters and Setters
}
```
See [Getters and Setters](https://github.com/fefong/java_GettersAndSetters);


## Driver JDBC

**Driver MySQL**: [mysql-connector 5.1.15](https://github.com/fefong/java_mysql_crud/raw/master/libs/mysql-connector-java-5.1.15-bin.jar)

## Imports

```java
 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.Statement;
```

## xxx

```java
Connection cn;
String userDB = "root";
String passwordDB = "";
String databaseDB = "database_test";

```

```java
Class.forName(driver);
cn = DriverManager.getConnection(String url,String user, String password);
```
:warning: _Need add **throws declaration** or **surround with try/catch**;_



## Procedure

```java
CallableStatement cstmt = cn.prepareCall("{ call stp_insert_person (?, ?) }");

cstmt.setString(1, person.getName());
```

:warning: _Need add **throws declaration** or **surround with try/catch**;_

## View

...

## Throws

* _SQLException;_
* _ClassNotFoundException;_


## Project

_Download:_ [Java MySQL - CRUD]()

## Some links for more in depth learning

* [JAVA](https://github.com/search?q=fefong%2Fjava)
* [JAVA PRINT](https://github.com/fefong/java_print);
* [JAVA SWITCH CASE](https://github.com/fefong/java_switch);
* [JAVA IF/ELSE](https://github.com/fefong/java_ifElse);
* [JAVA ARITHMETIC](https://github.com/fefong/java_calculator);


