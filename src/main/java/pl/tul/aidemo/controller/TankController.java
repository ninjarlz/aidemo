package pl.tul.aidemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.tul.aidemo.model.dto.TankDTO;
import pl.tul.aidemo.model.dto.TankNameListDTO;
import pl.tul.aidemo.model.dto.TankSummaryDTO;
import pl.tul.aidemo.service.TankAiAssistant;
import pl.tul.aidemo.service.TankService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TankController {

    private final String TANK_INFO_URL = "/tankInfo";

    private final TankAiAssistant tankAiAssistant;
    private final TankService tankService;

    @PutMapping(TANK_INFO_URL)
    public TankDTO saveTank(@RequestParam("tankName") String tankName) {
        TankDTO tankDTO = tankAiAssistant.describeTank(tankName);
        return tankService.saveTank(tankDTO);
    }

    @GetMapping(TANK_INFO_URL)
    public List<TankDTO> getTanks() {
        return tankService.getAllTanks();
    }

    @GetMapping(TANK_INFO_URL + "/stormTanks")
    public TankNameListDTO identifyStormTanks() {
        return tankAiAssistant.identifyStormTanks();
    }

    @GetMapping(TANK_INFO_URL + "/summary")
    public TankSummaryDTO summarizeTanks() {
        return tankAiAssistant.summarizeTanks();
    }
}
