package com.abhishek.asset.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.abhishek.asset.entity.AssetsRegister;


public interface AssetsRegisterRepository extends JpaRepository<AssetsRegister, Integer> {

	
	int countByIssuedToEmployee(String IssuedToEmployee);
	
	
}


