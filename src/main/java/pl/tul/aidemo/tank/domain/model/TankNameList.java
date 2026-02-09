package pl.tul.aidemo.tank.domain.model;

import lombok.Builder;

import java.util.List;

/**
 * Domain value object representing a list of tank names.
 */
@Builder
public record TankNameList(List<String> tankNames) {
}
