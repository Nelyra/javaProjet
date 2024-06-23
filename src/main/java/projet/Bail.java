package projet;

import jakarta.persistence.*;

import javax.validation.constraints.Size;

@Entity
@Table(name = "bail")
public class Bail {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;

    @Size(max = 50)
    @Column(name = "dateDebut", length = 50)
    private String dateDebut;

    @Size(max = 50)
    @Column(name = "dateFin", length = 50)
    private String dateFin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProprio")
    private Personne idProprio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLocataire")
    private Personne idLocataire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAgentImmobilier")
    private Personne idAgentImmobilier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLocation")
    private Location idLocation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEtatEntree")
    private Etatdeslieux idEtatEntree;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEtatSortie")
    private Etatdeslieux idEtatSortie;

    public Bail() {
    }

    public Bail(Integer id) {
        this.id = id;
    }

    public Bail(String dateDebut, String dateFin, Personne idProprio, Personne idLocataire, Personne idAgentImmobilier, Location idLocation, Etatdeslieux idEtatEntree, Etatdeslieux idEtatSortie) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.idProprio = idProprio;
        this.idLocataire = idLocataire;
        this.idAgentImmobilier = idAgentImmobilier;
        this.idLocation = idLocation;
        this.idEtatEntree = idEtatEntree;
        this.idEtatSortie = idEtatSortie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public Personne getIdProprio() {
        return idProprio;
    }

    public void setIdProprio(Personne idProprio) {
        this.idProprio = idProprio;
    }

    public Personne getIdLocataire() {
        return idLocataire;
    }

    public void setIdLocataire(Personne idLocataire) {
        this.idLocataire = idLocataire;
    }

    public Personne getIdAgentImmobilier() {
        return idAgentImmobilier;
    }

    public void setIdAgentImmobilier(Personne idAgentImmobilier) {
        this.idAgentImmobilier = idAgentImmobilier;
    }

    public Location getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Location idLocation) {
        this.idLocation = idLocation;
    }

    public Etatdeslieux getIdEtatEntree() {
        return idEtatEntree;
    }

    public void setIdEtatEntree(Etatdeslieux idEtatEntree) {
        this.idEtatEntree = idEtatEntree;
    }

    public Etatdeslieux getIdEtatSortie() {
        return idEtatSortie;
    }

    public void setIdEtatSortie(Etatdeslieux idEtatSortie) {
        this.idEtatSortie = idEtatSortie;
    }

}