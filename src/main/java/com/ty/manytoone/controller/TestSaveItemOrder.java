package com.ty.manytoone.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manytoone.dto.AmazonOrder;
import com.ty.manytoone.dto.Item;

public class TestSaveItemOrder {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Item item1 = new Item();
		item1.setName("pillow");
		item1.setPrice(200);
		item1.setQuantity(1);

		Item item2 = new Item();
		item2.setName("bed sheet");
		item2.setPrice(600);
		item2.setQuantity(1);

		Item item3 = new Item();
		item3.setName("Eye mask");
		item3.setPrice(50);
		item3.setQuantity(1);

		AmazonOrder amazonOrder = new AmazonOrder();
		amazonOrder.setName("Sleeping Items");
		amazonOrder.setAddress("Murugesh palya");
		amazonOrder.setStatus("Getting packed");
		
		item1.setAmazonOrder(amazonOrder);
		item2.setAmazonOrder(amazonOrder);
		item3.setAmazonOrder(amazonOrder);
		
		entityTransaction.begin();
		entityManager.persist(amazonOrder);
		entityManager.persist(item1);
		entityManager.persist(item2);
		entityManager.persist(item3);
		entityTransaction.commit();
	}
}
