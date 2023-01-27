package utils;

public class Constants {



    //****************CONSTANTS  DATABASE CONNECTION PARAMETERS **************
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/javaprojet";
    public static final String DB_USERNAME = "postgres";
    public static final String DB_PASSWORD = "root";


    //****************CONSTANTS  QUERIES **************
    public static final String GET_ALL_PROGRAMMERS_QUERY = "SELECT * FROM programmeur";
    public static final String GET_A_PROGRAMMER_QUERY = "SELECT * FROM programmeur where id ="; // add input for id
    public static final String ADD_PROGRAMMER_QUERY = "INSERT INTO PROGRAMMEUR(NOM,PRENOM,ADRESSE,PSEUDO,RESPONSABLE,HOBBY,ANNAISSANCE,SALAIRE,PRIME)" +
            " VALUES(?,?,?,?,?,?,?,?,?)";

    public static final String UPDATE_PROGRAMMER_QUERY = "UPDATE programmeur SET nom = ?,prenom = ?,adresse= ?,\n" +
            "pseudo = ?,responsable = ?,\n" +
            "hobby = ?,annaissance = ?,\n" +
            "salaire = ?,prime = ? WHERE id="; // add input for id
    public static final String DELETE_PROGRAMMER_QUERY = "delete from programmeur where id ="; //add input for id

    public static final String MAX_ID="SELECT COUNT(id) FROM programmeur";


}