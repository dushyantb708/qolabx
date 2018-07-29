package com.qolabx.beans;

import java.util.Date;

import com.qolabx.constants.JobApplicationStatus;

public class JobApplication {

	private Long jobApplicationId;
	private User jobApplicant;
	private Job job;
	private Date appliedOn;
	private Date reviewedOn;
	private JobApplicationStatus status;

	public JobApplication() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JobApplication(Long jobApplicationId, User jobApplicant, Job job, Date appliedOn, Date reviewedOn,
			JobApplicationStatus status) {
		super();
		this.jobApplicationId = jobApplicationId;
		this.jobApplicant = jobApplicant;
		this.job = job;
		this.appliedOn = appliedOn;
		this.reviewedOn = reviewedOn;
		this.status = status;
	}

	public Long getJobApplicationId() {
		return jobApplicationId;
	}

	public void setJobApplicationId(Long jobApplicationId) {
		this.jobApplicationId = jobApplicationId;
	}

	public User getJobApplicant() {
		return jobApplicant;
	}

	public void setJobApplicant(User jobApplicant) {
		this.jobApplicant = jobApplicant;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Date getAppliedOn() {
		return appliedOn;
	}

	public void setAppliedOn(Date appliedOn) {
		this.appliedOn = appliedOn;
	}

	public Date getReviewedOn() {
		return reviewedOn;
	}

	public void setReviewedOn(Date reviewedOn) {
		this.reviewedOn = reviewedOn;
	}

	public JobApplicationStatus getStatus() {
		return status;
	}

	public void setStatus(JobApplicationStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "JobApplication [jobApplicationId=" + jobApplicationId + ", jobApplicant=" + jobApplicant + ", job="
				+ job + ", appliedOn=" + appliedOn + ", reviewedOn=" + reviewedOn + ", status=" + status + "]";
	}

}
