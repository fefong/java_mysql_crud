# Database

## Connect

```java
protected boolean conect() {
  try {
    Class.forName(driver);
		cn = DriverManager.getConnection(url + database, user, password);
		return true;
    } catch (ClassNotFoundException e) {
      logger.warning(e.getMessage());
      return false;
    } catch (SQLException e) {
      logger.warning(String.format("Code: %s | Message: %s", e.getErrorCode(), e.getMessage()));
		return false;  
    }
}
```
* See [Variables](https://github.com/fefong/java_mysql_crud/blob/master/README.md#variables)
* See [Constants](https://github.com/fefong/java_mysql_crud/blob/master/README.md#constants)

## Disconnect

```java
protected boolean disconect() {
  try {
    cn.close();
    return true;
  } catch (SQLException e) {
    logger.warning(String.format("Code: %s | Message: %s", e.getErrorCode(), e.getMessage()));
  }
  return false;
}
```
* See [Variables](https://github.com/fefong/java_mysql_crud/blob/master/README.md#variables)
* See [Constants](https://github.com/fefong/java_mysql_crud/blob/master/README.md#constants)

## Interface
 
  ```java
public Person insert(Person person);
  ```
  
  ```java
public Person update(int id, Person personUpdated);
  ```
  
  ```java
public Person delete(int id);
  ```
  ```java
public List<Person> getAll();
  ```
  
  ```java
public Person findById(int id);
  ```
  
  ```java
public List<Person> list(int[] listPerson);
  ```
* See [Integer Array](https://github.com/fefong/java_variables#integer-array)

##  PersonDAO

* See [PersonDAO](https://github.com/fefong/java_mysql_crud/blob/master/src/dao/PersonDAO.java)
  
