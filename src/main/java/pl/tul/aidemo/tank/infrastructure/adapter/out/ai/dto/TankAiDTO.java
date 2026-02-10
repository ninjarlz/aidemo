package pl.tul.aidemo.tank.infrastructure.adapter.out.ai.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.tul.aidemo.tank.domain.model.TankType;

/**
 * Mutable DTO for langchain4j AI deserialization of tank data.
 * Langchain4j requires JavaBean-style classes (setters + no-arg constructor)
 * for structured output extraction — domain records cannot be used directly.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TankAiDTO {
    private String name;
    private float massInTonnes;
    private int gunCaliberInMillimeters;
    private int frontArmourInMillimeters;
    private String countryOfOrigin;
    private TankType type;
}
