package com.flowu.dto.flownode;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlowNodeDTO {

    @NotBlank(message = "O ID do nó não pode ser vazio.")
    private String id;

    @NotBlank(message = "O tipo do nó não pode ser vazio.")
    private String type;

    @NotBlank(message = "A posição do nó não pode ser vazia.")
    private String position; //JSON String

    @NotNull(message = "A largura do nó não pode ser nula.")
    private Integer width;

    @NotNull(message = "A altura do nó não pode ser nula.")
    private Integer height;

    private Boolean selected;
    private Boolean dragging;
    private String positionAbsolute; // JSON string
}
