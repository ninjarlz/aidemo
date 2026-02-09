package pl.tul.aidemo.tank.infrastructure.adapter.out.ai;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;
import pl.tul.aidemo.tank.infrastructure.adapter.out.ai.dto.TankAiDto;
import pl.tul.aidemo.tank.infrastructure.adapter.out.ai.dto.TankNameListAiDto;
import pl.tul.aidemo.tank.infrastructure.adapter.out.ai.dto.TankSummaryAiDto;

/**
 * Langchain4j AI service interface.
 * Returns mutable AI DTOs (not domain records) because langchain4j
 * requires setter-based JavaBeans for JSON deserialization.
 */
@AiService
public interface TankAiAssistant {

    @UserMessage("Give me information about tank with name {{tankName}}. Do not execute any tool.")
    TankAiDto describeTank(@V("tankName") String tankName);

    @UserMessage("Prepare concise and interesting summary about persisted tanks. " +
            "Summary should cover different aspects of tanks.")
    TankSummaryAiDto summarizeTanks();

    @UserMessage("Identify names of best tanks for participating in storm (or front attack on densely defended positions) " +
            "within set of persisted tanks.")
    @SystemMessage("Storm tanks are characterized by huge gun and thick front armour.")
    TankNameListAiDto identifyStormTanks();
}
