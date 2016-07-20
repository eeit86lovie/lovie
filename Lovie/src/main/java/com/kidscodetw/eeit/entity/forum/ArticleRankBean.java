package com.kidscodetw.eeit.entity.forum;

public class ArticleRankBean {

	private int id;
	private int articleID;
	private String memberAccount;
	private int good;
	private int bad;
	private int report;
	private String reportReason;

	@Override
	public String toString() {
		return "ArticleRankBean [id=" + id + ", articleID=" + articleID
				+ ", memberAccount=" + memberAccount + ", good=" + good
				+ ", bad=" + bad + ", report=" + report + ", reportReason="
				+ reportReason + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
