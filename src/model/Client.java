package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ClientDAO;

public class Client {
	private int id;
	private String name;
	private String phone;
	private String email;	
	private ClientDAO dao;
	
	public Client(){
		dao = new ClientDAO();
	}

	public Client(int id, String name, String phone, String email) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		dao = new ClientDAO();
	}
	
	public void create(){
		dao.create(this);
	}
	
	public void update(){
		dao.update(this);
	}
	
	public void delete(){
		dao.delete(this);
	}
	
	public void load(){
		Client  client = dao.load(id);
		setName	(client.getName());
		setPhone	(client.getPhone());
		setEmail(client.getEmail());
		setId	(client.getId());
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


	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + name + ", fone=" + phone
				+ ", email=" + email + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
