

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
				  
				response.setContentType("text/html");  
				PrintWriter out = response.getWriter();  
				          
				String n=request.getParameter("Name");  
				String m=request.getParameter("Mobileno");  
				String e=request.getParameter("Email"); 
				String u=request.getParameter("Company");  
				String c=request.getParameter("Country");  
				          
				try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/placement","root","root");  
				  
				PreparedStatement ps=con.prepareStatement(  
				"insert into company values(?,?,?,?,?)");  
				  
				ps.setString(1,n);  
				ps.setString(2,m);  
				ps.setString(3,e);  
				ps.setString(4,u); 
				ps.setString(5,c);  

				          
				int i=ps.executeUpdate();  
				if(i>0)  
				out.print("You are successfully registered...");  
				      
				          
				}catch (Exception e2) {System.out.println(e2);}  
				          
				out.close();  
	}

}
