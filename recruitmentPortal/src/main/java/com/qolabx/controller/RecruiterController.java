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
import com.qolabx.beans.Company;
import com.qolabx.beans.Job;
import com.qolabx.beans.User;
import com.qolabx.constants.QolabxConstants;
import com.qolabx.exception.QolabxException;
import com.qolabx.service.JobService;

@RestController
@RequestMapping("/recruiter")
public class RecruiterController {

	@Autowired
	JobService jobService;
	
	/**
	 * @author Dushyant
	 * @param key 
	 * @param job
	 * @return 
	 * This Handler Method takes the job as paramter and add it to the available jobs data for the job seeker to search from 
	 */
	@RequestMapping(value = "/postJob", method = RequestMethod.POST)
	public BaseResponse postJob(@RequestParam String key, @RequestBody Job request){
		BaseResponse response = new BaseResponse();
		try {
			if (QolabxConstants.sharedKey.equalsIgnoreCase(key)) {
				   String msg = jobService.createJob(request);
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
	 * This Handler Method returns all the jobs posted by an recruiter
	 */
	@RequestMapping(value = "/getMyPostedJobs", method = RequestMethod.POST)
	public BaseResponse getMyPostedJobs(@RequestParam String key, @RequestBody User request){
		BaseResponse response = new BaseResponse();
		try {
			if (QolabxConstants.sharedKey.equalsIgnoreCase(key)) {
				   List<Job> jobs = jobService.getMyPostedJobs(request);
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
	
	/**
	 * @author Dushyant
	 * @param key 
	 * @param Company
	 * @return 
	 * This Handler Method return all the jobs posted for a particular company
	 */
	@RequestMapping(value = "/getJobsForCompany", method = RequestMethod.POST)
	public BaseResponse getJobsForCompany(@RequestParam String key, @RequestBody Company request){
		BaseResponse response = new BaseResponse();
		try {
			if (QolabxConstants.sharedKey.equalsIgnoreCase(key)) {
				   List<Job> jobs = jobService.getJobsForCompany(request);
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
	
	/**
	 * @author Dushyant
	 * @param key 
	 * @param job
	 * @return 
	 * This Handler Method delete a posted job
	 */
	@RequestMapping(value = "/deleteJob", method = RequestMethod.POST)
	public BaseResponse deleteJob(@RequestParam String key, @RequestBody Job request){
		BaseResponse response = new BaseResponse();
		try {
			if (QolabxConstants.sharedKey.equalsIgnoreCase(key)) {
				   String msg = jobService.deleteJob(request);
				   if (msg.equals(QolabxConstants.CODE_SUCCESS)){
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
}
