package com.epam.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaSingleton {
	private static JpaSingleton instance = null;
	private EntityManagerFactory emfactory;
	private EntityManager entitymanager;
	public JpaSingleton() {
		emfactory = Persistence.createEntityManagerFactory("autoparking");
		entitymanager = emfactory.createEntityManager();
	}
	public EntityManager getEntitymanager() {
		return entitymanager;
	}
	public static JpaSingleton getInstance() {
		if(instance == null) {
    		instance = new JpaSingleton();
    	}
    	return instance;
	}
}
