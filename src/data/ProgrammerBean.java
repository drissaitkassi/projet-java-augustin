package data;

public class ProgrammerBean {
    public ProgrammerBean() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPreNom() {
        return preNom;
    }

    public void setPreNom(String preNom) {
        this.preNom = preNom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getAnnissance() {
        return annissance;
    }

    public void setAnnissance(String annissance) {
        this.annissance = annissance;
    }

    public String getPrime() {
        return prime;
    }

    public void setPrime(String prime) {
        this.prime = prime;
    }

    private String nom;
    private String preNom;
    private String adresse;
    private String pseudo;
    private String responsable;

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    private String hobby;
    private String annissance;
    private String salaire;
    private String prime;


    public ProgrammerBean(String nom, String preNom, String adresse, String pseudo, String hobby, String annissance, String salaire, String prime) {
        this.nom = nom;
        this.preNom = preNom;
        this.adresse = adresse;
        this.pseudo = pseudo;
        this.hobby = hobby;
        this.annissance = annissance;
        this.salaire = salaire;
        this.prime = prime;
    }

    public String getSalaire() {
        return salaire;
    }

    public void setSalaire(String salaire) {
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        return "ProgrammerBean{" +
                "nom='" + nom + '\'' +
                ", preNom='" + preNom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", hobby='" + hobby + '\'' +
                ", annissance='" + annissance + '\'' +
                ", salaire='" + salaire + '\'' +
                ", prime='" + prime + '\'' +
                '}';
    }
}
