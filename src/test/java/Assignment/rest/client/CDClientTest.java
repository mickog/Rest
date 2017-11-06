package Assignment.rest.client;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.omg.CORBA.ACTIVITY_COMPLETED;

import Assignment.rest.model.CD;

public class CDClientTest {

	@Test
	public void testDelete()
	{
		CDClient client = new CDClient();
		client.delete("4422");
	}
	
	@Test
	public void testPut()
	{
		CD cd  = new CD();
		cd.setId("3456");
		cd.setTitle("Glass Animals");
		cd.setDuration(33);
		
		CDClient client = new CDClient();
		
		cd= client.update(cd);
		assertNotNull(cd);
	}
	@Test
	public void testCreate()
	{
		CDClient client = new CDClient();
		
		CD cd = new CD();
		cd.setId("1442");
		cd.setTitle("Becoming The Jackal");
		cd.setDuration(46);
		cd.setArtistName("Villagers");
		
		cd = client.create(cd);
		
		assertNotNull(cd);
	}
	
	
	@Test
	public void testGet() {
		CDClient client = new CDClient();
		CD cd = client.get("1234");		
		System.out.println(cd);
		
		assertNotNull(cd);
	}
	
	@Test
	public void testGetList()
	{
		CDClient client = new CDClient();
		List<CD> cds = client.get();	
		assertNotNull(cds); 
	}
	
}
