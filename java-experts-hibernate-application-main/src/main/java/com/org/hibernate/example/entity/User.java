package com.org.hibernate.example.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	 
	@Embedded
	private Name name;
	
    private String email;
	
    	@Embedded
    	@AttributeOverrides(value = {
    			@AttributeOverride(name = "addressLine1", column = @Column(name = "house_number")),
    			@AttributeOverride(name = "addressLine2", column = @Column(name = "street"))
    })

    	private Address address;
    	

    	    public User(Name name, String email, Address address) {
    	        this.name = name;
    	        this.email = email;
    	        this.address = address;
    	    }

			public long getId() {
				return id;
			}

			public void setId(long id) {
				this.id = id;
			}

			public Name getName() {
				return name;
			}

			public void setName(Name name) {
				this.name = name;
			}

			public String getEmail() {
				return email;
			}

			public void setEmail(String email) {
				this.email = email;
			}

			public Address getAddress() {
				return address;
			}

			public void setAddress(Address address) {
				this.address = address;
			}

}
