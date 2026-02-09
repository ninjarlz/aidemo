package pl.tul.aidemo.tank.infrastructure.adapter.out.ai.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Mutable DTO for langchain4j AI deserialization of tank name lists.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TankNameListAiDto {
    private List<String> tankNames;
}
