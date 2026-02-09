package pl.tul.aidemo.tank.domain.model;

import lombok.Builder;

@Builder
public record Tank(
        Long id,
        String name,
        float massInTonnes,
        int gunCaliberInMillimeters,
        int frontArmourInMillimeters,
        String countryOfOrigin,
        TankType type
) {
}
