package com.flowu.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "flow_edges")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class FlowEdge {

    @Id
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="flow_id", nullable = false)
    private Flow flow;

    private String source;
    private String target;
    private String sourceHandle;
    private String targetHandle;

    @Column(columnDefinition = "JSONB")
    private String style;

    private Boolean animated;
    private String type;
}
