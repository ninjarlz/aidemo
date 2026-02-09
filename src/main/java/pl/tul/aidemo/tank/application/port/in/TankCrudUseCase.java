package pl.tul.aidemo.tank.application.port.in;

import pl.tul.aidemo.tank.application.dto.TankDTO;

import java.util.List;

/**
 * Use case for tank CRUD operations.
 */
public interface TankCrudUseCase {

    /**
     * Persists the given {@link TankDTO}. If a tank with the same name already exists,
     * it will be updated (upsert).
     *
     * @param tankDTO the tank data to save
     * @return the saved tank data
     */
    TankDTO saveTank(TankDTO tankDTO);

    /**
     * Returns all persisted tanks.
     *
     * @return list of all tank DTOs
     */
    List<TankDTO> getAllTanks();
}
