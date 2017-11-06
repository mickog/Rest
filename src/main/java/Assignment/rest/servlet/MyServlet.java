package Assignment.rest.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Assignment.rest.client.CDClient;
import Assignment.rest.model.CD;

@WebServlet("/helloServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CDClient client = new CDClient();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("GETTING IN HERE TO GET");
    	
    	PrintWriter writer = response.getWriter();		
		List<CD> list = client.get();
		System.out.println("list size in servlet is "+list.size());

		
		writer.println("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN'"
				+ "'http://www.w3.org/TR/html4/loose.dtd'>"
				+"<html><head>"+
				"<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>"+
				"<title>REST ASSIGNMENT</title>"+
				  "<link rel='stylesheet' href='standard.css'>"+
				  "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>"+
				  "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>"+
				  "<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>"+
				"</head>"+
				"<body>"
				+"<nav class='navbar navbar-default'>"
				+"<div class='container-fluid'>"
				+"<div class='navbar-header'>"
				+"<div class='navbar-brand' href='#'>REST Assignment</a></div>"
				+"<div class='nav navbar-nav'>"
				   +"<li><a href='add.jsp'>CREATE</a></li>"
				    +"<li><a href='/rest/myServlet'>READ ALL</a></li>"
				    +"<li><a href='delete.jsp'>DELETE</a></li>"
				    +"<li><a href='update.jsp'>UPDATE</a></li>"
				    +"<li><a href='readOne.jsp'>READ ONE</a></li>"
				+"</ul> </div></nav>");
		
		
		
		for(int i = 0 ; i < list.size() ; i++){
//			x[i] = "<form action='myServlet' method='post'><input type='hidden' name='id' value='"+list.get(i).getId()+"'><input type='submit' name='submit' value='DELETE' /><hr>";
//				System.out.println(list.get(i).getArtistName());
	    		writer.println("Artist : "+list.get(i).getArtistName()
	    				+"<br>ID : "+list.get(i).getId()
	    				+"<br>Title : "+list.get(i).getTitle()
	    				+"<br>Duration"+list.get(i).getDuration()
	    				+"<hr>");

		} //+list.get(i).getId()+
		writer.close();
    	
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("submit");
		client = new CDClient();
		
		if(action.equals("READONE"))
		{
		String id = request.getParameter("id");
		CD c = client.get(id);
	
		PrintWriter writer = response.getWriter();
		writer.println("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN'"
				+ "'http://www.w3.org/TR/html4/loose.dtd'>"
				+"<html><head>"+
				"<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>"+
				"<title>REST ASSIGNMENT</title>"+
				  "<link rel='stylesheet' href='standard.css'>"+
				  "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>"+
				  "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>"+
				  "<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>"+
				"</head>"+
				"<body>"
				+"<nav class='navbar navbar-default'>"
				+"<div class='container-fluid'>"
				+"<div class='navbar-header'>"
				+"<div class='navbar-brand' href='#'>REST Assignment</a></div>"
				+"<div class='nav navbar-nav'>"
				   +"<li><a href='add.jsp'>CREATE</a></li>"
				    +"<li><a href='/rest/myServlet'>READ ALL</a></li>"
				    +"<li><a href='delete.jsp'>DELETE</a></li>"
				    +"<li><a href='update.jsp'>UPDATE</a></li>"
				    +"<li><a href='readOne.jsp'>READ ONE</a></li>"
				+"</ul> </div></nav>");
			
		writer.println("<br>Successfully fetched record </h1>"+c.getId()+"<br>Artist "+c.getArtistName()+"<br>title : "+c.getTitle()+"<br>duration : "+c.getDuration());
		writer.close();
		}
		else if(action.equals("ADD"))
		{
			String id = request.getParameter("id");
			String artistName = request.getParameter("artistName");
			String title = request.getParameter("title");
			int duration = Integer.parseInt(request.getParameter("duration"));

			CD c = new CD();
			c.setId(id);
			c.setArtistName(artistName);
			c.setTitle(title);
			c.setDuration(duration);
			
			client.create(c);
//				HttpServletResponse h = new HttpServletResponse();
			response.sendRedirect("http://localhost:8080/rest/myServlet");
//		PrintWriter writer = response.getWriter();
//		writer.println("<h1><a href = 'index.jsp'>Home</a><br>Successfully added "+c.getTitle()+"</h1>");
//		writer.close();
		}
		
		else if(action.equals("READ"))
		{
			String id = request.getParameter("id");

			
			CD c = client.get(id);
		PrintWriter writer = response.getWriter();
		writer.println("<h1><a href = 'index.jsp'>Home</a><br>Successfully fetched record </h1>"+c.getId()+"<br>Artist "+c.getArtistName()+"<br>title : "+c.getTitle()+"<br>duration : "+c.getDuration());
		writer.close();
		}
				
		else if(action.equals("DELETE"))
		{
			String id = request.getParameter("id");

			
			client.delete(id);
			response.sendRedirect("http://localhost:8080/rest/myServlet");

		PrintWriter writer = response.getWriter();
		writer.println("<h1><a href = 'index.jsp'>Home</a><br>Successfully deleted record </h1>");
		writer.close();
		}
				
		else if(action.equals("UPDATE"))
		{
			String id = request.getParameter("id");
			String artistName = request.getParameter("artistName");
			String title = request.getParameter("title");
			int duration = Integer.parseInt(request.getParameter("duration"));

			CD c = new CD();
			c.setId(id);
			c.setArtistName(artistName);
			c.setTitle(title);
			c.setDuration(duration);
			
			client.update(c);
			
			response.sendRedirect("http://localhost:8080/rest/myServlet");

		PrintWriter writer = response.getWriter();
		writer.println("<h1><a href = 'index.jsp'>Home</a><br>Successfully updated record </h1>");
		writer.close();
		}
	}

}
