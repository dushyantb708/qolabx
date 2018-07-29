package com.qolabx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qolabx.beans.BaseResponse;
import com.qolabx.beans.Job;
import com.qolabx.beans.JobApplication;
import com.qolabx.beans.User;
import com.qolabx.constants.QolabxConstants;
import com.qolabx.exception.QolabxException;
import com.qolabx.service.JobService;

@RestController
@RequestMapping("/jobSeeker")
public class JobSeekerController {
	
	@Autowired
	JobService jobService;
	
	/**
	 * @author Dushyant
	 * @param key 
	 * @param job application
	 * @return 
	 * This Handler Method takes the job application as input for a user as job seeker
	 */
	@RequestMapping(value = "/applyJob", method = RequestMethod.POST)
	public BaseResponse applyJob(@RequestParam String key, @RequestBody JobApplication request){
		BaseResponse response = new BaseResponse();
		try {
			if (QolabxConstants.sharedKey.equalsIgnoreCase(key)) {
				   String msg = jobService.applyJob(request);
				   if (QolabxConstants.SUCCESS_STATUS.equals(msg)){
					   response.setStatus(QolabxConstants.SUCCESS_STATUS);
					   response.setCode(QolabxConstants.CODE_SUCCESS);
				   } else {
					   throw new QolabxException();
				   }
			 } else {
				   response.setStatus(QolabxConstants.ERROR_STATUS);
				   response.setCode(QolabxConstants.AUTH_FAILURE);
		     }
		} catch (Exception e) {
			//Error Can be Logged here
			response.setStatus(QolabxConstants.ERROR_STATUS);
			response.setCode(QolabxConstants.CODE_INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	/**
	 * @author Dushyant
	 * @param key 
	 * @param User
	 * @return 
	 * This Handler Method takes return all the job application for a user with role job seeker
	 */
	@RequestMapping(value = "/viewJobApplications", method = RequestMethod.POST)
	public BaseResponse viewJobApplications(@RequestParam String key, @RequestBody User request){
		BaseResponse response = new BaseResponse();
		try {
			if (QolabxConstants.sharedKey.equalsIgnoreCase(key)) {
				   List<JobApplication> jobApplications = jobService.viewJobApplication(request);
				   if (!CollectionUtils.isEmpty(jobApplications)){
					   response.setStatus(QolabxConstants.SUCCESS_STATUS);
					   response.setCode(QolabxConstants.CODE_SUCCESS);
					   response.setResponse(jobApplications);
				   } else {
					   throw new QolabxException();
				   }
			 } else {
				   response.setStatus(QolabxConstants.ERROR_STATUS);
				   response.setCode(QolabxConstants.AUTH_FAILURE);
		     }
		} catch (Exception e) {
			//Error Can be Logged here
			response.setStatus(QolabxConstants.ERROR_STATUS);
			response.setCode(QolabxConstants.CODE_INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	/**
	 * @author Dushyant
	 * @param key 
	 * @return 
	 * This Handler Method returns all the available jobs
	 */
	@RequestMapping(value = "/getAllJobs", method = RequestMethod.GET)
	public BaseResponse getAllJobs(@RequestParam String key){
		BaseResponse response = new BaseResponse();
		try {
			if (QolabxConstants.sharedKey.equalsIgnoreCase(key)) {
				   List<Job> jobs = jobService.getAllJobs();
				   if (!CollectionUtils.isEmpty(jobs)){
					   response.setStatus(QolabxConstants.SUCCESS_STATUS);
					   response.setCode(QolabxConstants.CODE_SUCCESS);
					   response.setResponse(jobs);
				   } else {
					   throw new QolabxException();
				   }
			 } else {
				   response.setStatus(QolabxConstants.ERROR_STATUS);
				   response.setCode(QolabxConstants.AUTH_FAILURE);
		     }
		} catch (Exception e) {
			//Error Can be Logged here
			response.setStatus(QolabxConstants.ERROR_STATUS);
			response.setCode(QolabxConstants.CODE_INTERNAL_SERVER_ERROR);
		}
		return response;
	}
}
