package projet;

import jakarta.persistence.*;

import javax.validation.constraints.Size;

@Entity
@Table(name = "adresse")
public class Adresse {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;

    @Size(max = 20)
    @Column(name = "ville", length = 20)
    private String ville;

    @Size(max = 20)
    @Column(name = "rue", length = 20)
    private String rue;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "codePostal")
    private Integer codePostal;

    public Adresse() {

    }

    public Adresse(String ville, String rue, Integer numero, Integer codePostal) {
        this.ville = ville;
        this.rue = rue;
        this.numero = numero;
        this.codePostal = codePostal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(Integer codePostal) {
        this.codePostal = codePostal;
    }


}