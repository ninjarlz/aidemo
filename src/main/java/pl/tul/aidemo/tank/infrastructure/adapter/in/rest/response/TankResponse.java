package pl.tul.aidemo.tank.infrastructure.adapter.in.rest.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.tul.aidemo.tank.domain.model.TankType;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TankResponse {
    private String name;
    private float massInTonnes;
    private int gunCaliberInMillimeters;
    private int frontArmourInMillimeters;
    private String countryOfOrigin;
    private TankType type;
}
