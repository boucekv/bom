package com.example.bom.Data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemService extends JpaRepository<Item, Long> {
}
