package com.example.demo;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Contact {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;
	private String name;
	private String nickname;
	private String phone;
	private String email;
	
	@Column(length=50)
	private String description;
	
	private String work;
	private String image;
	
	
	@ManyToOne
    private User user;
	
	public Contact() {
		super();
	}
	

	
	public Contact(int cid, String name, String nickname, String phone, String email, String description, String work,
			String image,User user) {
		super();
		this.cid = cid;
		this.name = name;
		this.nickname = nickname;
		this.phone = phone;
		this.email = email;
		this.description = description;
		this.work = work;
		this.image = image;
		this.user=user;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public User getUser()
	{
	return user;
	
	}
	 public void setUser(User user)
	 {
		 this.user=user;
	 }



	@Override
	public String toString() {
		return "Contact [cid=" + cid + ", name=" + name + ", nickname=" + nickname + ", phone=" + phone + ", email="
				+ email + ", description=" + description + ", work=" + work + ", image=" + image + ", user=" + user
				+ "]";
	}
	
}
