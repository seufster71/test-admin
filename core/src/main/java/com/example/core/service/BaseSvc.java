package com.example.core.service;

import com.example.utils.Request;
import com.example.utils.Response;

public interface BaseSvc {

	void item(Request request, Response response);
	void list(Request request, Response response);
	void save(Request request, Response response);
}
