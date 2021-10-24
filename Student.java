

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


@WebServlet("/Student")
public class Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          
		String n=request.getParameter("Name");  
		String e=request.getParameter("Email");  
		String m=request.getParameter("Mobileno");  
		String g=request.getParameter("Gender"); 
		String s=request.getParameter("State"); 
		String c=request.getParameter("City");  
		String p=request.getParameter("Pincode");  
		String j=request.getParameter("Job");  
		String u=request.getParameter("Course");  

		          
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/placement","root","root");  
		  
		PreparedStatement ps=con.prepareStatement(  
		"insert into course values(?,?,?,?,?,?,?,?,?)");  
		  
		ps.setString(1,n);  
		ps.setString(2,e);  
		ps.setString(3,m);  
		ps.setString(4,g); 
		ps.setString(5,s);  
		ps.setString(6,c);  
		ps.setString(7,p);  
		ps.setString(8,j);
		ps.setString(9,u);  


		          
		int i=ps.executeUpdate();  
		if(i>0)  
		out.print("You are successfully registered...");  
		      
		          
		}catch (Exception e2) {System.out.println(e2);}  
		          
		out.close();  
		}  
		  	
	}


