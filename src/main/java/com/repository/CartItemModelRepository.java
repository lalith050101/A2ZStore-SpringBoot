package com.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.CartItemModel;
import com.model.UserModel;

@Repository
public interface CartItemModelRepository extends JpaRepository<CartItemModel, Long> {

	Set<CartItemModel> findAllByUserId(UserModel user);
	
	Set<CartItemModel> findAllByUserIdAndProceedToPayment(UserModel userModel, boolean proceedToPayment);
	
	Long deleteAllByUserIdAndProceedToPayment(UserModel userModel, boolean proceedToPayment);

}
