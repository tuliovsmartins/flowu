package com.flowu.repository;

import com.flowu.model.Flow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowRepository extends JpaRepository<Flow, String>{

}
