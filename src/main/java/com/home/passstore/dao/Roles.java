package com.home.passstore.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Roles implements Serializable{
	private static final long serialVersionUID = 8845703174370765233L;

	@Id
	@Column(name = "roleid")
	private int roleid;
	@Column(name = "role")
	private String role;
	
	public Roles(){
		
	}
	
	public Roles(int roleid, String role) {
		this.roleid = roleid;
		this.role = role;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getRoleid() {
		return roleid;
	}
	
	@Override
	public String toString() {
		return "roles [roleid=" + roleid + ", role=" + role + "]";
	}
}

