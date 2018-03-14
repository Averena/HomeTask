package org.itstep.model;

public class GoodAction {

	private Integer id;
	private String asin;
	private String login;
	private String action;
	private Integer actionTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAsin() {
		return asin;
	}

	public void setAsin(String asin) {
		this.asin = asin;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Integer getActionTime() {
		return actionTime;
	}

	public void setActionTime(Integer actionTime) {
		this.actionTime = actionTime;
	}

	public GoodAction() {

	}

	public GoodAction(Integer id, String asin, String login, String action, Integer actionTime) {
		super();
		this.id = id;
		this.asin = asin;
		this.login = login;
		this.action = action;
		this.actionTime = actionTime;
	}

}
