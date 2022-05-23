package com.ty.manytoone.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manytoone.dto.Review;

public class TestDeleteProductReview {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Review review=entityManager.find(Review.class,6);
		
		if(review!=null) {
		entityTransaction.begin();
		entityManager.remove(review);
		entityTransaction.commit();
		}else {
			System.out.println("No review from given ID");
		}
	}
}
