package pl.tul.aidemo.tank.infrastructure.adapter.out.ai;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tul.aidemo.tank.application.port.out.TankAiPort;
import pl.tul.aidemo.tank.domain.model.Tank;
import pl.tul.aidemo.tank.domain.model.TankNameList;
import pl.tul.aidemo.tank.domain.model.TankSummary;
import pl.tul.aidemo.tank.infrastructure.adapter.out.ai.mapper.TankAiMapper;

/**
 * Adapter converting langchain4j AI DTOs to domain models.
 * Separate from {@link TankAiAssistant} because langchain4j requires
 * mutable JavaBeans for deserialization, while domain uses immutable records.
 */
@Component
@RequiredArgsConstructor
public class TankAiAdapter implements TankAiPort {

    private final TankAiAssistant aiAssistant;
    private final TankAiMapper aiMapper;

    @Override
    public Tank describeTank(String tankName) {
        return aiMapper.toDomain(aiAssistant.describeTank(tankName));
    }

    @Override
    public TankSummary summarizeTanks() {
        return aiMapper.toDomain(aiAssistant.summarizeTanks());
    }

    @Override
    public TankNameList identifyStormTanks() {
        return aiMapper.toDomain(aiAssistant.identifyStormTanks());
    }
}
