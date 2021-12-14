package com.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.CartItemModel;
import com.model.OrderModel;
import com.model.UserModel;

@Repository
public interface OrderModelRepository extends JpaRepository<OrderModel, Long> {

	Set<OrderModel> findAllByUserId(String user);
	
}
