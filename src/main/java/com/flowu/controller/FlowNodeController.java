package com.flowu.controller;

import com.flowu.dto.flownode.FlowNodeDTO;
import com.flowu.mapper.FlowNodeMapper;
import com.flowu.model.FlowNode;
import com.flowu.service.FlowNodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/nodes") // Endpoint base para os nós de fluxo
@RequiredArgsConstructor // Injeta automaticamente o FlowNodeService e FlowNodeMapper
public class FlowNodeController {

    private final FlowNodeService flowNodeService;
    private final FlowNodeMapper flowNodeMapper;

    @PostMapping
    public ResponseEntity<FlowNodeDTO> createNode(@Valid @RequestBody FlowNodeDTO flowNodeDTO) {
        // Mapeia o DTO para a entidade
        FlowNode flowNodeToSave = flowNodeMapper.toEntity(flowNodeDTO);
        // Salva a entidade
        FlowNode savedFlowNode = flowNodeService.saveFlowNode(flowNodeToSave);
        // Mapeia a entidade salva de volta para DTO de resposta e retorna
        return new ResponseEntity<>(flowNodeMapper.toDto(savedFlowNode), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlowNodeDTO> getNodeById(@PathVariable String id) {
        return flowNodeService.findFlowNodeById(id)
                .map(flowNode -> ResponseEntity.ok(flowNodeMapper.toDto(flowNode)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<FlowNodeDTO>> getAllNodes() {
        List<FlowNodeDTO> nodes = flowNodeService.findAllFlowNodes().stream()
                .map(flowNodeMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(nodes);
    }


    @PutMapping("/{id}")
    public ResponseEntity<FlowNodeDTO> updateNode(@PathVariable String id,
                                                  @Valid @RequestBody FlowNodeDTO flowNodeDTO) {
        // Busca o nó existente
        Optional<FlowNode> existingNodeOptional = flowNodeService.findFlowNodeById(id);
        if (existingNodeOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        FlowNode existingNode = existingNodeOptional.get();
        // Atualiza a entidade existente com os dados do DTO
        flowNodeMapper.updateEntityFromDto(flowNodeDTO, existingNode);
        FlowNode updatedNode = flowNodeService.saveFlowNode(existingNode); // Salva as alterações
        return ResponseEntity.ok(flowNodeMapper.toDto(updatedNode));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNode(@PathVariable String id) {
        flowNodeService.deleteFlowNodeById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/success")
    public ResponseEntity<Void> incrementNodeSuccessCount(@PathVariable String id) {
        flowNodeService.incrementNodeSuccessCount(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/error")
    public ResponseEntity<Void> incrementNodeErrorCount(@PathVariable String id) {
        flowNodeService.incrementNodeErrorCount(id);
        return ResponseEntity.noContent().build();
    }
}
