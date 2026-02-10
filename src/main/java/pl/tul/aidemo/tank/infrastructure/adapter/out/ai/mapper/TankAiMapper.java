package pl.tul.aidemo.tank.infrastructure.adapter.out.ai.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import pl.tul.aidemo.tank.domain.model.Tank;
import pl.tul.aidemo.tank.domain.model.TankNameList;
import pl.tul.aidemo.tank.domain.model.TankSummary;
import pl.tul.aidemo.tank.infrastructure.adapter.out.ai.dto.TankAiDTO;
import pl.tul.aidemo.tank.infrastructure.adapter.out.ai.dto.TankNameListAiDTO;
import pl.tul.aidemo.tank.infrastructure.adapter.out.ai.dto.TankSummaryAiDTO;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TankAiMapper {

    @Mapping(target = "id", ignore = true)
    Tank toDomain(TankAiDTO dto);

    TankSummary toDomain(TankSummaryAiDTO dto);

    TankNameList toDomain(TankNameListAiDTO dto);
}
