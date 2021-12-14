package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.OrderItemModel;

@Repository
public interface OrderItemModelRepository extends JpaRepository<OrderItemModel, Long> {

	
}
