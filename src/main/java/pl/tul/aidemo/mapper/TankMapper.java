package pl.tul.aidemo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import pl.tul.aidemo.model.dto.TankDTO;
import pl.tul.aidemo.model.dto.TankNameListDTO;
import pl.tul.aidemo.model.dto.TankSummaryDTO;
import pl.tul.aidemo.model.entity.TankEntity;
import pl.tul.aidemo.model.response.TankNameListResponse;
import pl.tul.aidemo.model.response.TankResponse;
import pl.tul.aidemo.model.response.TankSummaryResponse;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TankMapper {
    TankEntity tankDTOtoEntity(TankDTO tankDTO);
    TankDTO tankEntityToDTO(TankEntity tankEntity);
    TankResponse tankDTOtoResponse(TankDTO tankDTO);
    TankSummaryResponse summaryDTOtoResponse(TankSummaryDTO tankSummaryDTO);
    TankNameListResponse nameListDTOtoResponse(TankNameListDTO tankNameListDTO);
}
