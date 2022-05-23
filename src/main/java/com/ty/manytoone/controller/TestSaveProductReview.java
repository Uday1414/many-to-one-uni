package com.ty.manytoone.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manytoone.dto.Product;
import com.ty.manytoone.dto.Review;

public class TestSaveProductReview {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Review review1 = new Review();
		review1.setRating(4.5);
		review1.setDescription("very good quality");

		Review review2 = new Review();
		review2.setRating(4);
		review2.setDescription("Worth of money");

		Review review3 = new Review();
		review3.setRating(4);
		review3.setDescription("awesome");

		Product product = new Product();
		product.setName("Puma shoes");
		product.setType("footware");
		product.setCost(12000);

		review1.setProduct(product);
		review2.setProduct(product);
		review3.setProduct(product);
		
		entityTransaction.begin();
		entityManager.persist(review1);
		entityManager.persist(review2);
		entityManager.persist(review3);
		entityManager.persist(product);
		entityTransaction.commit();
	}
}
