package com.bridgelabz.ServletJspApp2.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginRegister")
public class LoginRegister extends HttpServlet
{
private static final long serialVersionUID = 1L;
       
    
    public LoginRegister() 
    {
        super();
        
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	
			CustomerDAO cd=(CustomerDAO) new CustomerDataImp();
			
			String userName=request.getParameter("username");
			String password=request.getParameter("password");
			System.out.println(userName+ " "+password);
			
			 System.out.println("1");
			String submitType=request.getParameter("Submit");
			
			Customer cust=new Customer();
	
			//  username and password is going to check whether registerd or not
			//  by using getCustomer Method of CustomerDataIml Class
			int  value =cd.getCustomer(userName, password);
			 
			// Checking whether the value is greater than 0 if it is
			// then redirection to the Welcome message or next page
			if(value>0)
			{
			
			request.setAttribute("welcomeMessage",cust.getName());
			response.sendRedirect("ListUsers.jsp");
			
			}
			else if(submitType.equals("Register"))
			{
			
			cust.setName(request.getParameter("name"));
			cust.setPassword(password);
			cust.setUsername(userName);
			cd.registerCustomer(cust);
			request.setAttribute("successMessage","Registration Completed ..Proceeed to Login!!");
			request.getRequestDispatcher("loginpage.jsp").forward(request,response);
			}
			else
			{
			
			request.setAttribute("message","Data not Found, Please go for registration!!");
			request.getRequestDispatcher("loginpage.jsp").forward(request,response);
			}
			
			
			
	}
	
	
	
}