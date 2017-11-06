package Assignment.rest.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Assignment.rest.model.CD;
/**********************************************use this to pull from database etc***************************/
public class CDRepositoryStub implements CDRepository {

	private static Connection con;
	
	private void getConnection() throws ClassNotFoundException, SQLException {

		
		Class.forName("org.sqlite.JDBC");
		con= DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Mick\\Desktop\\Year 4\\New folder (2)\\restDatabase.sqlite");
		
	}

	@Override
	public List<CD> findAllCD()
	{
		List<CD> cds = new ArrayList<CD>();

		if(con==null)
		{

			try {
				getConnection();
			
		
		Statement state = con.createStatement();
		ResultSet res = state.executeQuery("SELECT * FROM CDTable");

		while(res.next())
		{
			CD c = new CD();
			c.setArtistName(res.getString("artistName"));
			c.setDuration(res.getInt("duration"));
			c.setId(res.getString("id"));
			c.setTitle(res.getString("title"));
			
			cds.add(c);
			
			
		}
			} catch (Exception e) {
				System.out.println("Exception is ------->"+e);
			}
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("--------------->"+e);
		}
		con=null;
		return cds;
		
	}

	@Override
	public CD findCD(String cdId) {
		// TODO Auto-generated method stub
		
		CD c = new CD();
		if(con==null)
		{

		try{
			getConnection();

		
		System.out.println("also getting to here with id "+cdId);
		Statement state = con.createStatement();
		ResultSet res = state.executeQuery("SELECT * FROM CDTable");
		System.out.println("LAST IS ");
		while(res.next())
		{
			if(res.getString("id").equals(cdId))
					{
				System.out.println("in here ");
//			System.out.println("something ->"+res.getString("artistName"));
			c.setArtistName(res.getString("artistName"));
			c.setDuration(res.getInt("duration"));
			c.setId(res.getString("id"));
			c.setTitle(res.getString("title"));
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("--------------->"+e);
			}
			con=null;

			return c;
					}
			
		}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("--------------->"+e);
		}
		con=null;

		return c;
	}

	@Override
	public void create(CD cd) {

		try{
		if(con==null)
		{
			getConnection();
		}

		PreparedStatement prep = con.prepareStatement("INSERT INTO CDTable values(?,?,?,?);");
		prep.setString(1, cd.getId());
		prep.setString(2, cd.getTitle());
		prep.setInt(3, cd.getDuration());
		prep.setString(4, cd.getArtistName());
		
		prep.execute();
		}
		catch(Exception e)
		{
			System.out.println("Exception caught "+e);
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("--------------->"+e);
		}
		con=null;

		
	}

	@Override
	public CD update(CD cd) {
		
		try{
			if(con==null)
			{
				getConnection();
			}
			
			 // create our java preparedstatement using a sql update query
		    PreparedStatement ps = con.prepareStatement(
		      "UPDATE CDTable SET title = ?, artistName = ?, duration = ? WHERE id = ?");

		    // set the preparedstatement parameters
		    ps.setString(1,cd.getTitle());
		    ps.setString(2,cd.getArtistName());
		    ps.setInt(3,cd.getDuration());
		    ps.setString(4,cd.getId());

		    // call executeUpdate to execute our sql update statement
		    ps.executeUpdate();
		    ps.close();
		  }
//			String sql = "SELECT * FROM CDTable Where id="+cd.getId();
//			Statement state = con.createStatement();
//			ResultSet res = state.executeQuery(sql);
//			
//			int i = 0;
//			while(res.next()) {
//			    i++;
//			}
//			if(i>0)
//				{
//				PreparedStatement prep = con.prepareStatement("INSERT INTO CDTable values(?,?,?,?);");
//				prep.setString(1, cd.getId());
//				prep.setString(2, cd.getTitle());
//				prep.setInt(3, cd.getDuration());
//				prep.setString(4, cd.getArtistName());
//				
//				prep.execute();
//				}
			
			catch(Exception e)
			{
				System.out.println("Exception caught "+e);
			}
			
		//search the database to see if we have cd with the same id 
		//select * from activity where id =?
		//if rs size ==0
		//insert into activity table
		//else
		//update the activity
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("--------------->"+e);
		}
		con=null;

		return cd;
	}

	@Override
	public void delete(String cdId) {
		//delete from cd where cdId is ?
		try{
		if(con==null)
		{
			System.out.println("CONNECTION WAS NULL");

			getConnection();
			System.out.println("GOT CONNECTION ID IS "+cdId);

		}
		PreparedStatement prep = con.prepareStatement("DELETE FROM CDTable WHERE id = (?);");
		prep.setString(1, cdId);	
		prep.execute();
		}
		catch(Exception e)
		{
			System.out.println("Exception caught "+e);
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("--------------->"+e);
		}
		con=null;

	}
}
