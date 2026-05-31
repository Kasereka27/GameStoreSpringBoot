package edu.upc.gamestore.models;
import edu.upc.gamestore.models.enums.Category;
import edu.upc.gamestore.models.enums.Plateform;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "video_games")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VideoGame {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Le titre ne peut pas être vide")
    private String title;

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    @NotBlank(message = "La plateforme est obligatoire")
    private Plateform plateform;

    @Column(nullable = false)
    @Min(value = 1950, message = "L'année de sortie doit être postérieure à 1950")
    @Max(value = 2100, message = "L'année de sortie est invalide")
    private int releaseYear;

    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    @NotBlank(message = "La catégorie est recommandée")
    private Category category;

    @Column(nullable = false)
    @NotNull(message = "Le prix est obligatoire")
    @PositiveOrZero(message = "Le prix ne peut pas être négatif")
    private Double price;
}
