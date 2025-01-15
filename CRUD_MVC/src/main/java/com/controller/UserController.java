package com.controller;

import java.io.IOException;

import com.dao.UserDao;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/reg")
public class UserController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String email = req.getParameter("email");

		User u = new User();
		u.setName(name);
		u.setEmail(email);

		UserDao dao = new UserDao();

		int i = 0;

		if (id.equals("")) {
			i = dao.addUser(u);
			if (i > 0) {
				req.getRequestDispatcher("index.jsp").forward(req, resp);

			}
		} else {
			u.setId(Integer.parseInt(id));
			i = dao.updateUser(u);

			if (i > 0) {
				req.getRequestDispatcher("index.jsp").forward(req, resp);

			}

		}

	}
}
