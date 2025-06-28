package com.flowu.repository;

import com.flowu.model.FlowNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowNodeRepository extends JpaRepository<FlowNode, String> {

}
