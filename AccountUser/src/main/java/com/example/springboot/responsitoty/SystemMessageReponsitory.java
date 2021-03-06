package com.example.springboot.responsitoty;

import com.example.springboot.entity.SystemMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SystemMessageReponsitory extends JpaRepository<SystemMessage, Integer> {

    List<SystemMessage> findBySource(String source);
}
