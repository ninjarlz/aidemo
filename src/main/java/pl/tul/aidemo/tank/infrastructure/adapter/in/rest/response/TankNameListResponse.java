package pl.tul.aidemo.tank.infrastructure.adapter.in.rest.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TankNameListResponse {
    private List<String> tankNames;
}
