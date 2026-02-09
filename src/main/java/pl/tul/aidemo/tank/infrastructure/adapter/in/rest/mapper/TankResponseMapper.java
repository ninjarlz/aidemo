package pl.tul.aidemo.tank.infrastructure.adapter.in.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import pl.tul.aidemo.tank.application.dto.TankDTO;
import pl.tul.aidemo.tank.application.dto.TankNameListDTO;
import pl.tul.aidemo.tank.application.dto.TankSummaryDTO;
import pl.tul.aidemo.tank.infrastructure.adapter.in.rest.response.TankNameListResponse;
import pl.tul.aidemo.tank.infrastructure.adapter.in.rest.response.TankResponse;
import pl.tul.aidemo.tank.infrastructure.adapter.in.rest.response.TankSummaryResponse;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TankResponseMapper {
    TankResponse tankDTOtoResponse(TankDTO tankDTO);
    TankSummaryResponse summaryDTOtoResponse(TankSummaryDTO tankSummaryDTO);
    TankNameListResponse nameListDTOtoResponse(TankNameListDTO tankNameListDTO);
}
