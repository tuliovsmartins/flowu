package com.flowu.controller;

import com.flowu.dto.flowedge.FlowEdgeDTO;
import com.flowu.mapper.FlowEdgeMapper;
import com.flowu.model.FlowEdge;
import com.flowu.service.FlowEdgeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid; // Para aplicar validação nos DTOs de requisição
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/edges") // Endpoint base para as arestas de fluxo
@RequiredArgsConstructor // Injeta automaticamente o FlowEdgeService e FlowEdgeMapper
public class FlowEdgeController {

    private final FlowEdgeService flowEdgeService;
    private final FlowEdgeMapper flowEdgeMapper;

    @PostMapping
    public ResponseEntity<FlowEdgeDTO> createEdge(@Valid @RequestBody FlowEdgeDTO flowEdgeDTO) {
        FlowEdge flowEdgeToSave = flowEdgeMapper.toEntity(flowEdgeDTO);
        FlowEdge savedFlowEdge = flowEdgeService.saveFlowEdge(flowEdgeToSave);
        return new ResponseEntity<>(flowEdgeMapper.toDto(savedFlowEdge), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlowEdgeDTO> getEdgeById(@PathVariable String id) {
        return flowEdgeService.findFlowEdgeById(id)
                .map(flowEdge -> ResponseEntity.ok(flowEdgeMapper.toDto(flowEdge)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<FlowEdgeDTO>> getAllEdges() {
        List<FlowEdgeDTO> edges = flowEdgeService.findAllFlowEdges().stream()
                .map(flowEdgeMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(edges);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlowEdgeDTO> updateEdge(@PathVariable String id, @Valid @RequestBody FlowEdgeDTO dto) {
        FlowEdge updatedEdge = flowEdgeService.updateEdge(id, dto);         return ResponseEntity.ok(flowEdgeMapper.toDto(updatedEdge));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEdge(@PathVariable String id) {
        flowEdgeService.deleteFlowEdgeById(id);
        return ResponseEntity.noContent().build();
    }
}
