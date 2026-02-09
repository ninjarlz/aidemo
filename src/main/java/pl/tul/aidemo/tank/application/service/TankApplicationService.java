package pl.tul.aidemo.tank.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tul.aidemo.tank.application.dto.TankDTO;
import pl.tul.aidemo.tank.application.dto.TankNameListDTO;
import pl.tul.aidemo.tank.application.dto.TankSummaryDTO;
import pl.tul.aidemo.tank.application.mapper.TankDTOMapper;
import pl.tul.aidemo.tank.application.port.in.TankAnalysisUseCase;
import pl.tul.aidemo.tank.application.port.in.TankCrudUseCase;
import pl.tul.aidemo.tank.application.port.out.TankAiPort;
import pl.tul.aidemo.tank.application.port.out.TankPersistencePort;
import pl.tul.aidemo.tank.domain.model.Tank;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TankApplicationService implements TankCrudUseCase, TankAnalysisUseCase {

    private final TankPersistencePort persistencePort;
    private final TankAiPort aiPort;
    private final TankDTOMapper dtoMapper;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public TankDTO saveTank(TankDTO tankDTO) {
        Tank tank = dtoMapper.toDomain(tankDTO);
        Optional<Tank> existing = persistencePort.findByName(tank.name());
        if (existing.isPresent()) {
            Tank updated = Tank.builder()
                    .id(existing.get().id())
                    .name(tank.name())
                    .massInTonnes(tank.massInTonnes())
                    .gunCaliberInMillimeters(tank.gunCaliberInMillimeters())
                    .frontArmourInMillimeters(tank.frontArmourInMillimeters())
                    .countryOfOrigin(tank.countryOfOrigin())
                    .type(tank.type())
                    .build();
            return dtoMapper.toDTO(persistencePort.save(updated));
        }
        return dtoMapper.toDTO(persistencePort.save(tank));
    }

    @Override
    public List<TankDTO> getAllTanks() {
        return persistencePort.findAll()
                .stream()
                .map(dtoMapper::toDTO)
                .toList();
    }

    @Override
    public TankDTO describeTank(String tankName) {
        return dtoMapper.toDTO(aiPort.describeTank(tankName));
    }

    @Override
    public TankSummaryDTO summarizeTanks() {
        return dtoMapper.toDTO(aiPort.summarizeTanks());
    }

    @Override
    public TankNameListDTO identifyStormTanks() {
        return dtoMapper.toDTO(aiPort.identifyStormTanks());
    }
}
