package pl.tul.aidemo.service;

import dev.langchain4j.agent.tool.Tool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tul.aidemo.model.dto.TankDTO;
import pl.tul.aidemo.model.entity.TankEntity;
import pl.tul.aidemo.repository.TankRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TankService {

    private final TankRepository tankRepository;

    public TankDTO saveTank(TankDTO tank) {
        var optionalEntity = tankRepository.findByName(tank.getName());
        if (optionalEntity.isPresent()) {
            var persistedEntity = optionalEntity.get();
            var modifiedEntity = mapTankDTO(tank);
            modifiedEntity.setId(persistedEntity.getId());
            return mapTankEntity(tankRepository.save(modifiedEntity));
        }
        var entity = mapTankDTO(tank);
        return mapTankEntity(tankRepository.save(entity));
    }

    @Tool("Get data of persisted tanks for summary.")
    public List<TankDTO> getAllTanks() {
        return tankRepository.findAll()
                .stream()
                .map(this::mapTankEntity)
                .toList();
    }

    private TankEntity mapTankDTO(TankDTO tankDTO) {
        return TankEntity.builder()
                .countryOfOrigin(tankDTO.getCountryOfOrigin())
                .gunCaliberInMillimeters(tankDTO.getGunCaliberInMillimeters())
                .name(tankDTO.getName())
                .massInTonnes(tankDTO.getMassInTonnes())
                .type(tankDTO.getType())
                .frontArmourInMillimeters(tankDTO.getFrontArmourInMillimeters())
                .build();
    }

    private TankDTO mapTankEntity(TankEntity tankEntity) {
        return TankDTO.builder()
                .countryOfOrigin(tankEntity.getCountryOfOrigin())
                .gunCaliberInMillimeters(tankEntity.getGunCaliberInMillimeters())
                .name(tankEntity.getName())
                .massInTonnes(tankEntity.getMassInTonnes())
                .type(tankEntity.getType())
                .frontArmourInMillimeters(tankEntity.getFrontArmourInMillimeters())
                .build();
    }
}
