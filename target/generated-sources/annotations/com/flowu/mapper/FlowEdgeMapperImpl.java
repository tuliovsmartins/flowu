package com.flowu.mapper;

import com.flowu.dto.flowedge.FlowEdgeDTO;
import com.flowu.model.FlowEdge;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-23T22:54:10-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class FlowEdgeMapperImpl implements FlowEdgeMapper {

    @Override
    public FlowEdgeDTO toDto(FlowEdge flowEdge) {
        if ( flowEdge == null ) {
            return null;
        }

        FlowEdgeDTO.FlowEdgeDTOBuilder flowEdgeDTO = FlowEdgeDTO.builder();

        flowEdgeDTO.id( flowEdge.getId() );
        flowEdgeDTO.source( flowEdge.getSource() );
        flowEdgeDTO.target( flowEdge.getTarget() );
        flowEdgeDTO.sourceHandle( flowEdge.getSourceHandle() );
        flowEdgeDTO.targetHandle( flowEdge.getTargetHandle() );
        flowEdgeDTO.style( flowEdge.getStyle() );
        flowEdgeDTO.animated( flowEdge.getAnimated() );
        flowEdgeDTO.type( flowEdge.getType() );

        return flowEdgeDTO.build();
    }

    @Override
    public FlowEdge toEntity(FlowEdgeDTO flowEdgeDTO) {
        if ( flowEdgeDTO == null ) {
            return null;
        }

        FlowEdge.FlowEdgeBuilder flowEdge = FlowEdge.builder();

        flowEdge.id( flowEdgeDTO.getId() );
        flowEdge.source( flowEdgeDTO.getSource() );
        flowEdge.target( flowEdgeDTO.getTarget() );
        flowEdge.sourceHandle( flowEdgeDTO.getSourceHandle() );
        flowEdge.targetHandle( flowEdgeDTO.getTargetHandle() );
        flowEdge.style( flowEdgeDTO.getStyle() );
        flowEdge.animated( flowEdgeDTO.getAnimated() );
        flowEdge.type( flowEdgeDTO.getType() );

        return flowEdge.build();
    }

    @Override
    public void updateEntityFromDto(FlowEdgeDTO flowEdgeDTO, FlowEdge flowEdge) {
        if ( flowEdgeDTO == null ) {
            return;
        }

        if ( flowEdgeDTO.getSource() != null ) {
            flowEdge.setSource( flowEdgeDTO.getSource() );
        }
        if ( flowEdgeDTO.getTarget() != null ) {
            flowEdge.setTarget( flowEdgeDTO.getTarget() );
        }
        if ( flowEdgeDTO.getSourceHandle() != null ) {
            flowEdge.setSourceHandle( flowEdgeDTO.getSourceHandle() );
        }
        if ( flowEdgeDTO.getTargetHandle() != null ) {
            flowEdge.setTargetHandle( flowEdgeDTO.getTargetHandle() );
        }
        if ( flowEdgeDTO.getStyle() != null ) {
            flowEdge.setStyle( flowEdgeDTO.getStyle() );
        }
        if ( flowEdgeDTO.getAnimated() != null ) {
            flowEdge.setAnimated( flowEdgeDTO.getAnimated() );
        }
        if ( flowEdgeDTO.getType() != null ) {
            flowEdge.setType( flowEdgeDTO.getType() );
        }
    }
}
