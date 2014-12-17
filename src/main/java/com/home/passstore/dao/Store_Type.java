package com.home.passstore.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="store_type")
public class Store_Type implements Serializable{
	private static final long serialVersionUID = -6867641165077406637L;

	@Id
	@Column(name = "storeid")
	private int storeid;
	@Column(name = "type")
	private String type;
	
	public Store_Type(){
		
	}
	
	public Store_Type(int storeid, String type) {
		this.storeid = storeid;
		this.type = type;
	}

	public int getStoreid() {
		return storeid;
	}

	public void setStoreid(int storeid) {
		this.storeid = storeid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + storeid;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Store_Type other = (Store_Type) obj;
		if (storeid != other.storeid)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Store_Type [storeid=" + storeid + ", type=" + type + "]";
	}
}
