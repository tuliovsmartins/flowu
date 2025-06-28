package com.flowu.service;

import com.flowu.dto.flowedge.FlowEdgeDTO;
import com.flowu.mapper.FlowEdgeMapper;
import com.flowu.model.FlowEdge;
import com.flowu.repository.FlowEdgeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlowEdgeService {
    private final FlowEdgeRepository flowEdgeRepository;
    private final FlowEdgeMapper flowEdgeMapper;

    @Transactional
    public FlowEdge saveFlowEdge(FlowEdge flowEdge){
        return flowEdgeRepository.save(flowEdge);
    }

    @Transactional (readOnly = true)
    public Optional<FlowEdge> findFlowEdgeById(String id){
        return flowEdgeRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<FlowEdge> findAllFlowEdges(){
        return  flowEdgeRepository.findAll();
    }

    @Transactional
    public void deleteFlowEdgeById(String id){
        flowEdgeRepository.deleteById(id);
    }
    @Transactional
    public FlowEdge updateEdge(String id, FlowEdgeDTO dto) {

        FlowEdge existingEdge = flowEdgeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aresta não encontrada com o ID: " + id));
        flowEdgeMapper.updateEntityFromDto(dto, existingEdge);
        return flowEdgeRepository.save(existingEdge);
    }
}
