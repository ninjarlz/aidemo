package pl.tul.aidemo.tank.domain.model;

import lombok.Builder;

/**
 * Domain value object representing a summary of tanks.
 */
@Builder
public record TankSummary(String summary) {
}
