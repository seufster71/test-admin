package com.example.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.example.admin.kafka.MetricProducer;
import com.example.admin.model.Message;
import com.example.admin.repository.AdminDao;
import com.example.core.model.WorkUnit;
import com.example.core.service.ServiceProcessor;
import com.example.utils.Request;
import com.example.utils.Response;

@Service("AdminSvcImpl")
public class AdminSvcImpl implements ServiceProcessor, AdminSvc {

	@Autowired
	protected AdminDao adminDao;
	
	@Autowired
	protected JmsTemplate jmsTemplate;
	
	@Autowired
	protected MetricProducer metricProducer;
	
	
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
		adminDao.item(request, response);
	}

	@Override
	public void list(Request request, Response response) {
		adminDao.list(request, response);
	}

	@Override
	public void save(Request request, Response response) {
		adminDao.save(request, response);

		jmsTemplate.convertAndSend("mailbox", new Message("etst@setise.com","Hello world"));
		
		WorkUnit workUnit = new WorkUnit("test","test save");
		
		metricProducer.dispatch(workUnit);
	}

}
