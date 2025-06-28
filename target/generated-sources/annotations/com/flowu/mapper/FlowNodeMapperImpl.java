package com.flowu.mapper;

import com.flowu.dto.flownode.FlowNodeDTO;
import com.flowu.model.FlowNode;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-23T22:54:10-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class FlowNodeMapperImpl implements FlowNodeMapper {

    @Override
    public FlowNodeDTO toDto(FlowNode flowNode) {
        if ( flowNode == null ) {
            return null;
        }

        FlowNodeDTO.FlowNodeDTOBuilder flowNodeDTO = FlowNodeDTO.builder();

        flowNodeDTO.id( flowNode.getId() );
        flowNodeDTO.type( flowNode.getType() );
        flowNodeDTO.position( flowNode.getPosition() );
        flowNodeDTO.width( flowNode.getWidth() );
        flowNodeDTO.height( flowNode.getHeight() );
        flowNodeDTO.selected( flowNode.getSelected() );
        flowNodeDTO.dragging( flowNode.getDragging() );
        flowNodeDTO.positionAbsolute( flowNode.getPositionAbsolute() );

        return flowNodeDTO.build();
    }

    @Override
    public FlowNode toEntity(FlowNodeDTO flowNodeDTO) {
        if ( flowNodeDTO == null ) {
            return null;
        }

        FlowNode.FlowNodeBuilder flowNode = FlowNode.builder();

        flowNode.id( flowNodeDTO.getId() );
        flowNode.type( flowNodeDTO.getType() );
        flowNode.position( flowNodeDTO.getPosition() );
        flowNode.width( flowNodeDTO.getWidth() );
        flowNode.height( flowNodeDTO.getHeight() );
        flowNode.selected( flowNodeDTO.getSelected() );
        flowNode.dragging( flowNodeDTO.getDragging() );
        flowNode.positionAbsolute( flowNodeDTO.getPositionAbsolute() );

        return flowNode.build();
    }

    @Override
    public void updateEntityFromDto(FlowNodeDTO flowNodeDTO, FlowNode flowNode) {
        if ( flowNodeDTO == null ) {
            return;
        }

        if ( flowNodeDTO.getType() != null ) {
            flowNode.setType( flowNodeDTO.getType() );
        }
        if ( flowNodeDTO.getPosition() != null ) {
            flowNode.setPosition( flowNodeDTO.getPosition() );
        }
        if ( flowNodeDTO.getWidth() != null ) {
            flowNode.setWidth( flowNodeDTO.getWidth() );
        }
        if ( flowNodeDTO.getHeight() != null ) {
            flowNode.setHeight( flowNodeDTO.getHeight() );
        }
        if ( flowNodeDTO.getSelected() != null ) {
            flowNode.setSelected( flowNodeDTO.getSelected() );
        }
        if ( flowNodeDTO.getDragging() != null ) {
            flowNode.setDragging( flowNodeDTO.getDragging() );
        }
        if ( flowNodeDTO.getPositionAbsolute() != null ) {
            flowNode.setPositionAbsolute( flowNodeDTO.getPositionAbsolute() );
        }
    }
}
