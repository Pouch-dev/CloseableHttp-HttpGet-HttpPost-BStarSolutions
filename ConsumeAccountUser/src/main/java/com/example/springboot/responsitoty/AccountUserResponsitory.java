package com.example.springboot.responsitoty;

import com.example.springboot.entity.ConsumeAccountUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountUserResponsitory extends JpaRepository<ConsumeAccountUser, Integer> {


}
