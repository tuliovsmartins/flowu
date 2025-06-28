package com.flowu.repository;

import com.flowu.model.Flow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlowRepository extends JpaRepository<Flow, String> {

    List<Flow> findByUserId(Long userId);

    Page<Flow> findByUserId(Long userId, Pageable pageable);

}