package pl.tul.aidemo.tank.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import pl.tul.aidemo.tank.domain.model.TankType;

@Entity(name = "tank")
@Table(name = "tank")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TankPersistenceJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    private float massInTonnes;
    private int gunCaliberInMillimeters;
    private int frontArmourInMillimeters;
    private String countryOfOrigin;
    @Enumerated(EnumType.STRING)
    private TankType type;
}
