package com.inventory.yasser.smartStash.repositories;
import com.inventory.yasser.smartStash.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Optional;

public interface UserRepo extends JpaRepository <User, Long> {


    Optional<User> findByUsername(String username);
}
