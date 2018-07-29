package com.qolabx.beans;

import java.util.Date;

public class Job {
	
	private Long jobId;
	private String jobTitle;
	private Company company;
	private String jobDescription;
	private Long openings;
	private User recruiter;
	private Date postedOn;
	private Date expiryOn;
	
	public Job() {
		super();
	}
	
	public Job(Long jobId, String jobTitle, Company company, String jobDescription, Long openings, User recruiter) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.company = company;
		this.jobDescription = jobDescription;
		this.openings = openings;
		this.recruiter = recruiter;
	}
	public Long getJobId() {
		return jobId;
	}
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public Long getOpenings() {
		return openings;
	}
	public void setOpenings(Long openings) {
		this.openings = openings;
	}
	public User getRecruiter() {
		return recruiter;
	}
	public void setRecruiter(User recruiter) {
		this.recruiter = recruiter;
	}

	public Date getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}

	public Date getExpiryOn() {
		return expiryOn;
	}

	public void setExpiryOn(Date expiryOn) {
		this.expiryOn = expiryOn;
	}

	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", jobTitle=" + jobTitle + ", company=" + company + ", jobDescription="
				+ jobDescription + ", openings=" + openings + ", recruiter=" + recruiter + ", postedOn=" + postedOn
				+ ", expiryOn=" + expiryOn + "]";
	}
}
