package projet;

import jakarta.persistence.*;

import javax.validation.constraints.Size;

@Entity
@Table(name = "etatdeslieux")
public class Etatdeslieux {
    @Id
    @Column(name = "idEtat", nullable = false)
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;

    @Size(max = 250)
    @Column(name = "commentaire", length = 250)
    private String commentaire;

    public Etatdeslieux() {
    }

    public Etatdeslieux(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

}