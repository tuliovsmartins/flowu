package com.flowu.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlowNode flowNode = (FlowNode) o;
        return id != null && id.equals(flowNode.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass(), id);
    }

    @Override
    public String toString() {
        return "FlowNode{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}