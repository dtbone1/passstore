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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + roleid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Roles other = (Roles) obj;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (roleid != other.roleid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "roles [roleid=" + roleid + ", role=" + role + "]";
	}
}

