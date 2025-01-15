package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.User;

public class UserDao {

	Connection cn = null;

	public UserDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root", "");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int addUser(User u) {
		int i = 0;

		try {
			PreparedStatement ps = cn.prepareStatement("insert into simple_crud values(?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, u.getName());
			ps.setString(3, u.getEmail());

			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}

	public List<User> viewAllUser() {

		List<User> user = new ArrayList();

		try {
			PreparedStatement ps = cn.prepareStatement("select * from simple_crud");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				user.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

	public User getUSerById(int id) {

		User u = new User();

		try {
			PreparedStatement ps = cn.prepareStatement("select * from simple_crud where id=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return u;
	}

	public int updateUser(User u) {
		int i = 0;

		try {
			PreparedStatement ps = cn.prepareStatement("update simple_crud set uname=?,email=? where id =?");
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setInt(3, u.getId());

			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public int deleteUser(int id) {
		int i = 0;

		try {
			PreparedStatement ps = cn.prepareStatement("delete from simple_crud where id=?");
			ps.setInt(1, id);

			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}

}
