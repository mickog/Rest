package Assignment.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import Assignment.rest.model.CD;
import Assignment.rest.repository.CDRepository;
import Assignment.rest.repository.CDRepositoryStub;

@Path("cds")
public class CDResource {

	private CDRepository cdRepos = new CDRepositoryStub();
	
	@DELETE
	@Path("{cdId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response delete(@PathParam ("cdId") String cdId) {
		System.out.println("Getting in here");
		cdRepos.delete(cdId);
		return Response.ok().build();
	}
	
	
	
	@PUT
	@Path("{cdId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response update(CD cd) {
		
		System.out.println(cd.getTitle());
		System.out.println(cd.getDuration());
		
		cd = cdRepos.update(cd);
		
		return Response.ok().entity(cd).build();
	}
	
	@POST
	@Path("cd")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public CD createActivity(CD cd) {
		
		System.out.println(cd.getTitle());
		System.out.println(cd.getDuration());
		
		cdRepos.create(cd);
		
		return cd;
	}
	
	@POST
	@Path("cd")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	public String createActivityParams(MultivaluedMap<String, String> formParams) {
		
		System.out.println(formParams.getFirst("id"));
		System.out.println(formParams.getFirst("title"));
		System.out.println(formParams.getFirst("artistName"));
		System.out.println(formParams.getFirst("duration"));
		
		CD cd = new CD();
		cd.setId(formParams.getFirst("id"));
		cd.setTitle(formParams.getFirst("title"));
		cd.setArtistName(formParams.getFirst("artistName"));
		cd.setDuration(Integer.parseInt(formParams.getFirst("duration")));
		
		cdRepos.create(cd);
		
		return "added succesfully";
	}
	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	public List<CD> getAllCDs()
	{
		List<CD> list = cdRepos.findAllCD(); 	
		System.out.println("Size of list in resource is "+list.size());
		return list; //this returns the cd list in json

	}
	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("{cdId}") //http:localhost:8080/exercise-services/webapi/cds/1234
	public Response getCD(@PathParam ("cdId") String cdId) {
		if(cdId==null)
		{
			return Response.status(Status.BAD_REQUEST).build();
		}
		CD cd = cdRepos.findCD(cdId);
		
		if(cd==null)
		{
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok().entity(cd).build();
	}
	

}
