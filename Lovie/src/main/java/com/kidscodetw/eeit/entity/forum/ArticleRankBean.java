package com.kidscodetw.eeit.entity.forum;

import java.io.Serializable;






import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;



@Entity
@IdClass(ArticleRankBean.class)
public class ArticleRankBean implements Serializable{

	@Id
	private int articleID;
	@Id
	private String memberAccount;
	
	private int good;
	private int bad;
	private int report;
	private String reportReason;

	@Override
	public String toString() {
		return "ArticleRankBean [articleID=" + articleID
				+ ", memberAccount=" + memberAccount + ", good=" + good
				+ ", bad=" + bad + ", report=" + report + ", reportReason="
				+ reportReason + "]";
	}

	

	public int getArticleID() {
		return articleID;
	}

	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}

	public String getMemberAccount() {
		return memberAccount;
	}

	public void setMemberAccount(String memberAccount) {
		this.memberAccount = memberAccount;
	}

	public int getGood() {
		return good;
	}

	public void setGood(int good) {
		this.good = good;
	}

	public int getBad() {
		return bad;
	}

	public void setBad(int bad) {
		this.bad = bad;
	}

	public int getReport() {
		return report;
	}

	public void setReport(int report) {
		this.report = report;
	}

	public String getReportReason() {
		return reportReason;
	}

	public void setReportReason(String reportReason) {
		this.reportReason = reportReason;
	}

}
