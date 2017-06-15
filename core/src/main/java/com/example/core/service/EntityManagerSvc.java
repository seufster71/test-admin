package com.example.core.service;

import javax.persistence.EntityManager;

public interface EntityManagerSvc {

	EntityManager getInstance();
	EntityManager getMain();
	EntityManager getMulti();
}
