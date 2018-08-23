package com.epam.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.epam.entities.Transaction;
import com.epam.entities.Vehicle;

public class DBWrite {
	private Query query;
	private Transaction transaction = new Transaction();
	private Vehicle vehicle = new Vehicle();
	public void dbParkWrite(int slotNo, String CarNo) {
		JpaSingleton jpa = JpaSingleton.getInstance();
		EntityManager entitymanager = jpa.getEntitymanager();
		entitymanager.getTransaction( ).begin( );
		vehicle.setRegistrationNo(CarNo);
		vehicle.setVehicleType("car");
		entitymanager.persist(vehicle);
	    entitymanager.getTransaction().commit();
	    
	    query = entitymanager.createQuery("update transaction set id = ?,status = ? ,vehicleNo = ?, inTime = ? where slotNo = " + slotNo);
	    query.setParameter(1, 121);
	    query.setParameter(2, "parked");
	    query.setParameter(3, CarNo);
	    java.util.Date today = new java.util.Date();
	    query.setParameter(4, new java.sql.Timestamp(today.getTime()));
	    query.executeUpdate();
	    entitymanager.getTransaction().commit();
	}
	public void dbUnparkWrite(int slotNo, String CarNo) {
		JpaSingleton jpa = JpaSingleton.getInstance();
		EntityManager entitymanager = jpa.getEntitymanager();
		entitymanager.getTransaction( ).begin( );
	}
	public void dbInit(int slotSize) {
		JpaSingleton jpa = JpaSingleton.getInstance();
		EntityManager entitymanager = jpa.getEntitymanager();
		entitymanager.getTransaction( ).begin( );
		query = entitymanager.createQuery("delete from transaction");
		query.executeUpdate();
		entitymanager.persist(transaction);
		entitymanager.getTransaction().commit();
		query = entitymanager.createQuery("delete from vehicle");
		query.executeUpdate();
		entitymanager.persist(vehicle);
		entitymanager.getTransaction().commit();
		for(int iterator = 1; iterator <= slotSize; iterator++) {
			transaction.setSlotNo(iterator);
			transaction.setId(121);
			transaction.setStatus("empty");
			transaction.setVehicleNo(null);
			transaction.setInTime(null);
			entitymanager.persist(transaction);
			entitymanager.getTransaction().commit();
		}
	}
}
