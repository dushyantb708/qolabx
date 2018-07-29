package com.qolabx.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qolabx.beans.Company;
import com.qolabx.beans.Job;
import com.qolabx.beans.JobApplication;
import com.qolabx.beans.User;
import com.qolabx.constants.QolabxConstants;
import com.qolabx.dao.JobDao;
import com.qolabx.exception.QolabxException;
import com.qolabx.service.JobService;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	JobDao jobDao;

	@Override
	public String createJob(Job request) throws QolabxException {
		String msg = QolabxConstants.ERROR_STATUS;
		try {
			msg = jobDao.createJob(request);
		} catch (Exception e) {
			throw new QolabxException(e);
		}
		return msg;
	}

	@Override
	public List<Job> getAllJobs() throws QolabxException {
		List<Job> jobs = null;
		try {
			jobs = jobDao.getAllJobs();
		} catch (Exception e) {
			throw new QolabxException(e);
		}
		return jobs;
	}

	@Override
	public List<Job> getJobsForCompany(Company request) throws QolabxException {
		List<Job> jobs = null;
		try {
			jobs = jobDao.getJobsForCompany(request);
		} catch (Exception e) {
			throw new QolabxException(e);
		}
		return jobs;
	}

	@Override
	public List<Job> getMyPostedJobs(User request) throws QolabxException {
		List<Job> jobs = null;
		try {
			jobs = jobDao.getMyPostedJobs(request);
		} catch (Exception e) {
			throw new QolabxException(e);
		}
		return jobs;
	}

	@Override
	public String deleteJob(Job request) throws QolabxException {
		String msg = QolabxConstants.ERROR_STATUS;
		try {
			msg = jobDao.deleteJob(request);
		} catch (Exception e) {
			throw new QolabxException(e);
		}
		return msg;
	}

	@Override
	public String applyJob(JobApplication request) throws QolabxException {
		return jobDao.applyJob(request);
	}

	@Override
	public List<JobApplication> viewJobApplication(User request) throws QolabxException {
		List<JobApplication> jobApplications = null;
		try {
			jobApplications = jobDao.viewJobApplications(request);
		} catch (Exception e) {
			throw new QolabxException(e);
		}
		return jobApplications;
	}
}
