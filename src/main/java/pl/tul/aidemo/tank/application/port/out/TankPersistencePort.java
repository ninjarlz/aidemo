package pl.tul.aidemo.tank.application.port.out;

import pl.tul.aidemo.tank.domain.model.Tank;

import java.util.List;
import java.util.Optional;

/**
 * Outbound port for tank persistence operations.
 */
public interface TankPersistencePort {

    Tank save(Tank tank);

    Optional<Tank> findByName(String name);

    List<Tank> findAll();
}
