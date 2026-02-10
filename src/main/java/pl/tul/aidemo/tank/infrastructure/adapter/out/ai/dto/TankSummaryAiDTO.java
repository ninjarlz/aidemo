package pl.tul.aidemo.tank.infrastructure.adapter.out.ai.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Mutable DTO for langchain4j AI deserialization of tank summaries.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TankSummaryAiDTO {
    private String summary;
}
