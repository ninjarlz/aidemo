package pl.tul.aidemo.tank.infrastructure.adapter.in.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.tul.aidemo.tank.application.dto.TankDTO;
import pl.tul.aidemo.tank.application.port.in.TankAnalysisUseCase;
import pl.tul.aidemo.tank.application.port.in.TankCrudUseCase;
import pl.tul.aidemo.tank.infrastructure.adapter.in.rest.mapper.TankResponseMapper;
import pl.tul.aidemo.tank.infrastructure.adapter.in.rest.response.TankNameListResponse;
import pl.tul.aidemo.tank.infrastructure.adapter.in.rest.response.TankResponse;
import pl.tul.aidemo.tank.infrastructure.adapter.in.rest.response.TankSummaryResponse;

import java.util.List;

import static pl.tul.aidemo.tank.infrastructure.adapter.in.rest.ApiUrls.STORM_TANKS_URL;
import static pl.tul.aidemo.tank.infrastructure.adapter.in.rest.ApiUrls.SUMMARY_URL;
import static pl.tul.aidemo.tank.infrastructure.adapter.in.rest.ApiUrls.TANK_INFO_URL;

@RestController
@RequiredArgsConstructor
@RequestMapping(TANK_INFO_URL)
public class TankRestController {

    private final TankCrudUseCase tankCrudUseCase;
    private final TankAnalysisUseCase tankAnalysisUseCase;
    private final TankResponseMapper responseMapper;

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public TankResponse saveTank(@RequestParam String tankName) {
        TankDTO tankDTO = tankAnalysisUseCase.describeTank(tankName);
        return responseMapper.tankDTOtoResponse(tankCrudUseCase.saveTank(tankDTO));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TankResponse> getTanks() {
        return tankCrudUseCase.getAllTanks()
                .stream()
                .map(responseMapper::tankDTOtoResponse)
                .toList();
    }

    @GetMapping(value = STORM_TANKS_URL, produces = MediaType.APPLICATION_JSON_VALUE)
    public TankNameListResponse identifyStormTanks() {
        return responseMapper.nameListDTOtoResponse(tankAnalysisUseCase.identifyStormTanks());
    }

    @GetMapping(value = SUMMARY_URL, produces = MediaType.APPLICATION_JSON_VALUE)
    public TankSummaryResponse summarizeTanks() {
        return responseMapper.summaryDTOtoResponse(tankAnalysisUseCase.summarizeTanks());
    }
}
