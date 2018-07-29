package com.qolabx.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.qolabx.beans.Company;
import com.qolabx.beans.Job;
import com.qolabx.beans.JobApplication;
import com.qolabx.beans.User;
import com.qolabx.constants.QolabxConstants;
import com.qolabx.dao.JobDao;
import com.qolabx.exception.QolabxException;
import com.qolabx.util.StaticDB;

@Repository
public class JobDaoImpl implements JobDao {

	@Override
	public String createJob(Job request) throws QolabxException {
		String msg = QolabxConstants.ERROR_STATUS;
		try {
			Long nextJobId = 0L;
			for (Job eachJob : StaticDB.availableJobs) {
				if (nextJobId > eachJob.getJobId())
					nextJobId = eachJob.getJobId();
			}
			request.setJobId(++nextJobId);
			StaticDB.availableJobs.add(request);
		} catch (Exception e) {
			throw new QolabxException(e);
		}
		return msg;
	}

	@Override
	public List<Job> getAllJobs() throws QolabxException {
		List<Job> jobs = null;
		try {
			jobs = StaticDB.availableJobs;
		} catch (Exception e) {
			throw new QolabxException(e);
		}
		return jobs;
	}

	@Override
	public List<Job> getJobsForCompany(Company request) throws QolabxException {
		List<Job> jobs = new ArrayList<>();
		try {
			for (Job eachJob : StaticDB.availableJobs) {
				if (request.getCompanyId() != null && eachJob.getCompany().getCompanyId().equals(request.getCompanyId())){
					jobs.add(eachJob);
				}
			}
		} catch (Exception e) {
			throw new QolabxException(e);
		}
		return jobs;
	}

	@Override
	public List<Job> getMyPostedJobs(User request) throws QolabxException {
		List<Job> jobs = new ArrayList<>();
		try {
			for (Job eachJob : StaticDB.availableJobs) {
				if (request.getUserId() != null && eachJob.getRecruiter().getUserId().equals(request.getUserId())){
					jobs.add(eachJob);
				}
			}
		} catch (Exception e) {
			throw new QolabxException(e);
		}
		return jobs;
	}

	@Override
	public String deleteJob(Job request) throws QolabxException {
		String msg = QolabxConstants.ERROR_STATUS;
		try {
			for (Job eachJob : StaticDB.availableJobs) {
				if (request.getJobId() != null && eachJob.getJobId().equals(request.getJobId())){
					StaticDB.availableJobs.remove(eachJob);
					msg = QolabxConstants.SUCCESS_STATUS;
					break;
				}
			}
		} catch (Exception e) {
			throw new QolabxException(e);
		}
		return msg;
	}

	@Override
	public String applyJob(JobApplication request) throws QolabxException {
		String msg = QolabxConstants.ERROR_STATUS;
		try {
			StaticDB.jobApplications.add(request);
			msg = QolabxConstants.SUCCESS_STATUS;
		} catch (Exception e) {
			throw new QolabxException(e);
		}
		return msg;
	}

	@Override
	public List<JobApplication> viewJobApplications(User request) throws QolabxException {
		List<JobApplication> myJobApplications = new ArrayList<>();
		try {
			for (JobApplication eachJobApplication : StaticDB.jobApplications) {
				if (request.getUserId()!=null && eachJobApplication.getJobApplicant().getUserId().equals(request.getUserId())){
					myJobApplications.add(eachJobApplication);
				}
			}
		} catch (Exception e) {
			throw new QolabxException(e);
		}
		return myJobApplications;
	}
}
