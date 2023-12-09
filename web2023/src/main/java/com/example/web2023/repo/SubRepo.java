package com.example.web2023.repo;

import com.example.web2023.entity.SubDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubRepo extends JpaRepository<SubDTO, Long> {

    SubDTO findSubDTOBySubName(String subName);

}
