package org.itstep.dao;

 import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.itstep.model.Account;

public class AccountDAO {

	public void save(Account account) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "INSERT INTO accounts(login, password, first_name, second_name ) VALUES(?,?,?,?)";

		try {
			connection = ConnectionToDB.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, account.getLogin());
			statement.setString(2, account.getPassword());
			statement.setString(3, account.getFirst_name());
			statement.setString(4, account.getSecond_name());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public Account get(String firstName, String secondName) {
		Account account = new Account();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM accounts WHERE first_name=? AND second_name=?";

		try {
			connection = ConnectionToDB.getConnection();
			statement = connection.prepareStatement(sql);

			statement.setString(1, firstName);
			statement.setString(2, secondName);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				account.setFirst_name(resultSet.getString("first_name"));
				account.setSecond_name(resultSet.getString("second_name"));
				account.setLogin(resultSet.getString("login"));
				account.setPassword(resultSet.getString("password"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return account;

	}

	public void update(String firstName, String secondName, Account newAccount) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "UPDATE accounts SET first_name=?, second_name=?, login=?, password=? WHERE first_name=? AND second_name=?";
		try {
			connection = ConnectionToDB.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, newAccount.getFirst_name());
			statement.setString(4, newAccount.getPassword());
			statement.setString(2, newAccount.getSecond_name());
			statement.setString(3, newAccount.getLogin());
			statement.setString(5, firstName);
			statement.setString(6, secondName);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(String firstName, String secondName) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "DELETE FROM accounts WHERE first_name=? AND second_name=?";
		try {
			connection = ConnectionToDB.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, firstName);
			statement.setString(2, secondName);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}