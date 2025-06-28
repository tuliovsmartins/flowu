package com.flowu.mapper;

import com.flowu.dto.flow.FlowRequestDTO;
import com.flowu.dto.flow.FlowResponseDTO;
import com.flowu.dto.flowedge.FlowEdgeDTO;
import com.flowu.dto.flownode.FlowNodeDTO;
import com.flowu.model.Flow;
import com.flowu.model.FlowEdge;
import com.flowu.model.FlowNode;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-23T22:54:10-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class FlowMapperImpl implements FlowMapper {

    @Autowired
    private FlowNodeMapper flowNodeMapper;
    @Autowired
    private FlowEdgeMapper flowEdgeMapper;

    @Override
    public FlowResponseDTO toResponseDto(Flow flow) {
        if ( flow == null ) {
            return null;
        }

        FlowResponseDTO.FlowResponseDTOBuilder flowResponseDTO = FlowResponseDTO.builder();

        flowResponseDTO.id( flow.getId() );
        flowResponseDTO.title( flow.getTitle() );
        flowResponseDTO.userId( flow.getUserId() );
        flowResponseDTO.companyId( flow.getCompanyId() );
        flowResponseDTO.executedSuccessCount( flow.getExecutedSuccessCount() );
        flowResponseDTO.executedErrorCount( flow.getExecutedErrorCount() );
        flowResponseDTO.createdAt( flow.getCreatedAt() );
        flowResponseDTO.updatedAt( flow.getUpdatedAt() );
        flowResponseDTO.nodes( flowNodeListToFlowNodeDTOList( flow.getNodes() ) );
        flowResponseDTO.edges( flowEdgeListToFlowEdgeDTOList( flow.getEdges() ) );

        return flowResponseDTO.build();
    }

    @Override
    public Flow toEntity(FlowRequestDTO flowRequestDTO) {
        if ( flowRequestDTO == null ) {
            return null;
        }

        Flow.FlowBuilder flow = Flow.builder();

        flow.id( flowRequestDTO.getId() );
        flow.title( flowRequestDTO.getTitle() );
        flow.userId( flowRequestDTO.getUserId() );
        flow.companyId( flowRequestDTO.getCompanyId() );
        flow.nodes( flowNodeDTOListToFlowNodeList( flowRequestDTO.getNodes() ) );
        flow.edges( flowEdgeDTOListToFlowEdgeList( flowRequestDTO.getEdges() ) );

        return flow.build();
    }

    @Override
    public void updateEntityFromDto(FlowRequestDTO flowRequestDTO, Flow flow) {
        if ( flowRequestDTO == null ) {
            return;
        }

        if ( flowRequestDTO.getTitle() != null ) {
            flow.setTitle( flowRequestDTO.getTitle() );
        }
        if ( flowRequestDTO.getUserId() != null ) {
            flow.setUserId( flowRequestDTO.getUserId() );
        }
        if ( flowRequestDTO.getCompanyId() != null ) {
            flow.setCompanyId( flowRequestDTO.getCompanyId() );
        }
        if ( flow.getNodes() != null ) {
            List<FlowNode> list = flowNodeDTOListToFlowNodeList( flowRequestDTO.getNodes() );
            if ( list != null ) {
                flow.getNodes().clear();
                flow.getNodes().addAll( list );
            }
        }
        else {
            List<FlowNode> list = flowNodeDTOListToFlowNodeList( flowRequestDTO.getNodes() );
            if ( list != null ) {
                flow.setNodes( list );
            }
        }
        if ( flow.getEdges() != null ) {
            List<FlowEdge> list1 = flowEdgeDTOListToFlowEdgeList( flowRequestDTO.getEdges() );
            if ( list1 != null ) {
                flow.getEdges().clear();
                flow.getEdges().addAll( list1 );
            }
        }
        else {
            List<FlowEdge> list1 = flowEdgeDTOListToFlowEdgeList( flowRequestDTO.getEdges() );
            if ( list1 != null ) {
                flow.setEdges( list1 );
            }
        }
    }

    protected List<FlowNodeDTO> flowNodeListToFlowNodeDTOList(List<FlowNode> list) {
        if ( list == null ) {
            return null;
        }

        List<FlowNodeDTO> list1 = new ArrayList<FlowNodeDTO>( list.size() );
        for ( FlowNode flowNode : list ) {
            list1.add( flowNodeMapper.toDto( flowNode ) );
        }

        return list1;
    }

    protected List<FlowEdgeDTO> flowEdgeListToFlowEdgeDTOList(List<FlowEdge> list) {
        if ( list == null ) {
            return null;
        }

        List<FlowEdgeDTO> list1 = new ArrayList<FlowEdgeDTO>( list.size() );
        for ( FlowEdge flowEdge : list ) {
            list1.add( flowEdgeMapper.toDto( flowEdge ) );
        }

        return list1;
    }

    protected List<FlowNode> flowNodeDTOListToFlowNodeList(List<FlowNodeDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<FlowNode> list1 = new ArrayList<FlowNode>( list.size() );
        for ( FlowNodeDTO flowNodeDTO : list ) {
            list1.add( flowNodeMapper.toEntity( flowNodeDTO ) );
        }

        return list1;
    }

    protected List<FlowEdge> flowEdgeDTOListToFlowEdgeList(List<FlowEdgeDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<FlowEdge> list1 = new ArrayList<FlowEdge>( list.size() );
        for ( FlowEdgeDTO flowEdgeDTO : list ) {
            list1.add( flowEdgeMapper.toEntity( flowEdgeDTO ) );
        }

        return list1;
    }
}
