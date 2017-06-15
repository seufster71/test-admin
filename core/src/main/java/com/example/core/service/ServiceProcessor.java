package com.example.core.service;

import com.example.utils.Request;
import com.example.utils.Response;

public interface ServiceProcessor {

	void process(Request request, Response response);
}
