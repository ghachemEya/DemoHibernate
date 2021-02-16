package net.javaguides.hibernate.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="categorie")
public class Categorie {


    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;


    @Column(name = "libelle")
    private String libelle;

    public Categorie(){

    }

    public Categorie(String lib){
        this.libelle = lib;
    }

    public String getLibelle(){
        return libelle;
    }

    public void setLibelle(String lib){
        this.libelle = lib;
    }

    @Override
	public String toString() {
		return "Categorie [id=" + id + ", libelle=" + libelle + "]";
	}
}
