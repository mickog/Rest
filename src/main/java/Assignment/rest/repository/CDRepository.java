package Assignment.rest.repository;

import java.util.List;

import Assignment.rest.model.CD;

public interface CDRepository {

	 List<CD> findAllCD();

	CD findCD(String cdId);

	void create(CD cd);

	 CD update(CD cd);

	void delete(String cdId);
	 

}