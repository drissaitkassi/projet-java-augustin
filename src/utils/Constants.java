package utils;

public class Constants {
    public Constants() {
    }

    public String getDB_URL() {
        return DB_URL;
    }


    public String getDB_USERNAME() {
        return DB_USERNAME;
    }


    public String getDB_PASSWORD() {
        return DB_PASSWORD;
    }


    public String getGET_ALL_PROGRAMMERS_QUERY() {
        return GET_ALL_PROGRAMMERS_QUERY;
    }


    public String getGET_A_PROGRAMMER_QUERY() {
        return GET_A_PROGRAMMER_QUERY;
    }


    public String getADD_PROGRAMMER_QUERY() {
        return ADD_PROGRAMMER_QUERY;
    }


    public String getUPDATE_PROGRAMMER_QUERY() {
        return UPDATE_PROGRAMMER_QUERY;
    }


    public String getDELETE_PROGRAMMER_QUERY() {
        return DELETE_PROGRAMMER_QUERY;
    }
    public String getMAX_ID() {
        return MAX_ID;
    }



    //****************CONSTANTS  DATABASE CONNECTION PARAMETERS **************
    private String DB_URL = "jdbc:postgresql://localhost:5432/javaprojet";
    private String DB_USERNAME = "postgres";
    private String DB_PASSWORD = "root";


    //****************CONSTANTS  QUERIES **************
    private String GET_ALL_PROGRAMMERS_QUERY = "SELECT * FROM programmeur";
    private String GET_A_PROGRAMMER_QUERY = "SELECT * FROM programmeur where id ="; // add input for id
    private String ADD_PROGRAMMER_QUERY = "INSERT INTO PROGRAMMEUR(NOM,PRENOM,ADRESSE,PSEUDO,RESPONSABLE,HOBBY,ANNAISSANCE,SALAIRE,PRIME)" +
            " VALUES(?,?,?,?,?,?,?,?,?)";

    private String UPDATE_PROGRAMMER_QUERY = "UPDATE programmeur SET nom = ?,prenom = ?,adresse= ?,\n" +
            "pseudo = ?,responsable = ?,\n" +
            "hobby = ?,annaissance = ?,\n" +
            "salaire = ?,prime = ? WHERE id="; // add input for id
    private String DELETE_PROGRAMMER_QUERY = "delete from programmeur where id ="; //add input for id

    private String MAX_ID="SELECT COUNT(id) FROM programmeur";


}