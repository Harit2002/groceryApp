package com.crio.grocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Item extends JpaRepository<Item, Integer> {
}
