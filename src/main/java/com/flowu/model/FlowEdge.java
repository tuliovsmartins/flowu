package com.flowu.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects; // Import necessário

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlowEdge flowEdge = (FlowEdge) o;
        return id != null && id.equals(flowEdge.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass(), id);
    }

    @Override
    public String toString() {
        return "FlowEdge{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", source='" + source + '\'' +
                ", target='" + target + '\'' +
                '}';
    }
}