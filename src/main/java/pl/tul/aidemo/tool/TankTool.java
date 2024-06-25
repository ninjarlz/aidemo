package pl.tul.aidemo.tool;

import dev.langchain4j.agent.tool.Tool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tul.aidemo.model.dto.TankDTO;
import pl.tul.aidemo.service.TankService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TankTool {

    private final TankService tankService;

    @Tool("Get data of persisted tanks for summary and analysis.")
    public List<TankDTO> getPersistedTanksData() {
        return tankService.getAllTanks();
    }
}
