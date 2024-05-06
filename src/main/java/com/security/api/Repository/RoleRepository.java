package com.security.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.api.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
