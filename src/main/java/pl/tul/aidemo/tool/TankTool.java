package pl.tul.aidemo.tool;

import dev.langchain4j.agent.tool.P;
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

//  TODO: Remove placeholder parameter once langchain4j OLLAMA implementation will allow to specify tools without params
    @Tool("Get data of persisted tanks for summary and analysis.")
    public List<TankDTO> getPersistedTanksData(@P(value = "Random integer.", required = false) int randomInteger) {
        return tankService.getAllTanks();
    }
}
