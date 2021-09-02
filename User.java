package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
    @NotBlank(message="Name must be required!!")
    @Size(min=2,max=15,message="name must have character between 2-15")
	private String name;
	
	
	   
    @Column(unique=true)
    @NotBlank(message="Name must be required!!")
	@Email(regexp= "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message="must be well-formed email address")
	private String email;

	
	@Column(length=50)
	private String about;
	
	private String image;
	private boolean enabled;
	
	@NotBlank
	private String password;
	
	private String role;
	
	@AssertTrue(message="Must agree terms and condition!!")
	private boolean agreement;

	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="user")
	private List<Contact> contacts=new ArrayList<>();
	
	
	public User() {
		super();
		
	}
	public User(int id, String name, String email, String about, String image, boolean enabled, String password,String role,List<Contact> contacts) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.about = about;
		this.image = image;
		this.enabled = enabled;
		this.password = password;
		this.role=role;
		this.contacts=contacts;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole()
	{
		return role;
		
	}
	public void setRole(String role)
	{
		this.role=role;
	}
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
	public boolean isAgreement() {
		return agreement;
	}
	public void setAgreement(boolean agreement) {
		this.agreement = agreement;
	}
	/*
	 * @Override public String toString() { return "User [id=" + id + ", name=" +
	 * name + ", email=" + email + ", about=" + about + ", image=" + image +
	 * ", enabled=" + enabled + ", password=" + password + ", role=" + role +
	 * ", contacts=" + contacts + "]"; }
	 */
	
	
	
	
	
}
