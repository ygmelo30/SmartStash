package com.inventory.yasser.smartStash.repositories;

import com.inventory.yasser.smartStash.models.Role;
import com.inventory.yasser.smartStash.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface RoleRepo extends JpaRepository<Role, Long> {
    Optional<Role> findByName(UserRole name);
}
