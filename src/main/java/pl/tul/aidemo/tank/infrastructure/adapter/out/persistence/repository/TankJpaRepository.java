package pl.tul.aidemo.tank.infrastructure.adapter.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tul.aidemo.tank.infrastructure.adapter.out.persistence.entity.TankPersistenceJpaEntity;

import java.util.Optional;

public interface TankJpaRepository extends JpaRepository<TankPersistenceJpaEntity, Long> {
    Optional<TankPersistenceJpaEntity> findByName(String name);
}
