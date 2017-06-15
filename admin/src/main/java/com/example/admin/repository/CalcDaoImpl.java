package com.example.admin.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.core.model.Userb;
import com.example.core.service.EntityManagerSvc;
import com.example.utils.Request;
import com.example.utils.Response;

@Repository
@Transactional("transactionManagerB")
public class CalcDaoImpl implements CalcDao {

	@Autowired
	EntityManagerSvc em;
	
	@Override
	public void item(Request request, Response response) {
		if (request.getParams().get("id") != null){
			Userb user = em.getMain().find(Userb.class, (int) request.getParams().get("id"));
			response.getParams().put("user", user);
		}
		response.getParams().put("status", "Got it from item calc repo");
	}

	@Override
	public void list(Request request, Response response) {
		
		response.getParams().put("status", "Got it from list calc repo");
	}

	@Override
	public void save(Request request, Response response) {
		Userb user = new Userb("Tom","Jones");
		em.getMain().persist(user);
		response.getParams().put("status", "Saved in calc repo " + user.getId());
	}

}
