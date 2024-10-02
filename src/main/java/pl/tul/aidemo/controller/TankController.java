package pl.tul.aidemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.tul.aidemo.mapper.TankMapper;
import pl.tul.aidemo.model.dto.TankDTO;
import pl.tul.aidemo.model.response.TankNameListResponse;
import pl.tul.aidemo.model.response.TankResponse;
import pl.tul.aidemo.model.response.TankSummaryResponse;
import pl.tul.aidemo.service.TankAiAssistant;
import pl.tul.aidemo.service.TankService;

import java.util.List;

import static pl.tul.aidemo.util.constant.ApiUrls.STORM_TANKS_URL;
import static pl.tul.aidemo.util.constant.ApiUrls.SUMMARY_URL;
import static pl.tul.aidemo.util.constant.ApiUrls.TANK_INFO_URL;

@RestController
@RequiredArgsConstructor
@RequestMapping(TANK_INFO_URL)
public class TankController {



    private final TankAiAssistant tankAiAssistant;
    private final TankService tankService;
    private final TankMapper tankMapper;

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public TankResponse saveTank(@RequestParam String tankName) {
        TankDTO tankDTO = tankAiAssistant.describeTank(tankName);
        return tankMapper.tankDTOtoResponse(tankService.saveTank(tankDTO));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TankResponse> getTanks() {
        return tankService.getAllTanks()
                .stream()
                .map(tankMapper::tankDTOtoResponse)
                .toList();
    }

    @GetMapping(value = STORM_TANKS_URL, produces = MediaType.APPLICATION_JSON_VALUE)
    public TankNameListResponse identifyStormTanks() {
        return tankMapper.nameListDTOtoResponse(tankAiAssistant.identifyStormTanks());
    }

    @GetMapping(value = SUMMARY_URL, produces = MediaType.APPLICATION_JSON_VALUE)
    public TankSummaryResponse summarizeTanks() {
        return tankMapper.summaryDTOtoResponse(tankAiAssistant.summarizeTanks());
    }
}
