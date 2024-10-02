package pl.tul.aidemo.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tul.aidemo.mapper.TankMapper;
import pl.tul.aidemo.model.dto.TankDTO;
import pl.tul.aidemo.repository.TankRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TankService {

    private final TankRepository tankRepository;
    private final TankMapper tankMapper;

    @Transactional(rollbackOn = Exception.class)
    public TankDTO saveTank(TankDTO tank) {
        var optionalEntity = tankRepository.findByName(tank.getName());
        if (optionalEntity.isPresent()) {
            var persistedEntity = optionalEntity.get();
            var modifiedEntity = tankMapper.tankDTOtoEntity(tank);
            modifiedEntity.setId(persistedEntity.getId());
            return tankMapper.tankEntityToDTO(tankRepository.save(modifiedEntity));
        }
        var entity = tankMapper.tankDTOtoEntity(tank);
        return tankMapper.tankEntityToDTO(tankRepository.save(entity));
    }

    public List<TankDTO> getAllTanks() {
        return tankRepository.findAll()
                .stream()
                .map(tankMapper::tankEntityToDTO)
                .toList();
    }
}
