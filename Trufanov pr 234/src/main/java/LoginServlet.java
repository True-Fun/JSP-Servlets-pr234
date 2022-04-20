//import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connectionDB.sqliteConnection;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String login = request.getParameter("Login");
        String password = request.getParameter("Password");
        
        
        sqliteConnection connect =new sqliteConnection();  
        String query = "SELECT * FROM UserData WHERE LoginDB = ?";
        PreparedStatement statement;
		ResultSet rs = null;
		try {
			
			statement = connect.dbConnector().prepareStatement(query);
			statement.setString(1, login);			
			rs = statement.executeQuery();
			//System.out.println(rs.isClosed());
			if(!rs.isClosed()) {
			while (rs.next()) {				
				
				String paswords = rs.getString("PasswordDB");
				String name = rs.getString("NameDB");
				String email = rs.getString("EmailDB");
				
				if(paswords.equals(password) ) 
				{
					SetCookie(response, name,email);
					SetSession(request, login, password);
					GetCookie(request, response);
				}
				else 
				{
					pw.println("PASSWORD ERROR");
				}
			}
		
		
	}	
			else {pw.println("LOGIN ERROR");}
	} 
		catch (SQLException e) 
		{
			System.out.println("ERROR!");
			e.printStackTrace();
		}		
	
	}

	private void SetCookie(HttpServletResponse response, String name, String email) {
		Cookie cookieName = new Cookie("NameDB", name); 
		Cookie cookieEmail = new Cookie("EmailDB", email);	
		
		cookieName.setMaxAge(30 * 24 * 60 * 60); // days*hours*minutes*seconds
		cookieEmail.setMaxAge(30 * 24 * 60 * 60);	
		
		response.addCookie(cookieName);
		response.addCookie(cookieEmail);
		
		
	}

	private void GetCookie(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");           
        response.setCharacterEncoding("utf-8"); 
		
		PrintWriter pw = response.getWriter();
		Cookie [] cookies = request.getCookies();
		
		pw.println("<h1>");
		pw.println("cookies, ");
		for (Cookie cookie : cookies) {			
				pw.println(cookie.getValue()+ " " + cookie.getName() + "<br>") ;					
		}
		pw.println("</h1>");
		
	}

	private void SetSession(HttpServletRequest request, String login, String password) {
		HttpSession session = request.getSession();
		session.setAttribute("LoginDB", login);
		session.setAttribute("PasswordDB", password);
		
	}
        
}
