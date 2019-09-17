package lt.bit.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lt.bit.data.Address;
import lt.bit.data.Contact;
import lt.bit.data.Person;

public class DB {
	// JPA, API, ORM
    public static final String CONN_URL = "jdbc:mysql://localhost:3306/address_book";

    static {
    	try {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

    public static List<Person> getAll() {
    	try (Connection conn = DriverManager.getConnection(CONN_URL, "root", "root");
    			Statement statement = conn.createStatement();
    			ResultSet resultSet = statement.executeQuery("select * from person")) {
    		List<Person> list = new ArrayList<>();
    		while (resultSet.next()) {
    			Person p = new Person();
    			p.setId(resultSet.getObject("id", Integer.class));
    			p.setFirstName(resultSet.getString("first_name"));
    			p.setLastName(resultSet.getString("last_name"));
    			p.setBirthDate(resultSet.getDate("birth_date"));
    			p.setSalary(resultSet.getBigDecimal("salary"));
    			list.add(p);
    		}
    		return list;
    	} catch (Exception e) {
    		e.printStackTrace();
    		return new ArrayList<>();
    	}
    }

    public static List<Address> getAllAddresses() {
    	try (Connection conn = DriverManager.getConnection(CONN_URL, "root", "root");
    			Statement statement = conn.createStatement();
    			ResultSet resultSet = statement.executeQuery("select * from address")) {
    		List<Address> list = new ArrayList<>();
    		while (resultSet.next()) {
    			Address a = new Address();
    			a.setId(resultSet.getObject("id", Integer.class));
    			a.setPersonId(resultSet.getObject("person_id", Integer.class));
    			a.setAddress(resultSet.getString("address"));
    			a.setCity(resultSet.getString("city"));
    			a.setPostalCode(resultSet.getString("postal_code"));
    			list.add(a);
    		}
    		return list;
    	} catch (Exception e) {
    		e.printStackTrace();
    		return new ArrayList<>();
    	}
    }

    public static List<Contact> getAllContacts() {
    	try (Connection conn = DriverManager.getConnection(CONN_URL, "root", "root");
    			Statement statement = conn.createStatement();
    			ResultSet resultSet = statement.executeQuery("select * from contact")) {
    		List<Contact> list = new ArrayList<>();
    		while (resultSet.next()) {
    			Contact c = new Contact();
    			c.setId(resultSet.getObject("id", Integer.class));
    			c.setPersonId(resultSet.getObject("person_id", Integer.class));
    			c.setType(resultSet.getString("type"));
    			c.setContact(resultSet.getString("contact"));
    			list.add(c);
    		}
    		return list;
    	} catch (Exception e) {
    		e.printStackTrace();
    		return new ArrayList<>();
    	}
    }

    public static List<Address> getPersonAddresses(Integer id) {
    	try (Connection conn = DriverManager.getConnection(CONN_URL, "root", "root");
    			Statement statement = conn.createStatement();
    			ResultSet resultSet = statement.executeQuery("select * from address where person_id = " + id)) {
    		List<Address> list = new ArrayList<>();
    		while (resultSet.next()) {
    			Address a = new Address();
    			a.setId(resultSet.getObject("id", Integer.class));
    			a.setPersonId(resultSet.getObject("person_id", Integer.class));
    			a.setAddress(resultSet.getString("address"));
    			a.setCity(resultSet.getString("city"));
    			a.setPostalCode(resultSet.getString("postal_code"));
    			list.add(a);
    		}
    		return list;
    	} catch (Exception e) {
    		e.printStackTrace();
    		return new ArrayList<>();
    	}
    }

    public static List<Contact> getPersonContacts(Integer id) {
    	try (Connection conn = DriverManager.getConnection(CONN_URL, "root", "root");
    			Statement statement = conn.createStatement();
    			ResultSet resultSet = statement.executeQuery("select * from contact where person_id = " + id)) {
    		List<Contact> list = new ArrayList<>();
    		while (resultSet.next()) {
    			Contact c = new Contact();
    			c.setId(resultSet.getObject("id", Integer.class));
    			c.setPersonId(resultSet.getObject("person_id", Integer.class));
    			c.setType(resultSet.getString("type"));
    			c.setContact(resultSet.getString("contact"));
    			list.add(c);
    		}
    		return list;
    	} catch (Exception e) {
    		e.printStackTrace();
    		return new ArrayList<>();
    	}
    }

    public static Person getById(Integer id) {
    	try (Connection conn = DriverManager.getConnection(CONN_URL, "root", "root");
    			Statement statement = conn.createStatement();
    			ResultSet resultSet = statement.executeQuery("select * from person where id = " + id)) {
    		while (resultSet.next()) {
    			Person p = new Person();
    			p.setId(resultSet.getObject("id", Integer.class));
    			p.setFirstName(resultSet.getString("first_name"));
    			p.setLastName(resultSet.getString("last_name"));
    			p.setBirthDate(resultSet.getDate("birth_date"));
    			p.setSalary(resultSet.getBigDecimal("salary"));
    			return p;
    		}
    		return null;
    	} catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }

    public static Person getByAddress(Address a) {
    	try (Connection conn = DriverManager.getConnection(CONN_URL, "root", "root");
    			Statement statement = conn.createStatement();
    			ResultSet resultSet = statement.executeQuery("select * from person where id = " + a.getPersonId())) {
    		if (resultSet.next()) {
    			Person p = new Person();
    			p.setId(resultSet.getObject("id", Integer.class));
    			p.setFirstName(resultSet.getString("first_name"));
    			p.setLastName(resultSet.getString("last_name"));
    			p.setBirthDate(resultSet.getDate("birth_date"));
    			p.setSalary(resultSet.getBigDecimal("salary"));
    			return p;
    		}
    		return null;
    	} catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }

    public static Person getByContact(Contact c) { // keistas solo
    	try (Connection conn = DriverManager.getConnection(CONN_URL, "root", "root");
    			Statement statement = conn.createStatement();
    			ResultSet resultSet = statement.executeQuery("select * from person where id = " + c.getPersonId())) {
    		if (resultSet.next()) {
    			Person p = new Person();
    			p.setId(resultSet.getObject("id", Integer.class));
    			p.setFirstName(resultSet.getString("first_name"));
    			p.setLastName(resultSet.getString("last_name"));
    			p.setBirthDate(resultSet.getDate("birth_date"));
    			p.setSalary(resultSet.getBigDecimal("salary"));
    			return p;
    		}
    		return null;
    	} catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }

    public static Address getAddressById(Integer id) {
    	try (Connection conn = DriverManager.getConnection(CONN_URL, "root", "root");
    			Statement statement = conn.createStatement();
    			ResultSet resultSet = statement.executeQuery("select * from address where id = " + id)) {
    		while (resultSet.next()) {
    			Address a = new Address();
    			a.setId(resultSet.getObject("id", Integer.class));
    			a.setPersonId(resultSet.getObject("person_id", Integer.class));
    			a.setAddress(resultSet.getString("address"));
    			a.setCity(resultSet.getString("city"));
    			a.setPostalCode(resultSet.getString("postal_code"));
    			return a;
    		}
    		return null;
    	} catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }

    public static Contact getContactById(Integer id) {
    	try (Connection conn = DriverManager.getConnection(CONN_URL, "root", "root");
    			Statement statement = conn.createStatement();
    			ResultSet resultSet = statement.executeQuery("select * from contact where id = " + id)) {
    		while (resultSet.next()) {
    			Contact c = new Contact();
    			c.setId(resultSet.getObject("id", Integer.class));
    			c.setPersonId(resultSet.getObject("person_id", Integer.class));
    			c.setType(resultSet.getString("type"));
    			c.setContact(resultSet.getString("contact"));
    			return c;
    		}
    		return null;
    	} catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }

    public static Person add(Person p) {
    	try (Connection conn = DriverManager.getConnection(CONN_URL, "root", "root");
    			PreparedStatement preparedStatement = conn.prepareStatement("insert into person (first_name, last_name, "
    					+ "birth_date, salary) values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
    		preparedStatement.setString(1, p.getFirstName());
    		preparedStatement.setString(2, p.getLastName());
    		if (p.getBirthDate() != null) {
    			java.sql.Date bd = new java.sql.Date(p.getBirthDate().getTime());
    			preparedStatement.setDate(3, bd);
    		} else {
    			preparedStatement.setNull(3, java.sql.Types.DATE);
    		}
    		if (p.getSalary() != null) {
    			preparedStatement.setBigDecimal(4, p.getSalary());
    		} else {
    			preparedStatement.setNull(4, java.sql.Types.NUMERIC);
    		}
    		preparedStatement.execute();
    		try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
    			if (rs.next()) {
    				p.setId(rs.getInt(1));
    			}
    		}
    		return p;
    	} catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }

    public static Address addAddress(Integer personId, Address a) {
    	try (Connection conn = DriverManager.getConnection(CONN_URL, "root", "root");
    			PreparedStatement preparedStatement = conn.prepareStatement("insert into address (person_id, address, city, "
    					+ "postal_code) values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
    		preparedStatement.setInt(1, personId);
    		preparedStatement.setString(2, a.getAddress());
    		preparedStatement.setString(3, a.getCity());
    		preparedStatement.setString(4, a.getPostalCode());
    		preparedStatement.execute();
    		try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
    			if (rs.next()) {
    				a.setId(rs.getInt(1));
    			}
    		}
    		return a;
    	} catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }

    public static Contact addContact(Integer personId, Contact c) {
    	try (Connection conn = DriverManager.getConnection(CONN_URL, "root", "root");
    			PreparedStatement preparedStatement = conn.prepareStatement("insert into contact (person_id, type, contact)"
    					+ " values (?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
    		preparedStatement.setInt(1, personId);
    		preparedStatement.setString(2, c.getType());
    		preparedStatement.setString(3, c.getContact());
    		preparedStatement.execute();
    		try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
    			if (rs.next()) {
    				c.setId(rs.getInt(1));
    			}
    		}
    		return c;
    	} catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }

    public static Person update(Person p) {
    	try (Connection conn = DriverManager.getConnection(CONN_URL, "root", "root");
    			PreparedStatement preparedStatement = conn.prepareStatement("update person set first_name = ?, last_name = ?, "
    					+ "birth_date = ?, salary = ? where id = ?")) {
    		preparedStatement.setString(1, p.getFirstName());
    		preparedStatement.setString(2, p.getLastName());
    		if (p.getBirthDate() != null) {
    			java.sql.Date bd = new java.sql.Date(p.getBirthDate().getTime());
    			preparedStatement.setDate(3, bd);
    		} else {
    			preparedStatement.setNull(3, java.sql.Types.DATE);
    		}
    		if (p.getSalary() != null) {
    			preparedStatement.setBigDecimal(4, p.getSalary());
    		} else {
    			preparedStatement.setNull(4, java.sql.Types.NUMERIC);
    		}
    		preparedStatement.setInt(5, p.getId());
    		preparedStatement.executeUpdate();
    		return p;
    	} catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }

    public static Address updateAddress(Address a) {
    	try (Connection conn = DriverManager.getConnection(CONN_URL, "root", "root");
    			PreparedStatement preparedStatement = conn.prepareStatement("update address set address = ?, city = ?, "
    					+ "postal_code = ? where id = ?")) {
    		preparedStatement.setString(1, a.getAddress());
    		preparedStatement.setString(2, a.getCity());
    		preparedStatement.setString(3, a.getPostalCode());
    		preparedStatement.setInt(4, a.getId());
    		preparedStatement.executeUpdate();
    		return a;
    	} catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }

    public static Contact updateContact(Contact c) {
    	try (Connection conn = DriverManager.getConnection(CONN_URL, "root", "root");
    			PreparedStatement preparedStatement = conn.prepareStatement("update contact set type = ?, contact = ? "
    					+ " where id = ?")) {
    		preparedStatement.setString(1, c.getType());
    		preparedStatement.setString(2, c.getContact());
    		preparedStatement.setInt(3, c.getId());
    		preparedStatement.executeUpdate();
    		return c;
    	} catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }

    public static void delete(Integer id) {
    	try (Connection conn = DriverManager.getConnection(CONN_URL, "root", "root");
    			Statement statement = conn.createStatement()) {
    		statement.execute("delete from person where id = " + id);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

    public static void deleteAddress(Integer id) {
    	try (Connection conn = DriverManager.getConnection(CONN_URL, "root", "root");
    			Statement statement = conn.createStatement()) {
    		statement.execute("delete from address where id = " + id);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

    public static void deleteContact(Integer id) {
    	try (Connection conn = DriverManager.getConnection(CONN_URL, "root", "root");
    			Statement statement = conn.createStatement()) {
    		statement.execute("delete from contact where id = " + id);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

}
