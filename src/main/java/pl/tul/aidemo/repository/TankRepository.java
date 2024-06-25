package pl.tul.aidemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tul.aidemo.model.entity.TankEntity;

import java.util.Optional;

public interface TankRepository extends JpaRepository<TankEntity, Long> {
    Optional<TankEntity> findByName(String name);
}
