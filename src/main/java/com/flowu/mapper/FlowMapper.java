package com.flowu.mapper;


import com.flowu.dto.flow.FlowRequestDTO;
import com.flowu.dto.flow.FlowResponseDTO;
import com.flowu.model.Flow;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
    componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {FlowNodeMapper.class, FlowEdgeMapper.class}
)
public interface FlowMapper {

    FlowResponseDTO toResponseDto(Flow flow);
    @Mapping(target = "id", source = "id")
    @Mapping(target = "executedSuccessCount", ignore = true)
    @Mapping(target = "executedErrorCount", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Flow toEntity(FlowRequestDTO flowRequestDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "executedSuccessCount", ignore = true)
    @Mapping(target = "executedErrorCount", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntityFromDto(FlowRequestDTO flowRequestDTO, @MappingTarget Flow flow);
}
