# first_login_page
The first login page is created to check whether the entered credential is matching with the database or not.
* The login page is created by using GenericServlet.
* We are overriding the service method in the class.
* We are getting the user name and password from the web page.
* We are getting the credentials from the browser by using by using the method "getParameter()" with the help of ServletRequest reference (req).
* Using JDBC we are connecting to MySQL database.
* By using executeQuery() we are passing the query and it will returns a type of ResultSet
* Storing the password in string type by using getString().
* Comparing the both password by using if condition.
* If it is equal then we use RequestDispatcher rd = req.getRequestDispatcher("afterLogin.html") and usind this reference we are forwarding to next page.
* else we are using PrintWriter class to store the reference of getWriter() with the reference of ServletResponse(res) and showing the "Enter valid credentials" message.
* And we are using include() to include the message and the same login page details.
* Using ServletResponse reference we are setting the content type as res.setContentType("text/html").
