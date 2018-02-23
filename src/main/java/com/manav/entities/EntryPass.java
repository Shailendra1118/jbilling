package com.manav.entities;

public class EntryPass {

	private String uname;
	private String pwd;
	/**
	 * @return the uname
	 */
	public String getUname() {
		return uname;
	}
	/**
	 * @param uname the uname to set
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}
	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "EntryPass{" +
				"uname='" + uname + '\'' +
				", pwd='" + pwd + '\'' +
				'}';
	}
}
