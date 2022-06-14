
package com.org.hibernate.example.DAO;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.org.hibernate.example.config.HibernateUtil;
import com.org.hibernate.example.entity.Student;

import javax.persistence.Query;


public class StudentDao {
	public void saveStudent(Student student) {
    Transaction transaction = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        // start a transaction
        transaction = session.beginTransaction();
        // save the student object
        session.save(student);
        // commit transaction
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    }
}
	public void insertStudent() {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            String hql = "INSERT INTO Student (firstName, lastName, email) " +
                "SELECT firstName, lastName, email FROM Student";
            Query query = session.createQuery(hql);
            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
	 public void updateStudent(Student student) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();

	            // save the student object
	            String hql = "UPDATE Student set firstName = :firstName " + "WHERE id = :studentId";
	            Query query = session.createQuery(hql);
	            query.setParameter("firstName", student.getFirstName());
	            query.setParameter("studentId", 1);
	            int result = query.executeUpdate();
	            System.out.println("Rows affected: " + result);

	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }
	 public void deleteStudent(int id) {

	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();

	            // Delete a student object
	            Student student = session.get(Student.class, id);
	            if (student != null) {
	                String hql = "DELETE FROM Student " + "WHERE id = :studentId";
	                Query query = session.createQuery(hql);
	                query.setParameter("studentId", id);
	                int result = query.executeUpdate();
	                System.out.println("Rows affected: " + result);
	            }

	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }
public List <Student> getStudents() {
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        return session.createQuery("from Student", Student.class).list();
    }
}
}