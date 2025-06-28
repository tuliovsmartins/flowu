package com.flowu.controller;

import com.flowu.dto.flow.FlowRequestDTO;
import com.flowu.dto.flow.FlowResponseDTO;
import com.flowu.mapper.FlowMapper;
import com.flowu.model.Flow;
import com.flowu.service.FlowService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/flows")
@RequiredArgsConstructor
public class FlowController {
    private final FlowService flowService;
    private final FlowMapper flowMapper;
    @PostMapping
    public ResponseEntity<FlowResponseDTO> createFlow(@Valid @RequestBody FlowRequestDTO flowRequestDTO) {
        Flow savedFlow = flowService.createFlowFromDto(flowRequestDTO); // Delega tudo
        FlowResponseDTO responseDto = flowMapper.toResponseDto(savedFlow);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlowResponseDTO> getFlowById(@PathVariable String id) {
        return flowService.findFlowById(id)
                .map(flow -> ResponseEntity.ok(flowMapper.toResponseDto(flow)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<FlowResponseDTO>> getAllFlows() {
        List<FlowResponseDTO> flows = flowService.findAllFlows().stream()
                .map(flowMapper::toResponseDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(flows);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlowResponseDTO> updateFlow(@PathVariable String id,
                                                      @Valid @RequestBody FlowRequestDTO flowRequestDTO) {
        Flow updatedFlow = flowService.updateFlow(id, flowMapper.toEntity(flowRequestDTO));
        return Optional.ofNullable(updatedFlow)
                .map(flow -> ResponseEntity.ok(flowMapper.toResponseDto(flow)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlow(@PathVariable String id) {
        flowService.deleteFlowById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/success")
    public ResponseEntity<Void> incrementFlowSuccessCount(@PathVariable String id) {
        flowService.incrementExecutedSuccessCount(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/error")
    public ResponseEntity<Void> incrementFlowErrorCount(@PathVariable String id) {
        flowService.incrementExecutedErrorCount(id);
        return ResponseEntity.noContent().build();
    }

}