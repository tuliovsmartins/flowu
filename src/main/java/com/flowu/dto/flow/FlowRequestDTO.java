package com.flowu.dto.flow;


import com.flowu.dto.flowedge.FlowEdgeDTO;
import com.flowu.dto.flownode.FlowNodeDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlowRequestDTO {

    private String id;

    @NotBlank(message = "O título do fluxo não pode ser vazio.")
    @Size(max = 255, message = "O título do fluxo não pode exceder 255 caracteres.")
    private String title;

    @NotNull(message = "O ID do usuário não pode ser nulo.")
    private Long userId;

    @NotNull(message = "O ID da empresa não pode ser nulo.")
    private  Long companyId;

    @Valid
    @NotNull(message = "A lista de nós não pode ser nula.")
    private List<FlowNodeDTO> nodes;

    @Valid
    @NotNull(message = "A lista de arestas não pode ser nula.")
    private List<FlowEdgeDTO> edges;

}
