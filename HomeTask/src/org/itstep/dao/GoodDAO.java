package org.itstep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.itstep.dao.ConnectionToDB;
import org.itstep.model.Good;

public class GoodDAO {
	public void save(Good good) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "INSERT INTO goods (asin, name, price, initial_price, img_url, url ) VALUES(?,?,?,?)";

		try {
			connection = ConnectionToDB.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, good.getAsin());
			statement.setString(2, good.getName());
			statement.setInt(3, good.getPrice());
			statement.setInt(3, good.getInitialPrice());
			statement.setString(4, good.getImgUrl());
			statement.setString(4, good.getGoodUrl());
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

	public Good get(String asin) {

		Good good = new Good();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM goods WHERE asin=?";

		try {
			connection = ConnectionToDB.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, asin);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				good.setAsin(resultSet.getString("asin"));
				good.setName(resultSet.getString("name"));
				good.setPrice(resultSet.getInt("price"));
				good.setInitialPrice(resultSet.getInt("initial_price"));
				good.setImgUrl(resultSet.getString("imgUrl"));
				good.setGoodUrl(resultSet.getString("url"));
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
		return good;
	}

	public void update(String asin, Good newGood) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "UPDATE good SET asin=?, name=?, price=?, initial_price=?, img_url=?, url=? WHERE asin=?";

		try {
			connection = ConnectionToDB.getConnection();
			statement = connection.prepareStatement(sql);

			statement.setString(1, newGood.getAsin());
			statement.setString(2, newGood.getName());
			statement.setInt(3, newGood.getPrice());
			statement.setInt(4, newGood.getInitialPrice());
			statement.setString(5, newGood.getImgUrl());
			statement.setString(6, newGood.getGoodUrl());
			statement.setString(6, asin);
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

	public void delete(String asin) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "DELETE FROM goods WHERE asin=?";

		try {
			connection = ConnectionToDB.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, asin);
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