package com.kidscodetw.eeit.entity.member;

import java.io.Serializable;

public class FriendBean implements Serializable{
private Integer memberId;
private Integer friendId;
private Integer relation;


@Override
public String toString() {
	return "RelationshipBean [memberId=" + memberId + ", friendId=" + friendId
			+ ", relation=" + relation + "]";
}
public Integer getMemberId() {
	return memberId;
}
public void setMemberId(Integer memberId) {
	this.memberId = memberId;
}
public Integer getFriendId() {
	return friendId;
}
public void setFriendId(Integer friendId) {
	this.friendId = friendId;
}
public Integer getRelation() {
	return relation;
}
public void setRelation(Integer relation) {
	this.relation = relation;
}

}
