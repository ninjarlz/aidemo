package pl.tul.aidemo.tank.infrastructure.adapter.out.ai;

import dev.langchain4j.agent.tool.Tool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tul.aidemo.tank.application.port.out.TankPersistencePort;
import pl.tul.aidemo.tank.domain.model.Tank;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TankTool {

    private final TankPersistencePort persistencePort;

    @Tool("Get data of persisted tanks for summary and analysis.")
    public List<Tank> getPersistedTanksData() {
        return persistencePort.findAll();
    }
}
