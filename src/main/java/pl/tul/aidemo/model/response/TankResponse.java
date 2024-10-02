package pl.tul.aidemo.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.tul.aidemo.model.TankType;

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
