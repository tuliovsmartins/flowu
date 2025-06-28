package com.flowu.mapper;

import com.flowu.dto.flownode.FlowNodeDTO;
import com.flowu.model.FlowNode;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel =  "spring",
        nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE
)
public interface FlowNodeMapper {

    FlowNodeDTO toDto(FlowNode flowNode);

    @Mapping(target = "flow", ignore = true)
    @Mapping(target = "executedSuccessCount", ignore = true)
    @Mapping(target = "executedErrorCount", ignore = true)
    FlowNode toEntity(FlowNodeDTO flowNodeDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "flow", ignore = true)
    @Mapping(target = "executedSuccessCount", ignore = true)
    @Mapping(target = "executedErrorCount", ignore = true)
    void updateEntityFromDto(FlowNodeDTO flowNodeDTO, @MappingTarget FlowNode flowNode);

}
