/**
 * 
 */
package com.org.hibernate.example.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author nalaj
 *
 */
 @Entity
 @Table(name = "employee_text")
public class Employee {
	 @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		 
		@Embedded
		private Name empName;
		
		
}
