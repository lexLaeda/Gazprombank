package com.test.yourself.authentification.repository;

import com.test.yourself.authentification.model.ERole;
import com.test.yourself.authentification.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole name);
}
