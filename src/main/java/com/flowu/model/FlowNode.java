package com.flowu.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "flow_nodes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class FlowNode {

    @Id
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="flow_id", nullable = false)
    private Flow flow;

    private String type;

    @Column(columnDefinition = "JSONB")
    private String position;

    @Column(columnDefinition = "JSONB")
    private String data;

    private Integer width;
    private Integer height;
    private Boolean selected;
    private Boolean dragging;

    @Column(name = "position_absolute", columnDefinition = "JSONB")
    private String positionAbsolute;

    @Column(name = "executed_success_count")
    private Long executedSuccessCount = 0L;

    @Column(name = "executed_error_count")
    private Long executedErrorCount = 0L;


}
