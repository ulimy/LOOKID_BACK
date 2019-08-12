package com.java.vo;

import java.util.Date;

//blacklist
public class BlacklistVO {

	private Integer pid;
	private String logoutId;
	private String logoutToken;
	private Date logoutTime;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getLogoutId() {
		return logoutId;
	}

	public void setLogoutId(String logoutId) {
		this.logoutId = logoutId;
	}

	public String getLogoutToken() {
		return logoutToken;
	}

	public void setLogoutToken(String logoutToken) {
		this.logoutToken = logoutToken;
	}

	public Date getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}

}
