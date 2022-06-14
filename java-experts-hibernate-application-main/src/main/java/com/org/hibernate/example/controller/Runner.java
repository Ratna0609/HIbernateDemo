package com.org.hibernate.example.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.org.hibernate.example.DAO.ProjectDao;
import com.org.hibernate.example.DAO.StudentDao;
import com.org.hibernate.example.config.HibernateUtil;
import com.org.hibernate.example.entity.Address;
import com.org.hibernate.example.entity.Name;
import com.org.hibernate.example.entity.Project;
import com.org.hibernate.example.entity.ProjectStatus;
import com.org.hibernate.example.entity.Student;
import com.org.hibernate.example.entity.User;


public class Runner {

	public static void main(String[] args) {
		/*
		 * StudentDao studentDao = new StudentDao(); Student student = new
		 * Student("Ratna", "kumari", "rk@gmail.com"); studentDao.saveStudent(student);
		 */

		/*
		 * List <Student> students = studentDao.getStudents(); students.forEach(s ->
		 * System.out.println(s.getFirstName()));
		 */
        
        
       
            ProjectDao projectDao = new ProjectDao();
            Project project = new Project();
            project.setProjectName("BOUP1");
            project.setProjectStatus(ProjectStatus.INPROGESS);
            projectDao.saveProject(project);

            List < Project > projects = projectDao.getProjects();
            projects.forEach(s -> {
                System.out.println(s.getProjectName());
                System.out.println(s.getProjectStatus());
            });
            
            Name name = new Name("Ratna", "Nalajala", "Kumari");
            Address address = new Address("111", "oaksdrive", "hollysprings", "NC", "USA", "27540");
            User user = new User(name, "nratna0609@gmail.com", address);

            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                // start a transaction
                transaction = session.beginTransaction();
                // save the student object
                session.save(user);
                // commit transaction
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
    }
}
