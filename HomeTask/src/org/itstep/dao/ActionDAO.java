package org.itstep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.itstep.model.Account;
import org.itstep.model.GoodAction;

public class ActionDAO {

	public void save(GoodAction good_action) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "INSERT INTO account(id,asin, login, action, actionTime ) VALUES(?,?,?,?)";

		try {
			connection = ConnectionToDB.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setLong(1, good_action.getId());
			statement.setString(2, good_action.getAsin());
			statement.setString(3, good_action.getLogin());
			statement.setString(4, good_action.getAction());
			statement.setLong(4, good_action.getActionTime());

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

	public GoodAction get(String login) {

		GoodAction goodAction = new GoodAction();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM good_action WHERE login=?";

		try {
			connection = ConnectionToDB.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, login);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				goodAction.setId(resultSet.getInt("id"));
				goodAction.setAsin(resultSet.getString("asin"));
				goodAction.setLogin(resultSet.getString("login"));
				goodAction.setAction(resultSet.getString("action"));
				goodAction.setActionTime(resultSet.getInt("actionTime"));
				
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
		return goodAction;
	}

	public void update(String login, GoodAction overwriteGoodsAction) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "UPDATE good_action SET id=?, asin=?, login=?, action=?, action_time=? WHERE login=?";

		try {
			connection = ConnectionToDB.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, overwriteGoodsAction.getId());
			statement.setString(2, overwriteGoodsAction.getAsin());
			statement.setString(3, overwriteGoodsAction.getLogin());
			statement.setString(4, overwriteGoodsAction.getAction());
			statement.setInt(5, overwriteGoodsAction.getActionTime());
			statement.setString(6, login);
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

	public void delete(String login) {
    	Connection connection = null;
 		PreparedStatement statement = null;
		String sql = "DELETE FROM good_action WHERE login=?";		
		
		try {
			connection = ConnectionToDB.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, login);			
			statement.executeUpdate();
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		finally {
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
