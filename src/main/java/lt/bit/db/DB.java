package lt.bit.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
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

    public static List<Person> getAll(EntityManager em) {
        Query q = em.createQuery("select p from Person p");
        return q.getResultList();
    }

    public static List<Address> getAllAddresses() {
    	try (Connection conn = DriverManager.getConnection(CONN_URL, "root", "root");
    			Statement statement = conn.createStatement();
    			ResultSet resultSet = statement.executeQuery("select * from address")) {
    		List<Address> list = new ArrayList<>();
    		while (resultSet.next()) {
    			Address a = new Address();
    			a.setId(resultSet.getObject("id", Integer.class));
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
    
    public static List<Address> getPersonAddresses(Integer id, EntityManager em) {
        Person p = em.find(Person.class, id);
        return p.getAddresses();
    }

    public static List<Contact> getPersonContacts(Integer id, EntityManager em) {
        Person p = em.find(Person.class, id);
        return p.getContacts();
    }
    
    public static Person getById(Integer id, EntityManager em) {
        return em.find(Person.class, id);
    }
    
    public static Person getByAddress(Address a, EntityManager em) {
        Address adr = em.find(Address.class, a.getId());
        return adr.getPerson();
    }

    public static Person getByContact(Contact c, EntityManager em) { 
        Address con = em.find(Address.class, c.getId());
        return con.getPerson();
    }
    public static Address getAddressById(Integer id, EntityManager em) {
        Address adr = em.find(Address.class, id);
        return adr;
    }

    public static Contact getContactById(Integer id, EntityManager em) {
    	Contact con = em.find(Contact.class, id);
        return con;
    }
    
    public static Person add(Person p, EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(p);
        tx.commit();  
        return p;
    }
    
    public static Address addAddress(Integer personId, Address a, EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        Person p = em.find(Person.class, personId);
        tx.begin();
        a.setPerson(p);
        em.persist(a);
        tx.commit();  
        return a;
    }

    public static Contact addContact(Integer personId, Contact c, EntityManager em) {
    	EntityTransaction tx = em.getTransaction();
        Person p = em.find(Person.class, personId);
        tx.begin();
        c.setPerson(p);
        em.persist(c);
        tx.commit();
        return c;
    }
    
    public static Person update(Person p, EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Person pDb = em.find(Person.class, p.getId());
        pDb.setFirstName(p.getFirstName());
        pDb.setLastName(p.getLastName());
        pDb.setBirthDate(p.getBirthDate());
        pDb.setSalary(p.getSalary());
        em.flush();
        tx.commit(); 
        return pDb;
    }

    public static Address updateAddress(Address a, EntityManager em) {
    	EntityTransaction tx = em.getTransaction();
        tx.begin();
        Address adr = em.find(Address.class, a.getId());
        adr.setAddress(a.getAddress());
        adr.setCity(a.getCity());
        adr.setPostalCode(a.getPostalCode());
        em.flush();
        tx.commit(); 
        return adr;
    }

    public static Contact updateContact(Contact c, EntityManager em) {
    	EntityTransaction tx = em.getTransaction();
        tx.begin();
    	Contact con = em.find(Contact.class, c.getId());
        con.setType(c.getType());
        con.setContact(c.getContact());
        em.flush();
        tx.commit(); 
        return con;
    }

    public static void delete(Integer id, EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Person p = em.find(Person.class, id);
        em.remove(p);
        tx.commit();
    }

    public static Address deleteAddress(Integer id, EntityManager em) {
    	EntityTransaction tx = em.getTransaction();
        tx.begin();
        Address a = em.find(Address.class, id);
        em.remove(a);
        tx.commit();
        return a;
    }

    public static Contact deleteContact(Integer id, EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Contact c = em.find(Contact.class, id);
        em.remove(c);
        tx.commit();
        return c;
    }

}
