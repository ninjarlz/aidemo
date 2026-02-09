package pl.tul.aidemo.tank.infrastructure.adapter.out.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import pl.tul.aidemo.tank.domain.model.Tank;
import pl.tul.aidemo.tank.infrastructure.adapter.out.persistence.entity.TankPersistenceJpaEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TankPersistenceMapper {

    TankPersistenceJpaEntity toEntity(Tank domain);

    Tank toDomain(TankPersistenceJpaEntity entity);
}
