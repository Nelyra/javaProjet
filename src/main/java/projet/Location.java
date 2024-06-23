package projet;

import jakarta.persistence.*;
import projet.Adresse;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAdresse")
    private Adresse idAdresse;

    @Column(name = "appartement")
    private Integer appartement;

    public Location() {
    }

    public Location(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Adresse getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(Adresse idAdresse) {
        this.idAdresse = idAdresse;
    }

    public Integer getAppartement() {
        return appartement;
    }

    public void setAppartement(Integer appartement) {
        this.appartement = appartement;
    }

}