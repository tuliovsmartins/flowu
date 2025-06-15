package com.flowu.dto.flowedge;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlowEdgeDTO {

    @NotBlank(message = "O ID da aresta não pode ser vazio.")
    private String id;

    @NotBlank(message = "O nó de origem da aresta não pode ser vazio.")
    private String source;

    @NotBlank(message = "O nó de destino da aresta não pode ser vazio.")
    private String target;

    private String sourceHandle;
    private String targetHandle;
    private String style; // JSON String
    private Boolean animated;
    private String type;
}
