package com.ty.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PersonId implements Serializable {

	private String email;

	private Long phone;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;

//		int hashcode = 0;
//		hashcode = (int) (phone + email.hashCode());
//		return hashcode;
	}

	@Override
	public boolean equals(Object obj) {

//		PersonId o = (PersonId) obj;
//		return this.email.equals(o.email) && this.phone.equals(o.phone);

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonId other = (PersonId) obj;
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
		return true;
	}
}
