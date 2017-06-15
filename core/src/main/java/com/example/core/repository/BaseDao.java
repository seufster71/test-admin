package com.example.core.repository;

import com.example.utils.Request;
import com.example.utils.Response;

public interface BaseDao {

	void item(Request request, Response response);
	void list(Request request, Response response);
	void save(Request request, Response response);
}
