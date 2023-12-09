package com.example.web2023.repo;

import com.example.web2023.entity.StreamDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamRepo extends JpaRepository<StreamDTO, Long> {
}
