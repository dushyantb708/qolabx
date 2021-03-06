package com.qolabx.dao;

import java.util.List;

import com.qolabx.beans.Company;
import com.qolabx.beans.Job;
import com.qolabx.beans.JobApplication;
import com.qolabx.beans.User;
import com.qolabx.exception.QolabxException;

public interface JobDao {

	String createJob(Job request) throws QolabxException;

	List<Job> getAllJobs() throws QolabxException;

	List<Job> getJobsForCompany(Company request) throws QolabxException;

	List<Job> getMyPostedJobs(User request) throws QolabxException;

	String deleteJob(Job request) throws QolabxException;

	String applyJob(JobApplication request) throws QolabxException;

	List<JobApplication> viewJobApplications(User request) throws QolabxException;

}
