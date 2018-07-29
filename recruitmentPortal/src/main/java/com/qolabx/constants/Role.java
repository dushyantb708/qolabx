package com.qolabx.constants;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Role {
	
	SYSTEM_ADMIN(1L,"Admin"),
	RECRUITER(2L,"Recruiter"),
	JOB_SEEKER(3L,"Job Seeker");
	
	private Long roleId;
	private String roleName;
	private static Map<Long, Role> map;
	
	static{
		map = Arrays.asList(Role.values()).stream().collect(Collectors.toMap(Role::getRoleId, k->k));
	}

	private Role(Long roleId, String roleName) {
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public static Map<Long, Role> getMap() {
		return map;
	}
}
