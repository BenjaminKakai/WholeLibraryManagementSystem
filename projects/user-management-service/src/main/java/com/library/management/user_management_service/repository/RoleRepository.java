package com.library.management.user_management_service.repository;


import com.library.management.user_management_service.model.ERole;
import com.library.management.user_management_service.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
