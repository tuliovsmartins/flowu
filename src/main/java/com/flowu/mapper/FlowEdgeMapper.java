package com.flowu.mapper;


import com.flowu.dto.flowedge.FlowEdgeDTO;
import com.flowu.model.FlowEdge;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel =  "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface FlowEdgeMapper {

    FlowEdgeDTO toDto(FlowEdge flowEdge);

    @Mapping(target = "flow", ignore = true)
    FlowEdge toEntity (FlowEdgeDTO flowEdgeDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "flow", ignore = true)
    void updateEntityFromDto(FlowEdgeDTO flowEdgeDTO, @MappingTarget FlowEdge flowEdge);

}
