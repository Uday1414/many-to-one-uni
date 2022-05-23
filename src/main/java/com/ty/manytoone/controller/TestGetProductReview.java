package com.ty.manytoone.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.manytoone.dto.Product;
import com.ty.manytoone.dto.Review;

public class TestGetProductReview {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Review review = entityManager.find(Review.class, 10);
		if (review != null) {
			System.out.println("review Rating : " + review.getRating());
			System.out.println("review description : " + review.getDescription());
			System.out.println("-----------------------------------");

			Product product = review.getProduct();
			System.out.println("Product name : " + product.getName());
			System.out.println("Product Type : " + product.getType());
			System.out.println("Product cost : " + product.getCost());
		} else {
			System.out.println("No review from given Id");
		}
	}
}
