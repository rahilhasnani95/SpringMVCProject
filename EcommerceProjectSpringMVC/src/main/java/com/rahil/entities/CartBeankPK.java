package com.rahil.entities;

import java.io.Serializable;

public class CartBeankPK implements Serializable {

	private String username;
	private int itemid;
	
	public CartBeankPK()
	{
		
	}
	
	public CartBeankPK(String username, int itemid) {
		super();
		this.username = username;
		this.itemid = itemid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + itemid;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		CartBeankPK other = (CartBeankPK) obj;
		if (itemid != other.itemid)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
}
