package projet;

import jakarta.persistence.*;

import javax.validation.constraints.Size;

@Entity
@NamedQueries({
       @NamedQuery(
               name = "Personne.GetById",
               query = "SELECT p FROM Personne p WHERE p.id = :personid"
       )
})
@Table(name = "personne")
public class Personne {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 20)
    @Column(name = "nom", length = 20)
    private String nom;

    @Size(max = 20)
    @Column(name = "prenom", length = 20)
    private String prenom;

    @Size(max = 50)
    @Column(name = "mail", length = 50)
    private String mail;

    @Column(name = "telephone")
    private Integer telephone;

    @Column(name = "type")
    private Integer type;

    @Column(name = "rib")
    private Integer rib;

    @Column(name = "numeroSecu")
    private Integer numeroSecu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getRib() {
        return rib;
    }

    public void setRib(Integer rib) {
        this.rib = rib;
    }

    public Integer getNumeroSecu() {
        return numeroSecu;
    }

    public void setNumeroSecu(Integer numeroSecu) {
        this.numeroSecu = numeroSecu;
    }

    public String toString() {
        return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", telephone=" + telephone + ", type=" + type + ", rib=" + rib + ", numeroSecu=" + numeroSecu + "]";
    }
}