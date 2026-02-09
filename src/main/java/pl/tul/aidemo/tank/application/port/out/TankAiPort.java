package pl.tul.aidemo.tank.application.port.out;

import pl.tul.aidemo.tank.domain.model.Tank;
import pl.tul.aidemo.tank.domain.model.TankNameList;
import pl.tul.aidemo.tank.domain.model.TankSummary;

/**
 * Outbound port for AI-powered tank operations.
 */
public interface TankAiPort {

    Tank describeTank(String tankName);

    TankSummary summarizeTanks();

    TankNameList identifyStormTanks();
}
