package utils;

public class Constants {
    public Constants() {
    }

    public String getDB_URL() {
        return DB_URL;
    }

    public void setDB_URL(String DB_URL) {
        this.DB_URL = DB_URL;
    }

    public String getDB_USERNAME() {
        return DB_USERNAME;
    }

    public void setDB_USERNAME(String DB_USERNAME) {
        this.DB_USERNAME = DB_USERNAME;
    }

    public String getDB_PASSWORD() {
        return DB_PASSWORD;
    }

    public void setDB_PASSWORD(String DB_PASSWORD) {
        this.DB_PASSWORD = DB_PASSWORD;
    }

    public String getGET_ALL_PROGRAMMERS_QUERY() {
        return GET_ALL_PROGRAMMERS_QUERY;
    }

    public void setGET_ALL_PROGRAMMERS_QUERY(String GET_ALL_PROGRAMMERS_QUERY) {
        this.GET_ALL_PROGRAMMERS_QUERY = GET_ALL_PROGRAMMERS_QUERY;
    }

    public String getGET_A_PROGRAMMER_QUERY() {
        return GET_A_PROGRAMMER_QUERY;
    }

    public void setGET_A_PROGRAMMER_QUERY(String GET_A_PROGRAMMER_QUERY) {
        this.GET_A_PROGRAMMER_QUERY = GET_A_PROGRAMMER_QUERY;
    }

    public String getADD_PROGRAMMER_QUERY() {
        return ADD_PROGRAMMER_QUERY;
    }

    public void setADD_PROGRAMMER_QUERY(String ADD_PROGRAMMER_QUERY) {
        this.ADD_PROGRAMMER_QUERY = ADD_PROGRAMMER_QUERY;
    }

    public String getUPDATE_PROGRAMMER_QUERY() {
        return UPDATE_PROGRAMMER_QUERY;
    }

    public void setUPDATE_PROGRAMMER_QUERY(String UPDATE_PROGRAMMER_QUERY) {
        this.UPDATE_PROGRAMMER_QUERY = UPDATE_PROGRAMMER_QUERY;
    }

    public String getDELETE_PROGRAMMER_QUERY() {
        return DELETE_PROGRAMMER_QUERY;
    }

    public void setDELETE_PROGRAMMER_QUERY(String DELETE_PROGRAMMER_QUERY) {
        this.DELETE_PROGRAMMER_QUERY = DELETE_PROGRAMMER_QUERY;
        //lklk
    }

    private String DB_URL = "jdbc:postgresql://localhost:5432/javaprojet";
    private String DB_USERNAME = "postgres";
    private String DB_PASSWORD = "root";

    //Constants queries
    private String GET_ALL_PROGRAMMERS_QUERY = "SELECT * FROM programmeur";
    private String GET_A_PROGRAMMER_QUERY = "SELECT * FROM programmeur where id ="; // add input for id
    private String ADD_PROGRAMMER_QUERY = "INSERT INTO PROGRAMMEUR(NOM,PRENOM,ADRESSE,PSEUDO,RESPONSABLE,HOBBY,ANNAISSANCE,SALAIRE,PRIME)" +
            " VALUES(?,?,?,?,?,?,?,?,?)";

    private String UPDATE_PROGRAMMER_QUERY = "UPDATE programmeur SET nom = ?,prenom = ?,adresse= ?,\n" +
            "pseudo = ?,responsable = ?,\n" +
            "hobby = ?,annaissance = ?,\n" +
            "salaire = ?,prime = ? WHERE id="; // add input for id
    private String DELETE_PROGRAMMER_QUERY = "delete from programmeur where id ="; //add input for id

    private String MAX_ID="SELECT id FROM programmeur ORDER BY id DESC LIMIT 1";

    public String getMAX_ID() {
        return MAX_ID;
    }

    public void setMAX_ID(String MAX_ID) {
        this.MAX_ID = MAX_ID;
    }
}