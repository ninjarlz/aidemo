package pl.tul.aidemo.tank.infrastructure.adapter.in.rest.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TankSummaryResponse {
    private String summary;
}
