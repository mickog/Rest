package Assignment.rest.client;

import java.util.List;

import javax.management.RuntimeErrorException;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Assignment.rest.model.CD;


public class CDClient extends HttpServlet{
	
	private Client client;
	
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
//        
//    	try{
//    		String forward="";
//    	
//        String action = request.getParameter("action");
//
//        if (action.equalsIgnoreCase("delete")){
//            String cdId = request.getParameter("cdId");
//            delete(cdId);
//            }
//    	}catch(Exception e)
//    	{
//    		System.out.println("----------> "+e);
//    	}
////            forward = LIST_USER;
////            request.setAttribute("users", dao.getAllUsers());    
//        }
//        
	public CDClient()
	{
		client = ClientBuilder.newClient();
	}
	
	public CD get(String id)
	{
		WebTarget target =  client.target("http://localhost:8080/rest/webapi/");
		
		Response response = target.path("cds/"+id).request(MediaType.APPLICATION_JSON).get(Response.class);
		
		
		if(response.getStatus() != 200)
		{
			throw new RuntimeException(response.getStatus()+ " there was an error on the server");
		}
		return response.readEntity(CD.class);
	}
	
	public List<CD> get()
	{

		WebTarget target =  client.target("http://localhost:8080/rest/webapi/");
		List<CD> response = target.path("cds").request(MediaType.APPLICATION_JSON).get(new GenericType<List<CD>>(){});
		return response;
	}

	public CD create(CD cd) //http://localhost:8080/rest/webapi/cds/cd
	{
		WebTarget target =  client.target("http://localhost:8080/rest/webapi/");
		
		Response response = target.path("cds/cd").request(MediaType.APPLICATION_JSON).post(Entity.entity(cd, MediaType.APPLICATION_JSON));
		
		
		if(response.getStatus() != 200)
		{
			throw new RuntimeException(response.getStatus()+ " there was an error on the server");
		}
		return response.readEntity(CD.class);
		

	}

	public CD update(CD cd) {
		WebTarget target =  client.target("http://localhost:8080/rest/webapi/");
		Response response = target.path("cds/"+cd.getId())
				.request(MediaType.APPLICATION_JSON)
				.put(Entity.entity(cd, MediaType.APPLICATION_JSON));
		if(response.getStatus() != 200)
		{
			throw new RuntimeException(response.getStatus()+ " there was an error on the server");
		}
		return response.readEntity(CD.class);
	}

	public void delete(String cdId) {

		WebTarget target =  client.target("http://localhost:8080/rest/webapi/");
		Response response = target.path("cds/"+cdId)
				.request(MediaType.APPLICATION_JSON)
				.delete();
		
		if(response.getStatus() != 200)
		{
			throw new RuntimeException(response.getStatus()+ " there was an error on the server");
		}
	}
	
	


}
