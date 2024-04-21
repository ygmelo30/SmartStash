package com.inventory.yasser.smartStash.repositories;
import com.inventory.yasser.smartStash.models.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdminUserRepo extends JpaRepository <AdminUser, Long> {
}
