package com.practiceproject.P1;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Customer,Integer> {
    public Customer findById(int id);
}
