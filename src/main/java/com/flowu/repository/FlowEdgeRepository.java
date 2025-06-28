package com.flowu.repository;

import com.flowu.model.FlowEdge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowEdgeRepository extends JpaRepository<FlowEdge, String> {

}
