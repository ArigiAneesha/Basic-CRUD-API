package com.aneesha.io.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aneesha.io.pojo.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
