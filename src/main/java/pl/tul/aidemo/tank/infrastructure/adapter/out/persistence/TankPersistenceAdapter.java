package pl.tul.aidemo.tank.infrastructure.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tul.aidemo.tank.application.port.out.TankPersistencePort;
import pl.tul.aidemo.tank.domain.model.Tank;
import pl.tul.aidemo.tank.infrastructure.adapter.out.persistence.entity.TankPersistenceJpaEntity;
import pl.tul.aidemo.tank.infrastructure.adapter.out.persistence.mapper.TankPersistenceMapper;
import pl.tul.aidemo.tank.infrastructure.adapter.out.persistence.repository.TankJpaRepository;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TankPersistenceAdapter implements TankPersistencePort {

    private final TankJpaRepository repository;
    private final TankPersistenceMapper mapper;

    @Override
    public Tank save(Tank tank) {
        TankPersistenceJpaEntity entity = mapper.toEntity(tank);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public Optional<Tank> findByName(String name) {
        return repository.findByName(name).map(mapper::toDomain);
    }

    @Override
    public List<Tank> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }
}
