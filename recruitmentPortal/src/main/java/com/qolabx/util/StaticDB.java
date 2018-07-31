package com.qolabx.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.qolabx.beans.Company;
import com.qolabx.beans.Job;
import com.qolabx.beans.JobApplication;
import com.qolabx.beans.User;
import com.qolabx.constants.JobApplicationStatus;
import com.qolabx.constants.Role;

public class StaticDB {
	
	public static List<User> users = new ArrayList<>();
	public static List<Company> companies = new ArrayList<>();
	public static List<Job> availableJobs = new ArrayList<>();
	public static List<JobApplication> jobApplications = new ArrayList<>();
	
	static {
		//Users
		//First User
		User user1 = new User();
		user1.setUserId(1L);
		user1.setEmail("dushyant@mail.com");
		user1.setUserName("Dushyant");
		user1.setFirstName("Dushyant");
		user1.setLastName("Bhati");
		user1.setRole(Role.RECRUITER);
		users.add(user1);
		
		//Second User
		User user2 = new User();
		user2.setUserId(2L);
		user2.setEmail("gaurav@mail.com");
		user2.setUserName("Gaurav");
		user2.setFirstName("Gaurav");
		user2.setLastName("Singhal");
		user2.setRole(Role.RECRUITER);
		users.add(user2);
		
		//Third User
		User user3 = new User();
		user3.setUserId(3L);
		user3.setEmail("rahul@mail.com");
		user3.setUserName("rahul");
		user3.setFirstName("Rahul");
		user3.setLastName("Parwal");
		user3.setRole(Role.JOB_SEEKER);
		users.add(user3);
		
		//Companies
		//First Company
		Company company1 = new Company();
		company1.setCompanyId(1L);
		company1.setCompanyName("Qolabx Technologies");
		company1.setAboutUs("QolabX is a collaborative talent acquisition & management platform focused to tackle the most challenging aspects of Talent Acquisition and Recruitment. We believe technological innovation is at the core of future of the recruitment Industry");
		company1.setCountry("India");
		company1.setState("Maharastra");
		company1.setCity("Pune");
		company1.setAddress("Pune");
		companies.add(company1);
		
		//Second Company
		Company company2 = new Company();
		company2.setCompanyId(2L);
		company2.setCompanyName("Amdigit");
		company2.setAboutUs("Amdigit is a collaborative talent acquisition & management platform focused to tackle the most challenging aspects of Talent Acquisition and Recruitment. We believe technological innovation is at the core of future of the recruitment Industry");
		company2.setCountry("India");
		company2.setState("Maharastra");
		company2.setCity("Mumbai");
		company2.setAddress("Mumbai");
		companies.add(company2);
		
		//Jobs
		//First Job
		Job job1 = new Job();
		job1.setJobId(1L);
		job1.setJobTitle("Backend Developer");
		job1.setJobDescription("Backend Developer with 2-3 year experience");
		job1.setOpenings(5L);
		job1.setCompany(company1);
		job1.setPostedOn(new Date(118, 8, 26));
		job1.setExpiryOn(new Date(118, 9, 30));
		job1.setRecruiter(user1);
		availableJobs.add(job1);
		
		//First Job
		Job job2 = new Job();
		job2.setJobId(2L);
		job2.setJobTitle("Frontend Developer");
		job2.setJobDescription("Frontend Developer with 3 year experience");
		job2.setOpenings(2L);
		job2.setCompany(company2);
		job2.setPostedOn(new Date(118, 8, 26));
		job2.setExpiryOn(new Date(118, 9, 30));
		job2.setRecruiter(user3);
		availableJobs.add(job2);
		
		//Job Application
		JobApplication application = new JobApplication();
		application.setJobApplicant(user3);
		application.setJob(job1);
		application.setAppliedOn(new Date());
		application.setJobApplicationId(1l);
		application.setStatus(JobApplicationStatus.PENDING);
		jobApplications.add(application);
	}
	
	
}
