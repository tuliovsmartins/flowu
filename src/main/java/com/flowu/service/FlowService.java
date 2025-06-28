package com.flowu.service;

import com.flowu.dto.flow.FlowRequestDTO;
import com.flowu.mapper.FlowEdgeMapper;
import com.flowu.mapper.FlowMapper;
import com.flowu.mapper.FlowNodeMapper;
import com.flowu.model.Flow;
import com.flowu.model.FlowEdge;
import com.flowu.model.FlowNode;
import com.flowu.repository.FlowRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlowService {
    private final FlowRepository flowRepository;
    private final FlowMapper flowMapper;
    private final FlowNodeMapper flowNodeMapper;
    private final FlowEdgeMapper flowEdgeMapper;

    @Transactional
    public Flow saveFlow(Flow flow){
        //ToDo: Ver com o túlio sobre as regras
        return flowRepository.save(flow);
    }

    @Transactional( readOnly = true )
    public Optional<Flow> findFlowById (String id){
        return flowRepository.findById(id);
    }

    @Transactional (readOnly = true)
    public List<Flow> findAllFlows(){
        return flowRepository.findAll();
    }

    @Transactional
    public void deleteFlowById(String id){
        flowRepository.deleteById(id);
    }

    @Transactional
    public Flow updateFlow(String id, Flow updateData){
        Flow existingFlow = flowRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Flow não encontrado com o ID: " + id));

        existingFlow.updateInfo(
                updateData.getTitle(),
                updateData.getUserId(),
                updateData.getCompanyId()
        );

        return existingFlow;
    }

    @Transactional
    public void incrementExecutedSuccessCount(String flowId){
        flowRepository.findById(flowId).ifPresent(flow ->{
            flow.setExecutedSuccessCount(flow.getExecutedSuccessCount() + 1);
            flowRepository.save(flow);
        });
    }

    @Transactional
    public void incrementExecutedErrorCount(String flowId){
        flowRepository.findById(flowId).ifPresent(flow -> {
            flow.setExecutedErrorCount(flow.getExecutedErrorCount() + 1);
            flowRepository.save(flow);
        });
    }

    @Transactional
    public Flow createFlowFromDto(FlowRequestDTO dto) {
        Flow flow = flowMapper.toEntity(dto);


        if (dto.getNodes() != null) {
            dto.getNodes().forEach(nodeDto -> {
                FlowNode node = flowNodeMapper.toEntity(nodeDto);
                flow.addNode(node);
            });
        }
        if (dto.getEdges() != null) {
            dto.getEdges().forEach(edgeDto -> {
                FlowEdge edge = flowEdgeMapper.toEntity(edgeDto);
                flow.addEdge(edge);
            });
        }

        return flowRepository.save(flow);
    }
}
