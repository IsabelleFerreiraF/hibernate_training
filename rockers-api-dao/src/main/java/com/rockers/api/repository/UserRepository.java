package com.rockers.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rockers.api.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
