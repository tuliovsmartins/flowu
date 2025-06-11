package com.flowu.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "flows")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Flow {

    @Id
    private String id;

    private String title;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "executed_success_count")
    private Long executedSuccessCount = 0L;

    @Column(name = "executed_error_count")
    private Long executedErrorCount = 0L;

    @CreationTimestamp
    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "flow", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<FlowNode> nodes = new ArrayList<>();


    @OneToMany(mappedBy = "flow", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<FlowEdge> edges = new ArrayList<>();


    public void addNode(FlowNode node) {
        nodes.add(node);
        node.setFlow(this);
    }

    public void removeNode(FlowNode node) {
        nodes.remove(node);
        node.setFlow(null);
    }

    public void addEdge(FlowEdge edge) {
        edges.add(edge);
        edge.setFlow(this);
    }

    public void removeEdge(FlowEdge edge) {
        edges.remove(edge);
        edge.setFlow(null);
    }

}
