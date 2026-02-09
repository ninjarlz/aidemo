package pl.tul.aidemo.tank.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import pl.tul.aidemo.tank.application.dto.TankDTO;
import pl.tul.aidemo.tank.application.dto.TankNameListDTO;
import pl.tul.aidemo.tank.application.dto.TankSummaryDTO;
import pl.tul.aidemo.tank.domain.model.Tank;
import pl.tul.aidemo.tank.domain.model.TankNameList;
import pl.tul.aidemo.tank.domain.model.TankSummary;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TankDTOMapper {

    @Mapping(target = "id", ignore = true)
    Tank toDomain(TankDTO dto);

    TankDTO toDTO(Tank domain);

    TankSummary toDomain(TankSummaryDTO dto);

    TankSummaryDTO toDTO(TankSummary domain);

    TankNameList toDomain(TankNameListDTO dto);

    TankNameListDTO toDTO(TankNameList domain);
}
