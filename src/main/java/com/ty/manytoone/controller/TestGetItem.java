package com.ty.manytoone.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.manytoone.dto.AmazonOrder;
import com.ty.manytoone.dto.Item;

public class TestGetItem {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Item item = entityManager.find(Item.class, 1);
		System.out.println("Item name : " + item.getName());
		System.out.println("Item Price : " + item.getPrice());
		System.out.println("Item qty : " + item.getQuantity());
		System.out.println("--------------------------------------");

		AmazonOrder amazonOrder = item.getAmazonOrder();
		System.out.println("Order name : " + amazonOrder.getName());
		System.out.println("Order address : " + amazonOrder.getAddress());
		System.out.println("Order status : " + amazonOrder.getStatus());
	}
}
