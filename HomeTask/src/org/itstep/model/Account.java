package org.itstep.model;

public class Account {

	private String login;
	private String password;
	private String first_name;
	private String second_name;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getSecond_name() {
		return second_name;
	}

	public void setSecond_name(String second_name) {
		this.second_name = second_name;
	}

	public Account(String login, String password, String first_name, String second_name) {
		super();
		this.login = login;
		this.password = password;
		this.first_name = first_name;
		this.second_name = second_name;
	}

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(String firstName, String secondName) {
		// TODO Auto-generated constructor stub
	}

	
}
