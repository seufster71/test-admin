package com.example.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.admin.repository.CalcDao;
import com.example.core.service.ServiceProcessor;
import com.example.utils.Request;
import com.example.utils.Response;

@Service("CalcSvcImpl")
public class CalcSvcImpl implements ServiceProcessor, CalcSvc {

	@Autowired
	protected CalcDao calcDao;
	
	@Override
	public void process(Request request, Response response) {
		String action = (String) request.getParams().get("action");
		switch (action) {
			case "LIST":
				this.list(request, response);
				break;
			case "ITEM":
				this.item(request, response);
				break;
			case "SAVE":
				this.save(request, response);
				break;
		}
	}

	@Override
	public void item(Request request, Response response){
		calcDao.item(request, response);
	}
	
	@Override
	public void list(Request request, Response response) {
		calcDao.list(request, response);
	}

	@Override
	public void save(Request request, Response response) {
		calcDao.save(request, response);
	}
}
