package com.flowu.service;

import com.flowu.model.FlowNode;
import com.flowu.repository.FlowNodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlowNodeService {
    private final FlowNodeRepository flowNodeRepository;


    @Transactional
    public FlowNode saveFlowNode(FlowNode flowNode){
        return flowNodeRepository.save(flowNode);
    }

    @Transactional (readOnly = true)
    public Optional<FlowNode> findFlowNodeById(String id){
        return flowNodeRepository.findById(id);
    }

    @Transactional (readOnly = true)
    public List<FlowNode> findAllFlowNodes(){
        return flowNodeRepository.findAll();
    }

    @Transactional
    public void deleteFlowNodeById (String id){
        flowNodeRepository.deleteById(id);
    }

    @Transactional
    public void incrementNodeSuccessCount(String nodeId){
        flowNodeRepository.findById(nodeId).ifPresent(
                node -> {
                    node.setExecutedSuccessCount(node.getExecutedSuccessCount()+1);
                    flowNodeRepository.save(node);
                }
        );
    }

    @Transactional
    public void incrementNodeErrorCount(String nodeId){
        flowNodeRepository.findById(nodeId).ifPresent(node ->{
            node.setExecutedErrorCount(node.getExecutedErrorCount()+1);
            flowNodeRepository.save(node);
        });
    }

    }
