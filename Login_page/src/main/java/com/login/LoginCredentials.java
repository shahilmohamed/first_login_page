package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/login")
public class LoginCredentials extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String user = req.getParameter("user");
		String password = req.getParameter("password");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");
			Statement st = con.createStatement();
			try {
				ResultSet rs = st.executeQuery("select password from studentlogin where user = '" + user + "'");
				rs.next();
				String p = rs.getString(1);
				if (password.equals(p)) {
					RequestDispatcher rd = req.getRequestDispatcher("afterLogin.html");
					rd.forward(req, res);
				} else {
					PrintWriter pout = res.getWriter();
					pout.println("Enter valid credentials");
					RequestDispatcher rd = req.getRequestDispatcher("login.html");
					rd.include(req, res);
					res.setContentType("text/html");
				}
			} catch (SQLException e) {
				PrintWriter pout = res.getWriter();
				pout.println("Enter valid credentials");
				RequestDispatcher rd = req.getRequestDispatcher("login.html");
				rd.include(req, res);
				res.setContentType("text/html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
