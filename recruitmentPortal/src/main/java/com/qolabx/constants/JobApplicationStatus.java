package com.qolabx.constants;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum JobApplicationStatus {

	PENDING(1L, "Pending"), SELECTED(2L, "Selected"), REJECTED(3L, "Rejected");

	private Long jobApplicationStatusId;
	private String jobApplicationStatusName;
	private static Map<Long, JobApplicationStatus> map;
	
	static{
		map = Arrays.asList(JobApplicationStatus.values()).stream().collect(Collectors.toMap(JobApplicationStatus::getJobApplicationStatusId, k->k));
	}

	public Long getJobApplicationStatusId() {
		return jobApplicationStatusId;
	}

	public void setJobApplicationStatusId(Long jobApplicationStatusId) {
		this.jobApplicationStatusId = jobApplicationStatusId;
	}

	public String getJobApplicationStatusName() {
		return jobApplicationStatusName;
	}

	public void setJobApplicationStatusName(String jobApplicationStatusName) {
		this.jobApplicationStatusName = jobApplicationStatusName;
	}

	public static Map<Long, JobApplicationStatus> getMap() {
		return map;
	}

	private JobApplicationStatus(Long jobApplicationStatusId, String jobApplicationStatusName) {
		this.jobApplicationStatusId = jobApplicationStatusId;
		this.jobApplicationStatusName = jobApplicationStatusName;
	}

}
