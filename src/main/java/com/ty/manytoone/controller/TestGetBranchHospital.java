package com.ty.manytoone.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.manytoone.dto.Branch;
import com.ty.manytoone.dto.Hospital;

public class TestGetBranchHospital {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Branch branch = entityManager.find(Branch.class, 10);
		if (branch != null) {
			System.out.println("Branch name : " + branch.getName());
			System.out.println("Branch phone : " + branch.getPhone());
			System.out.println("Branch state : "+branch.getState());
			System.out.println("Branch coountry : "+branch.getCountry());
			System.out.println("---------------------------------------");
			
			Hospital hospital=branch.getHospital();
			System.out.println("Hospial name : "+hospital.getName());
			System.out.println("Hospital website : "+hospital.getWeb());
		}
		else {
			System.out.println("No branch For given Id");
		}

	}
}
