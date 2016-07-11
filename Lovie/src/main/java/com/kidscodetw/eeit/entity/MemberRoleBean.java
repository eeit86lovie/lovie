package com.kidscodetw.eeit.entity;

public class MemberRoleBean {
	
	private Integer privilege;
	private String role;
	
	public Integer getPrivilege() {
		return privilege;
	}
	public void setPrivilege(Integer privilege) {
		this.privilege = privilege;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String toString(){
		return "model.MemberRoleBean["+
				"Privilege: " +privilege+ ", Role: "+ role+"]";
	}

}
