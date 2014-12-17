package com.home.passstore.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="keychain")
public class Keychain implements Serializable{
	private static final long serialVersionUID = -2901932126594410440L;

	@Id
	@Column(name = "keychainid")
	private int keychainid;
	
	@Column(name = "encrypt1")
	private String encrypt1;
	
	@Column(name = "encrypt2")
	private String encrypt2;
	
	@Column(name = "encrypt3")
	private String encrypt3;
	
	@Column(name = "encrypt4")
	private String encrypt4;
	
	@Column(name = "encrypt5")
	private String encrypt5;
	
	@Column(name = "encrypt6")
	private String encrypt6;
	
	@Column(name = "encrypt7")
	private String encrypt7;
	
	@Column(name = "encrypt8")
	private String encrypt8;
	
	@Column(name = "encrypt9")
	private String encrypt9;
	
	@Column(name = "encrypt10")
	private String encrypt10;
	
	@Column(name = "storeid")
	private int storeid;
	
	@Column(name = "email")
	private String email;
	
	public Keychain(){
		
	}

	public Keychain(int keychainid, String encrypt1, String encrypt2,
			String encrypt3, String encrypt4, String encrypt5, String encrypt6,
			String encrypt7, String encrypt8, String encrypt9,
			String encrypt10, int storeid, String email) {
		this.keychainid = keychainid;
		this.encrypt1 = encrypt1;
		this.encrypt2 = encrypt2;
		this.encrypt3 = encrypt3;
		this.encrypt4 = encrypt4;
		this.encrypt5 = encrypt5;
		this.encrypt6 = encrypt6;
		this.encrypt7 = encrypt7;
		this.encrypt8 = encrypt8;
		this.encrypt9 = encrypt9;
		this.encrypt10 = encrypt10;
		this.storeid = storeid;
		this.email = email;
	}

	public int getKeychainid() {
		return keychainid;
	}

	public void setKeychainid(int keychainid) {
		this.keychainid = keychainid;
	}

	public String getEncrypt1() {
		return encrypt1;
	}

	public void setEncrypt1(String encrypt1) {
		this.encrypt1 = encrypt1;
	}

	public String getEncrypt2() {
		return encrypt2;
	}

	public void setEncrypt2(String encrypt2) {
		this.encrypt2 = encrypt2;
	}

	public String getEncrypt3() {
		return encrypt3;
	}

	public void setEncrypt3(String encrypt3) {
		this.encrypt3 = encrypt3;
	}

	public String getEncrypt4() {
		return encrypt4;
	}

	public void setEncrypt4(String encrypt4) {
		this.encrypt4 = encrypt4;
	}

	public String getEncrypt5() {
		return encrypt5;
	}

	public void setEncrypt5(String encrypt5) {
		this.encrypt5 = encrypt5;
	}

	public String getEncrypt6() {
		return encrypt6;
	}

	public void setEncrypt6(String encrypt6) {
		this.encrypt6 = encrypt6;
	}

	public String getEncrypt7() {
		return encrypt7;
	}

	public void setEncrypt7(String encrypt7) {
		this.encrypt7 = encrypt7;
	}

	public String getEncrypt8() {
		return encrypt8;
	}

	public void setEncrypt8(String encrypt8) {
		this.encrypt8 = encrypt8;
	}

	public String getEncrypt9() {
		return encrypt9;
	}

	public void setEncrypt9(String encrypt9) {
		this.encrypt9 = encrypt9;
	}

	public String getEncrypt10() {
		return encrypt10;
	}

	public void setEncrypt10(String encrypt10) {
		this.encrypt10 = encrypt10;
	}

	public int getStoreid() {
		return storeid;
	}

	public void setStoreid(int storeid) {
		this.storeid = storeid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((encrypt1 == null) ? 0 : encrypt1.hashCode());
		result = prime * result
				+ ((encrypt10 == null) ? 0 : encrypt10.hashCode());
		result = prime * result
				+ ((encrypt2 == null) ? 0 : encrypt2.hashCode());
		result = prime * result
				+ ((encrypt3 == null) ? 0 : encrypt3.hashCode());
		result = prime * result
				+ ((encrypt4 == null) ? 0 : encrypt4.hashCode());
		result = prime * result
				+ ((encrypt5 == null) ? 0 : encrypt5.hashCode());
		result = prime * result
				+ ((encrypt6 == null) ? 0 : encrypt6.hashCode());
		result = prime * result
				+ ((encrypt7 == null) ? 0 : encrypt7.hashCode());
		result = prime * result
				+ ((encrypt8 == null) ? 0 : encrypt8.hashCode());
		result = prime * result
				+ ((encrypt9 == null) ? 0 : encrypt9.hashCode());
		result = prime * result + storeid;
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
		Keychain other = (Keychain) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (encrypt1 == null) {
			if (other.encrypt1 != null)
				return false;
		} else if (!encrypt1.equals(other.encrypt1))
			return false;
		if (encrypt10 == null) {
			if (other.encrypt10 != null)
				return false;
		} else if (!encrypt10.equals(other.encrypt10))
			return false;
		if (encrypt2 == null) {
			if (other.encrypt2 != null)
				return false;
		} else if (!encrypt2.equals(other.encrypt2))
			return false;
		if (encrypt3 == null) {
			if (other.encrypt3 != null)
				return false;
		} else if (!encrypt3.equals(other.encrypt3))
			return false;
		if (encrypt4 == null) {
			if (other.encrypt4 != null)
				return false;
		} else if (!encrypt4.equals(other.encrypt4))
			return false;
		if (encrypt5 == null) {
			if (other.encrypt5 != null)
				return false;
		} else if (!encrypt5.equals(other.encrypt5))
			return false;
		if (encrypt6 == null) {
			if (other.encrypt6 != null)
				return false;
		} else if (!encrypt6.equals(other.encrypt6))
			return false;
		if (encrypt7 == null) {
			if (other.encrypt7 != null)
				return false;
		} else if (!encrypt7.equals(other.encrypt7))
			return false;
		if (encrypt8 == null) {
			if (other.encrypt8 != null)
				return false;
		} else if (!encrypt8.equals(other.encrypt8))
			return false;
		if (encrypt9 == null) {
			if (other.encrypt9 != null)
				return false;
		} else if (!encrypt9.equals(other.encrypt9))
			return false;
		if (storeid != other.storeid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Keychain [keychainid=" + keychainid + ", encrypt1=" + encrypt1
				+ ", encrypt2=" + encrypt2 + ", encrypt3=" + encrypt3
				+ ", encrypt4=" + encrypt4 + ", encrypt5=" + encrypt5
				+ ", encrypt6=" + encrypt6 + ", encrypt7=" + encrypt7
				+ ", encrypt8=" + encrypt8 + ", encrypt9=" + encrypt9
				+ ", encrypt10=" + encrypt10 + ", storeid=" + storeid
				+ ", email=" + email + "]";
	}
	
}
