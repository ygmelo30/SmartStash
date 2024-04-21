package com.inventory.yasser.smartStash.repositories;
import com.inventory.yasser.smartStash.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepo extends JpaRepository <Item, Long> {
}
