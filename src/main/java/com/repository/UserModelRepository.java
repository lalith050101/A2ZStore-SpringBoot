package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.UserModel;

@Repository
public interface UserModelRepository extends JpaRepository<UserModel, String> {

}
