package com.blog.apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.apis.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
