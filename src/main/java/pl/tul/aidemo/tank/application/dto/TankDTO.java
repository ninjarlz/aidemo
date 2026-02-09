package pl.tul.aidemo.tank.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.tul.aidemo.tank.domain.model.TankType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TankDTO {
    private String name;
    private float massInTonnes;
    private int gunCaliberInMillimeters;
    private int frontArmourInMillimeters;
    private String countryOfOrigin;
    private TankType type;
}
