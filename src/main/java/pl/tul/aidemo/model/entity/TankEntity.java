package pl.tul.aidemo.model.entity;


import jakarta.persistence.*;
import lombok.*;
import pl.tul.aidemo.model.TankType;

@Entity(name = "tank")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TankEntity {

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
