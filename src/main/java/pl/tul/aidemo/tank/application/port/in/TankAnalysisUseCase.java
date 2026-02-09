package pl.tul.aidemo.tank.application.port.in;

import pl.tul.aidemo.tank.application.dto.TankDTO;
import pl.tul.aidemo.tank.application.dto.TankNameListDTO;
import pl.tul.aidemo.tank.application.dto.TankSummaryDTO;

/**
 * Use case for AI-powered tank analysis operations.
 */
public interface TankAnalysisUseCase {

    /**
     * Generates tank information from AI based on the given tank name.
     *
     * @param tankName the name of the tank to describe
     * @return the generated tank data
     */
    TankDTO describeTank(String tankName);

    /**
     * Generates a concise summary about persisted tanks using AI.
     *
     * @return the tank summary
     */
    TankSummaryDTO summarizeTanks();

    /**
     * Identifies tanks best suited for storm (front attack) operations
     * from the set of persisted tanks using AI.
     *
     * @return list of tank names suitable for storm operations
     */
    TankNameListDTO identifyStormTanks();
}
