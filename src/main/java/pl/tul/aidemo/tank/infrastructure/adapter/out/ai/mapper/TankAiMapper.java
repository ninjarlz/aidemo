package pl.tul.aidemo.tank.infrastructure.adapter.out.ai.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import pl.tul.aidemo.tank.domain.model.Tank;
import pl.tul.aidemo.tank.domain.model.TankNameList;
import pl.tul.aidemo.tank.domain.model.TankSummary;
import pl.tul.aidemo.tank.infrastructure.adapter.out.ai.dto.TankAiDto;
import pl.tul.aidemo.tank.infrastructure.adapter.out.ai.dto.TankNameListAiDto;
import pl.tul.aidemo.tank.infrastructure.adapter.out.ai.dto.TankSummaryAiDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TankAiMapper {

    @Mapping(target = "id", ignore = true)
    Tank toDomain(TankAiDto dto);

    TankSummary toDomain(TankSummaryAiDto dto);

    TankNameList toDomain(TankNameListAiDto dto);
}
