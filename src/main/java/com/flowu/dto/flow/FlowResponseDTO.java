package com.flowu.dto.flow;

import com.flowu.dto.flowedge.FlowEdgeDTO;
import com.flowu.dto.flownode.FlowNodeDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlowResponseDTO {

    private String id;
    private String title;
    private Long userId;
    private Long companyId;
    private Long executedSuccessCount;
    private Long executedErrorCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<FlowNodeDTO> nodes;
    private List<FlowEdgeDTO> edges;
}
